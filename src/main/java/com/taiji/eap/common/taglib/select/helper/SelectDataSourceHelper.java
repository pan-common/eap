package com.taiji.eap.common.taglib.select.helper;

import com.taiji.eap.common.taglib.select.base.SelectCommonDataSourceHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectDataSourceHelper {

    private SelectCommonDataSourceHandler handler;

    public List<Map<String,Object>> getDataSources(String datasource,String param) throws Exception {
        handler.doHandler(datasource,param);
        return handler.getList();
    };


    public SelectCommonDataSourceHandler getHandler() {
        return handler;
    }

    public void setHandler(SelectCommonDataSourceHandler handler) {
        this.handler = handler;
    }
}
