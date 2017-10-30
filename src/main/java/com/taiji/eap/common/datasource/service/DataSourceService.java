package com.taiji.eap.common.datasource.service;

import com.taiji.eap.common.generator.bean.LayuiTree;

import java.util.List;
import java.util.Map;

public interface DataSourceService {

    public Map<Object,Object> getDataSources() throws NoSuchFieldException, IllegalAccessException;

    /**
     * 获取全部数据库连接
     * @return
     */
    public List<LayuiTree> getDataSourceTree();

}
