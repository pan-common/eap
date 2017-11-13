package com.taiji.eap.common.controller;

import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.taglib.select.helper.SelectDataSourceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("common")
public class CommonController extends BaseController{

    @Autowired
    SelectDataSourceHelper selectDataSourceHelper;

    @RequestMapping("getCommonSelectData")
    @ResponseBody
    public Response<List<Map<String,Object>>> getCommonSelectData(String datasource,String params){
        List<Map<String,Object>> result = null;
        try {
            result =  selectDataSourceHelper.getDataSources(datasource,params);
        } catch (Exception e) {
            e.printStackTrace();
            return renderError("请求失败");
        }
       return renderSuccess(result);
    }

}
