package com.taiji.eap.common.form.formconfVersion.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.form.formconfVersion.bean.FormconfVersion;
import com.taiji.eap.common.form.formconfVersion.service.FormconfVersionService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("formconfVersion")
public class FormconfVersionController extends BaseController{

    @Autowired
    private FormconfVersionService formconfVersionService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<FormconfVersion> list(Integer pageNum,Integer pageSize,String searchText,FormconfVersion formconfVersion){
        PageInfo<FormconfVersion> pageInfo = null;
        try {
            pageInfo = formconfVersionService.list(pageNum,pageSize,searchText,formconfVersion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(FormconfVersion formconfVersion){
        formconfVersion.setCreateTime(new Date());
        formconfVersion.setUpdateTime(new Date());
        formconfVersion.setValid("1");
        formconfVersion.setCreater(1L);
        try {
            int k = formconfVersionService.insert(formconfVersion);
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
    public Response<String> edit(FormconfVersion formconfVersion){
        formconfVersion.setCreateTime(new Date());
        formconfVersion.setUpdateTime(new Date());
        formconfVersion.setValid("1");
        formconfVersion.setCreater(1L);
        try {
            int k = formconfVersionService.updateByPrimaryKey(formconfVersion);
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
    public Response<String> delete(Long formVersionId){
        try {
            int k = formconfVersionService.deleteByPrimaryKey(formVersionId);
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
    public Response<FormconfVersion> selectOne(Long formVersionId){
         try {
            return renderSuccess(formconfVersionService.selectByPrimaryKey(formVersionId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}