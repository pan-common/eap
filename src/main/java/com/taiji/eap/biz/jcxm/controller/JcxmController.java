package com.taiji.eap.biz.jcxm.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.biz.jcxm.bean.Jcxm;
import com.taiji.eap.biz.jcxm.service.JcxmService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("jcxm")
public class JcxmController extends BaseController{

    @Autowired
    private JcxmService jcxmService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Jcxm> list(Integer pageNum,Integer pageSize,String searchText,String qybh,String jcdbh){
        PageInfo<Jcxm> pageInfo = null;
        try {
            pageInfo = jcxmService.list(pageNum,pageSize,searchText,qybh,jcdbh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Jcxm jcxm){
        try {
            int k = jcxmService.insert(jcxm);
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
    public Response<String> edit(Jcxm jcxm){
        try {
            int k = jcxmService.updateByPrimaryKey(jcxm);
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
    public Response<String> delete(Long jcxmId){
        try {
            int k = jcxmService.deleteByPrimaryKey(jcxmId);
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
    public Response<Jcxm> selectOne(Long jcxmId){
         try {
            return renderSuccess(jcxmService.selectByPrimaryKey(jcxmId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}