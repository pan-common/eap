package com.taiji.eap.common.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysPuriew;
import com.taiji.eap.common.shiro.service.SysPuriewService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("sysPuriew")
public class SysPuriewController extends BaseController{

    @Autowired
    private SysPuriewService sysPuriewService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<SysPuriew> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<SysPuriew> pageInfo = null;
        try {
            pageInfo = sysPuriewService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(SysPuriew sysPuriew){
        sysPuriew.setCreateTime(new Date());
        sysPuriew.setUpdateTime(new Date());
        sysPuriew.setValid("1");
        sysPuriew.setCreater(1L);
        try {
            int k = sysPuriewService.insert(sysPuriew);
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
    public Response<String> edit(SysPuriew sysPuriew){
        sysPuriew.setCreateTime(new Date());
        sysPuriew.setUpdateTime(new Date());
        sysPuriew.setValid("1");
        sysPuriew.setCreater(1L);
        try {
            int k = sysPuriewService.updateByPrimaryKey(sysPuriew);
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
            int k = sysPuriewService.deleteByPrimaryKey(puriewId);
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
    public Response<SysPuriew> selectOne(Long puriewId){
         try {
            return renderSuccess(sysPuriewService.selectByPrimaryKey(puriewId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}