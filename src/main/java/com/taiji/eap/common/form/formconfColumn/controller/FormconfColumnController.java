package com.taiji.eap.common.form.formconfColumn.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.form.formconfColumn.bean.FormconfColumn;
import com.taiji.eap.common.form.formconfColumn.service.FormconfColumnService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("formconfColumn")
public class FormconfColumnController extends BaseController{

    @Autowired
    private FormconfColumnService formconfColumnService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<FormconfColumn> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<FormconfColumn> pageInfo = null;
        try {
            pageInfo = formconfColumnService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(FormconfColumn formconfColumn){
        try {
            int k = formconfColumnService.insert(formconfColumn);
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
    public Response<String> edit(FormconfColumn formconfColumn){
        try {
            int k = formconfColumnService.updateByPrimaryKey(formconfColumn);
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
    public Response<String> delete(Long columnId){
        try {
            int k = formconfColumnService.deleteByPrimaryKey(columnId);
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
    public Response<FormconfColumn> selectOne(Long columnId){
         try {
            return renderSuccess(formconfColumnService.selectByPrimaryKey(columnId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}