package com.taiji.eap.common.form.element.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.dictionary.annotation.DictionaryResponse;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.form.element.bean.Element;
import com.taiji.eap.common.form.element.service.ElementService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("element")
public class ElementController extends BaseController{

    @Autowired
    private ElementService elementService;

    @GetMapping(value = "list")
    @ResponseBody
    @DictionaryResponse
    public PageInfo<Element> list(Long parentId,Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Element> pageInfo = null;
        try {
            pageInfo = elementService.listByPid(parentId,pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Element element){
        element.setCreateTime(new Date());
        element.setUpdateTime(new Date());
        element.setValid("1");
        element.setCreater(1L);
        try {
            int k = elementService.insert(element);
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
    public Response<String> edit(Element element){
        element.setCreateTime(new Date());
        element.setUpdateTime(new Date());
        element.setValid("1");
        element.setCreater(1L);
        try {
            int k = elementService.updateByPrimaryKey(element);
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
    public Response<String> delete(Long elementId){
        try {
            int k = elementService.deleteByPrimaryKey(elementId);
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
    public Response<Element> selectOne(Long elementId){
         try {
            return renderSuccess(elementService.selectByPrimaryKey(elementId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @GetMapping(value = "getPath")
    @ResponseBody
    public Response<List<Element>> getPath(Long elementId){
         try {
             return renderSuccess(elementService.getPath(elementId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "listByPid")
    @ResponseBody
    public Response<List<Element>> listByPid(Long parentId){
         List<Element> list = null;
         try {
             list = elementService.listByPid(parentId);
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
            baseTrees = elementService.treeView(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderSuccess(baseTrees);
    }
}