package com.taiji.eap.biz.jcdxx.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.biz.jcdxx.bean.Jcdxx;
import com.taiji.eap.biz.jcdxx.service.JcdxxService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("jcdxx")
public class JcdxxController extends BaseController{

    @Autowired
    private JcdxxService jcdxxService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Jcdxx> list(Integer pageNum,Integer pageSize,String searchText,String qyhb,String jcdfl){
        PageInfo<Jcdxx> pageInfo = null;
        try {
            pageInfo = jcdxxService.list(pageNum,pageSize,searchText,qyhb,jcdfl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Jcdxx jcdxx){
        try {
            int k = jcdxxService.insert(jcdxx);
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
    public Response<String> edit(Jcdxx jcdxx){
        try {
            int k = jcdxxService.updateByPrimaryKey(jcdxx);
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
            int k = jcdxxService.deleteByPrimaryKey(id);
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
    public Response<Jcdxx> selectOne(Long id){
         try {
            return renderSuccess(jcdxxService.selectByPrimaryKey(id));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}