package com.taiji.eap.common.easypoi.excel.core;

import com.taiji.eap.common.easypoi.excel.annotation.Excel;
import com.taiji.eap.common.excle.annotation.ExcelAttribute;
import com.taiji.eap.common.excle.core.ExcelTool;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil<T> extends AbstractExcelUtil<T>{

    private Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    private Class<T> clazz;

    @Override
    public List<T> transition(int dataRow,HSSFSheet sheet) {
        int rows = sheet.getPhysicalNumberOfRows();
        Map<String,String> tuples = getTuple(sheet,dataRow,rows);
        List<Integer> idCols = getIdCols(clazz,null);
        List<Class<?>> clazzs = getAllClass(clazz,null);
        if(idCols.size()!=clazzs.size()){
            logger.error("class 数目不一致");
            return null;
        }
        Map<String,Map<String, Object>> instanceMap = null;
        int size = idCols.size();
        for(int i=size-1;i>-1;i--){
            //默认起始行为1
            for(int j=dataRow;j<rows;j++){
                int row = j;
                int childIdCol = -1;
                int idCol = idCols.get(i);
                int parentIdCol = -1;
                if(i>0){
                    parentIdCol = idCols.get(i-1);
                }
                if(i<size-1){
                    childIdCol = idCols.get(i+1);
                }
                instanceMap = createInstance(clazzs.get(i), row, idCol, parentIdCol, childIdCol, tuples, instanceMap);
            }
        }
        List<T> list = new ArrayList<T>();
        Map<String,Object> map = instanceMap.get(idCols.get(0)+"");
        for (Map.Entry<String,Object>  entry : map.entrySet()) {
            list.add((T)entry.getValue());
        }
        return list;
    }

    @Override
    public IExcelUtil<T> build(Class<T> clazz) {
        this.clazz = clazz;
        return this;
    }

    @Override
    public List<T> importExcel(int dataRow,InputStream input) {
        List<T> list = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(input);
            HSSFSheet  sheet = workbook.getSheetAt(0);
            list = transition(dataRow,sheet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean exportExcel(List<T> list, OutputStream output) {
        return false;
    }

    /**
     *
     * 获取 excel中的数据 元组
     * @param sheet
     * @return  List<List<String>> excel元组
     * @throws
     */
    private Map<String,String> getTuple(HSSFSheet sheet,int dataRow,int rows){

        Map<String,String> tuples = new HashMap<>();
        //获取列
        List<Field> fields = getAllField(clazz, null);

        // 从第2行开始取数据,默认第一行是表头.
        for (int i = dataRow; i < rows; i++) {
            for (Field field : fields) {
                if(field.isAnnotationPresent(Excel.class)){
                    Excel excel = field.getAnnotation(Excel.class);
                    int col = getExcelCol(excel.column());
                    if(com.taiji.eap.common.excle.core.ExcelTool.isMergedRegion(sheet, i, col)){
                        // 以(行,列）作为一个元组
                        String key = i+","+col;
                        String value = ExcelTool.getMergedRegionValue(sheet, i, col);
                        tuples.put(key, value);
                    }
                }
            }
        }
        return tuples;
    }
}
