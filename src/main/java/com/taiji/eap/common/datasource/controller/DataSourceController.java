package com.taiji.eap.common.datasource.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.datasource.service.DataSourceService;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("dataSource")
public class DataSourceController extends BaseController{

    @Autowired
    DataSourceService dataSourceService;

    @GetMapping("getDataSources")
    @ResponseBody
    public Response<List<Dictionary>> getDataSources(){
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
        return renderSuccess(dictionaries);
    }
}
