package com.taiji.eap.common.datasource.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.datasource.bean.DataSource;
import com.taiji.eap.common.datasource.service.DataSourceService;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("dataSourceTree")
    @ResponseBody
    public Response<List<LayuiTree>> dataSourceTree(){
        List<LayuiTree> layuiTrees = null;
        try {
            layuiTrees = dataSourceService.dataSourceTree();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return renderSuccess(layuiTrees);
    }

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

    @PostMapping(value = "connectTest")
    @ResponseBody
    public Response<String> connectTest(DataSource dataSource){
        try {
            String result = dataSourceService.connectTest(dataSource);
            return renderError(result);
        } catch (Exception e) {
            e.printStackTrace();
            return renderError("连接失败");
        }
    }


    @PostMapping("getTablesByDB")
    @ResponseBody
    public Response<List<LayuiTree>> getTablesByDB(String beanName,String driverClassName,String url,String username,String password){
        List<LayuiTree> layuiTrees = dataSourceService.tableTree(beanName,driverClassName,url,username,password);
        return renderSuccess(layuiTrees);
    }

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<DataSource> list(Integer pageNum, Integer pageSize, String searchText){
        PageInfo<DataSource> pageInfo = null;
        try {
            pageInfo = dataSourceService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(DataSource dataSource){
        try {
            int k = dataSourceService.insert(dataSource);
            if(k>0){
                return renderSuccess("添加成功");
            }else {
                return renderError("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

    @PostMapping(value = "edit")
    @ResponseBody
    public Response<String> edit(DataSource dataSource){
        try {
            int k = dataSourceService.updateByPrimaryKey(dataSource);
            if(k>0){
                return renderSuccess("修改成功");
            }else {
                return renderError("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public Response<String> delete(Long datasourceId){
        try {
            int k = dataSourceService.deleteByPrimaryKey(datasourceId);
            if(k>0){
                return renderSuccess("删除成功");
            }else {
                return renderError("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

    @GetMapping(value = "selectOne")
    @ResponseBody
    public Response<DataSource> selectOne(Long datasourceId){
        try {
            return renderSuccess(dataSourceService.selectByPrimaryKey(datasourceId));
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

}
