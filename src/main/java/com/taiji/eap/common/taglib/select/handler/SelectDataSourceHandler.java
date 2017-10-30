package com.taiji.eap.common.taglib.select.handler;

import com.alibaba.druid.pool.DruidDataSource;
import com.taiji.eap.common.datasource.service.DataSourceService;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取数据源下拉列表
 */
public class SelectDataSourceHandler extends SelectCommonDataSourceHandler<Dictionary>{

    @Autowired
    DataSourceService dataSourceService;

    @Override
    protected boolean isType(String datasource) {
        if(datasource.equals("datasource"))
            return true;
        else
            return false;
    }

    @Override
    public String getKeyName() {
        return "keystone";
    }

    @Override
    public String getValueName() {
        return "value";
    }

    @Override
    public List<Dictionary> getDataSource(String... params) throws Exception {
        List<Dictionary> dictionaries = new ArrayList<>();
        try {
            Map<Object,Object> map = dataSourceService.getDataSources();
            for (Map.Entry<Object,Object> entry: map.entrySet()) {
                String key = (String) entry.getKey();
                DruidDataSource value = (DruidDataSource) entry.getValue();
                dictionaries.add(new Dictionary(key,key));
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return dictionaries;
    }

    @Override
    public Class<Dictionary> getDataSourceClass() {
        return Dictionary.class;
    }
}
