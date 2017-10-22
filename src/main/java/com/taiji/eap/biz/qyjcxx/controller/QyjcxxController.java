package com.taiji.eap.biz.qyjcxx.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.biz.qyjcxx.bean.Qyjcxx;
import com.taiji.eap.biz.qyjcxx.service.QyjcxxService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("qyjcxx")
public class QyjcxxController extends BaseController{

    @Autowired
    private QyjcxxService qyjcxxService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Qyjcxx> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Qyjcxx> pageInfo = null;
        try {
            pageInfo = qyjcxxService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Qyjcxx qyjcxx){
        try {
            int k = qyjcxxService.insert(qyjcxx);
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
    public Response<String> edit(Qyjcxx qyjcxx){
        try {
            int k = qyjcxxService.updateByPrimaryKey(qyjcxx);
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
            int k = qyjcxxService.deleteByPrimaryKey(id);
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
    public Response<Qyjcxx> selectOne(Long id){
         try {
            return renderSuccess(qyjcxxService.selectByPrimaryKey(id));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @PostMapping(value = "easyuiSubmitData")
    @ResponseBody
    public Response<String> easyuiSubmitData(@RequestBody EasyUISubmitData<Qyjcxx> easyUISubmitData){
        int i = qyjcxxService.easyuiSubmitData(easyUISubmitData);
        if(i>0)
            return renderSuccess("提交成功");
        else
            return renderError("提交失败");
    }
}