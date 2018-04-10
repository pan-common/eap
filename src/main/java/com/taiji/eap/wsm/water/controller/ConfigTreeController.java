package com.taiji.eap.wsm.water.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.wsm.water.bean.ConfigTree;
import com.taiji.eap.wsm.water.service.ConfigTreeService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("ConfigTree")
public class ConfigTreeController extends BaseController{

    @Autowired
    private ConfigTreeService ConfigTreeService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<ConfigTree> list(String parentId,Integer pageNum,Integer pageSize,String searchText){
        PageInfo<ConfigTree> pageInfo = null;
        try {
            pageInfo = ConfigTreeService.listByPid(parentId,pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    @GetMapping(value = "selectAll")
    @ResponseBody
    public List<ConfigTree> selectAll(){
        List<ConfigTree> configTrees = null;
        try{
            configTrees = ConfigTreeService.selectAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return configTrees;
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(ConfigTree ConfigTree){
        try {
            int k = ConfigTreeService.insert(ConfigTree);
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
    public Response<String> edit(ConfigTree ConfigTree){
        try {
            int k = ConfigTreeService.updateByPrimaryKey(ConfigTree);
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
    public Response<String> delete(String id){
        try {
            int k = ConfigTreeService.deleteByPrimaryKey(id);
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
    public Response<ConfigTree> selectOne(String id){
         try {
            return renderSuccess(ConfigTreeService.selectByPrimaryKey(id));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @GetMapping(value = "getPath")
    @ResponseBody
    public Response<List<ConfigTree>> getPath(String id){
         try {
             return renderSuccess(ConfigTreeService.getPath(id));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "listByPid")
    @ResponseBody
    public Response<List<ConfigTree>> listByPid(String parentId){
         List<ConfigTree> list = null;
         try {
             list = ConfigTreeService.listByPid(parentId);
             return renderSuccess(list);
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "treeView")
    @ResponseBody
    public Response<List<BaseTree>> treeView(String parentId){
        List<BaseTree> layuiTrees = null;
        try {
            layuiTrees = ConfigTreeService.treeView(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderSuccess(layuiTrees);
    }
}