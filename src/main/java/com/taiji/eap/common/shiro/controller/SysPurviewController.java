package com.taiji.eap.common.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.shiro.bean.SysPurview;
import com.taiji.eap.common.shiro.service.SysPurviewService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("sysPuriew")
public class SysPurviewController extends BaseController{

    @Autowired
    private SysPurviewService sysPurviewService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<SysPurview> list(Integer pageNum, Integer pageSize, String searchText){
        PageInfo<SysPurview> pageInfo = null;
        try {
            pageInfo = sysPurviewService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(SysPurview sysPurview){
        sysPurview.setCreateTime(new Date());
        sysPurview.setUpdateTime(new Date());
        sysPurview.setValid("1");
        sysPurview.setCreater(1L);
        try {
            int k = sysPurviewService.insert(sysPurview);
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
    public Response<String> edit(SysPurview sysPurview){
        sysPurview.setCreateTime(new Date());
        sysPurview.setUpdateTime(new Date());
        sysPurview.setValid("1");
        sysPurview.setCreater(1L);
        try {
            int k = sysPurviewService.updateByPrimaryKey(sysPurview);
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
    public Response<String> delete(Long puriewId){
        try {
            int k = sysPurviewService.deleteByPrimaryKey(puriewId);
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
    public Response<SysPurview> selectOne(Long puriewId){
         try {
            return renderSuccess(sysPurviewService.selectByPrimaryKey(puriewId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}