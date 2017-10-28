package com.taiji.eap.common.easypoi.excel.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface IExcelUtil<T> {

    /**
     * 构建一个导入导出工具
     * @param clazz
     * @return
     */
    IExcelUtil<T> build(Class<T> clazz);

    /**
     *
     * 数据导入
     * @param input
     * @return  List<T> 导出数据
     */
    List<T> importExcel(int dataRow,InputStream input);

    /**
     *
     * 数据导出
     * @param list
     * @param output
     * @return  boolean
     */
    boolean exportExcel(List<T> list, OutputStream output);

}
