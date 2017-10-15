package com.taiji.eap.common.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysRole;
import com.taiji.eap.common.shiro.service.SysRoleService;
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
@RequestMapping("sysRole")
public class SysRoleController extends BaseController{

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<SysRole> list(Long parentId,Integer pageNum,Integer pageSize,String searchText){
        PageInfo<SysRole> pageInfo = null;
        try {
            pageInfo = sysRoleService.listByPid(parentId,pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(SysRole sysRole){
        sysRole.setCreateTime(new Date());
        sysRole.setUpdateTime(new Date());
        sysRole.setValid("1");
        sysRole.setCreater(1L);
        try {
            int k = sysRoleService.insert(sysRole);
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
    public Response<String> edit(SysRole sysRole){
        sysRole.setCreateTime(new Date());
        sysRole.setUpdateTime(new Date());
        sysRole.setValid("1");
        sysRole.setCreater(1L);
        try {
            int k = sysRoleService.updateByPrimaryKey(sysRole);
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
    public Response<String> delete(Long roleId){
        try {
            int k = sysRoleService.deleteByPrimaryKey(roleId);
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
    public Response<SysRole> selectOne(Long roleId){
         try {
            return renderSuccess(sysRoleService.selectByPrimaryKey(roleId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @GetMapping(value = "getPath")
    @ResponseBody
    public Response<List<SysRole>> getPath(Long roleId){
         try {
             return renderSuccess(sysRoleService.getPath(roleId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "listByPid")
    @ResponseBody
    public Response<List<SysRole>> listByPid(Long parentId){
         List<SysRole> list = null;
         try {
             list = sysRoleService.listByPid(parentId);
             return renderSuccess(list);
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "treeView")
    @ResponseBody
    public Response<List<LayuiTree>> treeView(Long parentId){
        List<LayuiTree> layuiTrees = null;
        try {
            layuiTrees = sysRoleService.treeView(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderSuccess(layuiTrees);
    }
}