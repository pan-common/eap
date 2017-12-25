package com.taiji.eap.common.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.shiro.bean.SysOrgan;
import com.taiji.eap.common.shiro.service.SysOrganService;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.utils.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("sysOrgan")
public class SysOrganController extends BaseController{

    @Autowired
    private SysOrganService sysOrganService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<SysOrgan> list(Long parentId,Integer pageNum,Integer pageSize,String searchText){
        PageInfo<SysOrgan> pageInfo = null;
        try {
            pageInfo = sysOrganService.listByPid(parentId,pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(SysOrgan sysOrgan){
        sysOrgan.setCreateTime(new Date());
        sysOrgan.setUpdateTime(new Date());
        sysOrgan.setValid("1");
        sysOrgan.setCreater(1L);
        try {
            int k = sysOrganService.insert(sysOrgan);
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
    public Response<String> edit(SysOrgan sysOrgan){
        sysOrgan.setCreateTime(new Date());
        sysOrgan.setUpdateTime(new Date());
        sysOrgan.setValid("1");
        sysOrgan.setCreater(1L);
        try {
            int k = sysOrganService.updateByPrimaryKey(sysOrgan);
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
    public Response<String> delete(Long organId){
        try {
            int k = sysOrganService.deleteByPrimaryKey(organId);
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
    public Response<SysOrgan> selectOne(Long organId){
         try {
            return renderSuccess(sysOrganService.selectByPrimaryKey(organId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @GetMapping(value = "getPath")
    @ResponseBody
    public Response<List<SysOrgan>> getPath(Long organId){
         try {
             return renderSuccess(sysOrganService.getPath(organId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "listByPid")
    @ResponseBody
    public Response<List<SysOrgan>> listByPid(Long parentId){
         List<SysOrgan> list = null;
         try {
             list = sysOrganService.listByPid(parentId);
             return renderSuccess(list);
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "treeView")
    @ResponseBody
    public Response<List<BaseTree>> treeView(Long parentId){
        List<BaseTree> baseTrees = null;
        try {
            baseTrees = sysOrganService.treeView(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderSuccess(baseTrees);
    }

    @GetMapping(value = "getOrganIdsByUserId")
    @ResponseBody
    public Response<List<Long>> getOrganIdsByUserId(Long userId){
        return renderSuccess(sysOrganService.getOrganIdsByUserId(userId));
    }

    @GetMapping(value = "getTreeByOrganIds")
    @ResponseBody
    public Response<List<SysOrgan>> getListByOrganIds(String organIds){
        if(!StringUtils.isEmpty(organIds)) {
            String[] arr = organIds.split(",");
            List<String> longs = Arrays.asList(arr);
            List<SysOrgan> sysOrgans = sysOrganService.selectByIds(ListUtils.stringToLongLst(longs));
            return renderSuccess(sysOrgans);
        }else {
            return renderError("没有数据");
        }
    }

    @PostMapping(value = "saveUserOrgan")
    @ResponseBody
    public Response<String> saveUserOrgan(Long userId,String organIds){
        if(!StringUtils.isEmpty(organIds)) {
            String[] arr = organIds.split(",");
            List<String> longs = Arrays.asList(arr);
            int k = sysOrganService.saveUserOrgan(userId,ListUtils.stringToLongLst(longs));
            if(k>0)
                return renderSuccess("保存成功");
            else
                return renderError("保存失败");
        }else {
            return renderError("没有数据提交");
        }
    }

}