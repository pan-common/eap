package com.taiji.eap.common.form.elementExtend.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.base.packbean.PackList;
import com.taiji.eap.common.form.elementExtend.bean.ElementExtend;
import com.taiji.eap.common.form.elementExtend.service.ElementExtendService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("elementExtend")
public class ElementExtendController extends BaseController{

    @Autowired
    private ElementExtendService elementExtendService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<ElementExtend> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<ElementExtend> pageInfo = null;
        try {
            pageInfo = elementExtendService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    @GetMapping(value = "elementExtendList")
    @ResponseBody
    public Response<List<ElementExtend>> elementExtendList(Long elementId){
        List<ElementExtend> elementExtends = null;
        try {
            elementExtends = elementExtendService.elementExtendList(elementId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return renderSuccess(elementExtends);
    }

    @PostMapping(value = "addList")
    @ResponseBody
    public Response<String> addList(PackList packList){
       int k = elementExtendService.addList(packList.getDatas());
        if(k>0){
            return renderSuccess("添加成功");
        }else {
            return renderError("添加失败");
        }
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(ElementExtend elementExtend){
        try {
            int k = elementExtendService.insert(elementExtend);
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
    public Response<String> edit(ElementExtend elementExtend){
        try {
            int k = elementExtendService.updateByPrimaryKey(elementExtend);
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
    public Response<String> delete(Long elementExtendId){
        try {
            int k = elementExtendService.deleteByPrimaryKey(elementExtendId);
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
    public Response<ElementExtend> selectOne(Long elementExtendId){
         try {
            return renderSuccess(elementExtendService.selectByPrimaryKey(elementExtendId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}