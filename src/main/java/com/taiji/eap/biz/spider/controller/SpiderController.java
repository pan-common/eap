package com.taiji.eap.biz.spider.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.biz.spider.bean.Spider;
import com.taiji.eap.biz.spider.service.SpiderService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("spider")
public class SpiderController extends BaseController{

    @Autowired
    private SpiderService spiderService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Spider> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Spider> pageInfo = null;
        try {
            pageInfo = spiderService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Spider spider){
        try {
            int k = spiderService.insert(spider);
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
    public Response<String> edit(Spider spider){
        try {
            int k = spiderService.updateByPrimaryKey(spider);
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
    public Response<String> delete(Long spiderId){
        try {
            int k = spiderService.deleteByPrimaryKey(spiderId);
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
    public Response<Spider> selectOne(Long spiderId){
         try {
            return renderSuccess(spiderService.selectByPrimaryKey(spiderId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}