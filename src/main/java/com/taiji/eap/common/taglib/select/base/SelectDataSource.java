package com.taiji.eap.common.taglib.select.base;

import com.taiji.eap.common.shiro.bean.SysUser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SelectDataSource<T> {

    /**
     * 获取key的属性名
     * @return
     */
    public abstract String getKeyName();

    /**
     * 获取Value的属性名
     * @return
     */
    public abstract String getValueName();

    /**
     * 获取数据源
     * @return
     */
    public abstract List<T> getDataSource(String... params) throws Exception;

    public abstract Class<T> getDataSourceClass();

    /**
     * 获取查询数据源
     * @return
     */
    public List<Map<String,Object>> getSelectDataSource(String param) throws Exception{
        List<Map<String,Object>> keyValues = new ArrayList<Map<String, Object>>();
        String[] params = new String[]{};
        if(param!=null){
            params = param.split(",");
        }
        List<T> list = getDataSource(params);
        try {
            for (int i = 0; i < list.size(); i++) {
                Map<String,Object> hashMap = new HashMap<String,Object>();
                Field valueField = getDataSourceClass().getDeclaredField(getValueName());
                valueField.setAccessible(true);
                Object valueObj = valueField.get(list.get(i));
                hashMap.put("value",valueObj);

                Field keyField = getDataSourceClass().getDeclaredField(getKeyName());
                keyField.setAccessible(true);
                Object keyObj = keyField.get(list.get(i));
                hashMap.put("key",keyObj);
                keyValues.add(hashMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyValues;
    }

}
