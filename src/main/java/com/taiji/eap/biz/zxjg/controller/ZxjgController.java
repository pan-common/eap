package com.taiji.eap.biz.zxjg.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.biz.zxjg.bean.Zxjg;
import com.taiji.eap.biz.zxjg.service.ZxjgService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("zxjg")
public class ZxjgController extends BaseController{

    @Autowired
    private ZxjgService zxjgService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Zxjg> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Zxjg> pageInfo = null;
        try {
            pageInfo = zxjgService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Zxjg zxjg){
        try {
            int k = zxjgService.insert(zxjg);
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
    public Response<String> edit(Zxjg zxjg){
        try {
            int k = zxjgService.updateByPrimaryKey(zxjg);
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
    public Response<String> delete(Long zxjgId){
        try {
            int k = zxjgService.deleteByPrimaryKey(zxjgId);
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
    public Response<Zxjg> selectOne(Long zxjgId){
         try {
            return renderSuccess(zxjgService.selectByPrimaryKey(zxjgId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}