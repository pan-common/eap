package com.taiji.eap.common.generator.service;

import com.taiji.eap.common.generator.bean.DataSource;
import com.taiji.eap.common.generator.bean.LayuiTree;

import java.util.List;

public interface DataSourceService {
    /**
     * 获取全部数据库连接
     * @return
     */
    public List<LayuiTree> getDataSources();

}
