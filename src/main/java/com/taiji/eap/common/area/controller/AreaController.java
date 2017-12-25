package com.taiji.eap.common.area.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.area.bean.Area;
import com.taiji.eap.common.area.service.AreaService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("area")
public class AreaController extends BaseController{

    @Autowired
    private AreaService areaService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Area> list(Integer parentId,Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Area> pageInfo = null;
        try {
            pageInfo = areaService.listByPid(parentId,pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Area area){
        try {
            int k = areaService.insert(area);
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
    public Response<String> edit(Area area){
        try {
            int k = areaService.updateByPrimaryKey(area);
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
    public Response<String> delete(Integer areaId){
        try {
            int k = areaService.deleteByPrimaryKey(areaId);
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
    public Response<Area> selectOne(Integer areaId){
         try {
            return renderSuccess(areaService.selectByPrimaryKey(areaId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @GetMapping(value = "getPath")
    @ResponseBody
    public Response<List<Area>> getPath(Integer areaId){
         try {
             return renderSuccess(areaService.getPath(areaId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "listByPid")
    @ResponseBody
    public Response<List<Area>> listByPid(Integer parentId){
         List<Area> list = null;
         try {
             list = areaService.listByPid(parentId);
             return renderSuccess(list);
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "treeView")
    @ResponseBody
    public Response<List<BaseTree>> treeView(Integer parentId){
        List<BaseTree> baseTrees = null;
        try {
            baseTrees = areaService.treeView(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderSuccess(baseTrees);
    }
}