package com.taiji.eap.common.easypoi.excel.core;

import com.taiji.eap.common.easypoi.excel.annotation.Excel;
import com.taiji.eap.common.easypoi.excel.annotation.ExcelId;
import com.taiji.eap.common.easypoi.excel.annotation.ExcelList;
import com.taiji.eap.common.excle.config.ElementTypePath;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.lang.reflect.*;
import java.util.*;

public abstract class AbstractExcelUtil<T> implements IExcelUtil<T> {

    /**
     * 将excel 数据转化为list
     * @param sheet
     * @return
     */
    public abstract List<T> transition(int dataRow,HSSFSheet sheet);

    /**
     * 获取所有字段
     * @param clazz
     * @return
     */
    protected List<Field> getAllField(Class<?> clazz,List<Field> listField){
        if (listField == null) {
            listField = new ArrayList<>();
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields) {
            Type fieldType = field.getType();
            if(field.isAnnotationPresent(Excel.class)){
                listField.add(field);
            }else if(field.isAnnotationPresent(ExcelList.class)){
                switch (ElementTypePath.getElementTypePath(fieldType.getTypeName())) {
                    case SET:
                    case LIST:
                        Type genericFieldType = field.getGenericType();
                        getAllField(getClass(genericFieldType, 0), listField);
                        break;
                    case MAP:
                        listField.add(field);
                        break;
                    default:
                        getAllField(field.getClass(), null);
                        break;
                }
            }
        }
        return listField;
    }

    protected List<Integer> getIdCols(Class<?> clazz,List<Integer> idCols){
        if(idCols==null){
            idCols = new ArrayList<>();
        }
        Field[] fields= clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(ExcelId.class)&&field.isAnnotationPresent(Excel.class)){
                Excel ea = field.getAnnotation(Excel.class);
                idCols.add(getExcelCol(ea.column()));
            }else if(field.isAnnotationPresent(ExcelList.class)){
                clazz = getClass(field.getGenericType(),0);
                getIdCols(clazz,idCols);
            }
        }
        return idCols;
    }

    /**
     *
     * 得到泛型类对象 @param type @param i @return Class 返回类型 @throws
     */
    @SuppressWarnings("rawtypes")
    protected static Class getClass(Type type, int i) {
        if (type instanceof ParameterizedType) { // 处理泛型类型
            return getGenericClass((ParameterizedType) type, i);
        } else if (type instanceof TypeVariable) {
            return (Class) getClass(((TypeVariable) type).getBounds()[0], 0); // 处理泛型擦拭对象
        } else {// class本身也是type，强制转型
            return (Class) type;
        }
    }

    @SuppressWarnings("rawtypes")
    private static Class getGenericClass(ParameterizedType parameterizedType, int i) {
        Object genericClass = parameterizedType.getActualTypeArguments()[i];
        if (genericClass instanceof ParameterizedType) { // 处理多级泛型
            return (Class) ((ParameterizedType) genericClass).getRawType();
        } else if (genericClass instanceof GenericArrayType) { // 处理数组泛型
            return (Class) ((GenericArrayType) genericClass).getGenericComponentType();
        } else if (genericClass instanceof TypeVariable) { // 处理泛型擦拭对象
            return (Class) getClass(((TypeVariable) genericClass).getBounds()[0], 0);
        } else {
            return (Class) genericClass;
        }
    }

    /**
     * 将EXCEL中A,B,C,D,E列映射成0,1,2,3
     *
     * @param col
     */
    protected static int getExcelCol(String col) {
        col = col.toUpperCase();
        // 从-1开始计算,字母重1开始运算。这种总数下来算数正好相同。
        int count = -1;
        char[] cs = col.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);
        }
        return count;
    }

    /**
     *
     * 创建实例对象 并装配关系
     * @param clazz 当前实例对象的类
     * @param row 当前实例对象的行
     * @param idCol 当前实例对象的id列
     * @param parentIdCol 父实例对象的id列
     * @param tuples 存放所有的值
     * @param instanceMap  装配后的对象
     * @throws
     */
    @SuppressWarnings("unchecked")
    protected Map<String,Map<String, Object>>  createInstance(Class<?> clazz, int row, int idCol, int parentIdCol, int childIdCol,Map<String, String> tuples, Map<String,Map<String, Object>> instanceMap) {
        if(!tuples.containsKey(row + "," + idCol)){
            return instanceMap;
        }
        // TODO判断 是否存在该实例
        if(instanceMap==null){
            instanceMap = new HashMap<>();
        }
        Object entity = null;
        try {
            entity = clazz.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //同一类对象的map 以 id_parentId作为键
        Map<String,Object> colMap;
        if(instanceMap.containsKey(idCol+"")){
            colMap = instanceMap.get(idCol+"");
        }else{
            colMap = new HashMap<>();
            instanceMap.put(idCol+"", colMap);
        }
        //判断是否有父级对象
        String id = tuples.get(row + "," + idCol);;
        if(parentIdCol>-1){
            String parentId = tuples.get(row + "," + parentIdCol);
            colMap.put(parentId+"_"+id, entity);

        }else{
            colMap.put(id, entity);
        }
//		logger.debug("colMap===========>"+colMap.size());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            //对普通属性进行设值
            if(field.isAnnotationPresent(Excel.class)&&!field.isAnnotationPresent(ExcelList.class)){
                Excel ea = field.getAnnotation(Excel.class);
                String value = tuples.get(row + "," + getExcelCol(ea.column()));
                Class<?> fieldType = field.getType();
                try {
                    if (String.class == fieldType) {
                        field.set(entity, String.valueOf(value));
                    } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
                        field.set(entity, Integer.parseInt(value));
                    } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                        field.set(entity, Long.valueOf(value));
                    } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                        field.set(entity, Float.valueOf(value));
                    } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                        field.set(entity, Short.valueOf(value));
                    } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
                        field.set(entity, Double.valueOf(value));
                    } else if (Character.TYPE == fieldType) {
                        if ((value != null) && (value.length() > 0)) {
                            field.set(entity, Character.valueOf(value.charAt(0)));
                        }
                    }
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else if(field.isAnnotationPresent(ExcelList.class)){
                Map<String,Object> map = instanceMap.get(childIdCol+"");
                List<Object> entitys = new ArrayList<>();
                if(map!=null){
                    for (Map.Entry<String,Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        if(key.indexOf("_")>-1){
                            String[] str = key.split("_");
                            String childParentId = str[0];
                            if(childParentId.equals(id)){
                                entitys.add(entry.getValue());
                            }
                        }
                    }
                }

                //TODO 进行类注入
                String typeName = field.getType().getName();
                try {

//					logger.debug("entitys:"+entitys.size());
                    switch (ElementTypePath.getElementTypePath(typeName)) {
                        case SET:
                            Set<Object> set = (Set<Object>)field.get(entity);
                            if(set==null){
                                set = new HashSet<>();
                                field.set(entity, set);
                            }
                            for (Object object : entitys) {
                                set.add(object);
                            }
                            break;
                        case LIST:
                            List<Object> list = (List<Object>)field.get(entity);
                            if(list==null){
                                list = entitys;
                                field.set(entity, list);
                            }else{
                                for (Object object : entitys) {
                                    list.add(object);
                                }
                            }
                            break;
                        case MAP:
                            if(field.isAnnotationPresent(Excel.class)){
                                if(getClass(field.getGenericType(),0).getName().equals("java.lang.String")){
                                    Map<String,String> imap = (Map<String,String>)field.get(entity);
                                    if(imap==null){
                                        imap = new HashMap<>();
                                        field.set(entity, imap);
                                    }
                                    Excel ea = field.getAnnotation(Excel.class);
                                    String value = tuples.get(row + "," + getExcelCol(ea.column()));
                                    if(value.indexOf(",")>-1){
                                        String[] str = value.split(",");
                                        for (String string : str) {
                                            if(string.indexOf(":")>-1){
                                                String[] keyAndVlaue = string.split(":");
                                                if(keyAndVlaue.length==2){
                                                    imap.put(keyAndVlaue[0].trim(), keyAndVlaue[1].trim());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        default:
                            if(entitys.size()==1){
                                field.set(entity, entitys.get(0));
                            }
                            break;

                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return instanceMap;
    }

    protected List<Class<?>> getAllClass(Class<?> clazz,List<Class<?>> clazzs){
        if(clazzs==null){
            clazzs = new ArrayList<>();
        }
        clazzs.add(clazz);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //TODO 此处集合需要做判断
            if(field.isAnnotationPresent(ExcelList.class)&&!field.isAnnotationPresent(Excel.class)){
                clazz = getClass(field.getGenericType(),0);
                getAllClass(clazz, clazzs);
            }
        }
        return clazzs;
    }



}
