package com.taiji.eap.biz.registItem.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.dictionary.annotation.DictionaryResponse;
import com.taiji.eap.biz.registItem.bean.RegistItem;
import com.taiji.eap.biz.registItem.service.RegistItemService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("registItem")
public class RegistItemController extends BaseController{

    @Autowired
    private RegistItemService registItemService;

    @GetMapping(value = "list")
    @ResponseBody
    @DictionaryResponse
    public PageInfo<RegistItem> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<RegistItem> pageInfo = null;
        try {
            pageInfo = registItemService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(RegistItem registItem){
        try {
            int k = registItemService.insert(registItem);
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
    public Response<String> edit(RegistItem registItem){
        try {
            int k = registItemService.updateByPrimaryKey(registItem);
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
            int k = registItemService.deleteByPrimaryKey(id);
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
    public Response<RegistItem> selectOne(Long id){
         try {
            return renderSuccess(registItemService.selectByPrimaryKey(id));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}