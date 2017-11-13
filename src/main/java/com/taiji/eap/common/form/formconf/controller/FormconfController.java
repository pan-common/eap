package com.taiji.eap.common.form.formconf.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.form.formconf.bean.Formconf;
import com.taiji.eap.common.form.formconf.service.FormconfService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("formconf")
public class FormconfController extends BaseController{

    @Autowired
    private FormconfService formconfService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Formconf> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Formconf> pageInfo = null;
        try {
            pageInfo = formconfService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Formconf formconf){
        try {
            int k = formconfService.insert(formconf);
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
    public Response<String> edit(Formconf formconf){
        try {
            int k = formconfService.updateByPrimaryKey(formconf);
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
    public Response<String> delete(Long formId){
        try {
            int k = formconfService.deleteByPrimaryKey(formId);
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
    public Response<Formconf> selectOne(Long formId){
         try {
            return renderSuccess(formconfService.selectByPrimaryKey(formId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}