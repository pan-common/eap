package com.taiji.eap.common.query.controller;

import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.query.QueryUtil;
import com.taiji.eap.common.query.bean.ColumnData;
import com.taiji.eap.common.query.bean.PageBean;
import com.taiji.eap.common.query.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("query")
public class QueryController extends BaseController{

    @Autowired
    private QueryService queryService;

    @GetMapping(value = "getTime")
    @ResponseBody
    public Response<String> getTime(){
        return renderSuccess(queryService.getTime());
    }

    @GetMapping(value = "queryView")
    @ResponseBody
    public List<List<ColumnData>> queryView(String tableName){
        return  QueryUtil.getColumnData(tableName,null);
    }

    @GetMapping(value = "queryData")
    @ResponseBody
    public PageBean queryData(String tableName,Integer page,Integer rows){
        return  QueryUtil.getQueryData(tableName,page,rows);
    }

}
