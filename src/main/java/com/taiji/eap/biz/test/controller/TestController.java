package com.taiji.eap.biz.test.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.biz.test.bean.Test;
import com.taiji.eap.biz.test.service.TestService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("test")
public class TestController extends BaseController{

    @Autowired
    private TestService testService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Test> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Test> pageInfo = null;
        try {
            pageInfo = testService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Test test){
        try {
            int k = testService.insert(test);
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
    public Response<String> edit(Test test){
        try {
            int k = testService.updateByPrimaryKey(test);
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
    public Response<String> delete(Long id){
        try {
            int k = testService.deleteByPrimaryKey(id);
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
    public Response<Test> selectOne(Long id){
         try {
            return renderSuccess(testService.selectByPrimaryKey(id));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}