package com.taiji.eap.biz.dmsctest.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.biz.dmsctest.bean.Dmsctest;
import com.taiji.eap.biz.dmsctest.service.DmsctestService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("dmsctest")
public class DmsctestController extends BaseController{

    @Autowired
    private DmsctestService dmsctestService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Dmsctest> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Dmsctest> pageInfo = null;
        try {
            pageInfo = dmsctestService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Dmsctest dmsctest){
        try {
            int k = dmsctestService.insert(dmsctest);
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
    public Response<String> edit(Dmsctest dmsctest){
        try {
            int k = dmsctestService.updateByPrimaryKey(dmsctest);
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
    public Response<String> delete(Long testId){
        try {
            int k = dmsctestService.deleteByPrimaryKey(testId);
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
    public Response<Dmsctest> selectOne(Long testId){
         try {
            return renderSuccess(dmsctestService.selectByPrimaryKey(testId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}