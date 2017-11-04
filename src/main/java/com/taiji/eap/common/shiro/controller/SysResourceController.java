package com.taiji.eap.common.shiro.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.dictionary.annotation.DictionaryResponse;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.shiro.bean.SysResource;
import com.taiji.eap.common.shiro.service.SysResourceService;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sysResource")
public class SysResourceController extends BaseController{

    @Autowired
    private SysResourceService sysResourceService;

    /**
     * 跳转页面
     * @param request
     * @param url
     * @return
     */
    @GetMapping(value="link")
    public ModelAndView link(HttpServletRequest request, String url){
        Map<String, String> map = request.getParameterMap();
        return toView(url, map);
    }

    @GetMapping(value = "list")
    @ResponseBody
    @DictionaryResponse
    public PageInfo<SysResource> list(Long parentId,Integer pageNum,Integer pageSize,String searchText){
        PageInfo<SysResource> pageInfo = null;
        try {
            pageInfo = sysResourceService.listByPid(parentId,pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(SysResource sysResource){
        sysResource.setCreateTime(new Date());
        sysResource.setUpdateTime(new Date());
        sysResource.setValid("1");
        sysResource.setCreater(1L);
        try {
            int k = sysResourceService.insert(sysResource);
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
    public Response<String> edit(SysResource sysResource){
        sysResource.setCreateTime(new Date());
        sysResource.setUpdateTime(new Date());
        sysResource.setValid("1");
        sysResource.setCreater(1L);
        try {
            int k = sysResourceService.updateByPrimaryKey(sysResource);
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
    public Response<String> delete(Long resourceId){
        try {
            int k = sysResourceService.deleteByPrimaryKey(resourceId);
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
    public Response<SysResource> selectOne(Long resourceId){
         try {
            return renderSuccess(sysResourceService.selectByPrimaryKey(resourceId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @GetMapping(value = "getPath")
    @ResponseBody
    public Response<List<SysResource>> getPath(Long resourceId){
         try {
             return renderSuccess(sysResourceService.getPath(resourceId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "listByPid")
    @ResponseBody
    public Response<List<SysResource>> listByPid(Long parentId){
         List<SysResource> list = null;
         try {
             list = sysResourceService.listByPid(parentId);
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
            layuiTrees = sysResourceService.treeView(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderSuccess(layuiTrees);
    }

    @GetMapping(value = "treeViewByUser")
    @ResponseBody
    public Response<List<LayuiTree>> treeViewByUser(Long parentId){
        List<LayuiTree> layuiTrees = null;
        try {
            layuiTrees = sysResourceService.treeViewByUser(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderSuccess(layuiTrees);
    }


    @GetMapping(value = "getResourceIdsByRoleId")
    @ResponseBody
    public Response<List<Long>> getResourceIdsByRoleId(Long roleId){
        return renderSuccess(sysResourceService.getResourceIdsByRoleId(roleId));
    }

    @GetMapping(value = "getResourceIdsByOrganId")
    @ResponseBody
    public Response<List<Long>> getResourceIdsByOrganId(Long organId){
        return renderSuccess(sysResourceService.getResourceIdsByOrganId(organId));
    }

    @GetMapping(value = "getTreeByResourceIds")
    @ResponseBody
    public Response<List<SysResource>> getListByResourceIds(String resourceIds){
        if(!StringUtils.isEmpty(resourceIds)) {
            String[] arr = resourceIds.split(",");
            List<String> longs = Arrays.asList(arr);
            List<SysResource> sysResources = sysResourceService.selectByIds(ListUtils.stringToLongLst(longs));
            return renderSuccess(sysResources);
        }else {
            return renderError("没有数据");
        }
    }

    @PostMapping(value = "saveRoleResource")
    @ResponseBody
    public Response<String> saveRoleResource(Long roleId,String resourceIds){
        if(!StringUtils.isEmpty(resourceIds)) {
            String[] arr = resourceIds.split(",");
            List<String> longs = Arrays.asList(arr);
            int k = sysResourceService.saveRoleResource(roleId,ListUtils.stringToLongLst(longs));
            if(k>0)
                return renderSuccess("保存成功");
            else
                return renderError("保存失败");
        }else {
            return renderError("没有数据提交");
        }
    }

    @PostMapping(value = "saveOrganResource")
    @ResponseBody
    public Response<String> saveOrganResource(Long organId,String resourceIds){
        if(!StringUtils.isEmpty(resourceIds)) {
            String[] arr = resourceIds.split(",");
            List<String> longs = Arrays.asList(arr);
            int k = sysResourceService.saveOrganResource(organId,ListUtils.stringToLongLst(longs));
            if(k>0)
                return renderSuccess("保存成功");
            else
                return renderError("保存失败");
        }else {
            return renderError("没有数据提交");
        }
    }



}