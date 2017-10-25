package com.taiji.eap.common.query.controller;

import com.taiji.eap.common.query.QueryUtil;
import com.taiji.eap.common.query.bean.ColumnData;
import com.taiji.eap.common.query.bean.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("query")
public class QueryController{

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
