package com.taiji.eap.biz.jcxmjg.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.biz.jcxmjg.bean.Jcxmjg;
import com.taiji.eap.biz.jcxmjg.service.JcxmjgService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("jcxmjg")
public class JcxmjgController extends BaseController{

    @Autowired
    private JcxmjgService jcxmjgService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Jcxmjg> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Jcxmjg> pageInfo = null;
        try {
            pageInfo = jcxmjgService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Jcxmjg jcxmjg){
        try {
            int k = jcxmjgService.insert(jcxmjg);
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
    public Response<String> edit(Jcxmjg jcxmjg){
        try {
            int k = jcxmjgService.updateByPrimaryKey(jcxmjg);
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
            int k = jcxmjgService.deleteByPrimaryKey(id);
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
    public Response<Jcxmjg> selectOne(Long id){
         try {
            return renderSuccess(jcxmjgService.selectByPrimaryKey(id));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}