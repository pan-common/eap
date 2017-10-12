package com.taiji.eap.biz.organ.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.biz.organ.bean.Organ;
import com.taiji.eap.biz.organ.service.OrganService;
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
@RequestMapping("organ")
public class OrganController extends BaseController{

    @Autowired
    private OrganService organService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Organ> list(Long parentId,Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Organ> pageInfo = null;
        try {
            pageInfo = organService.listByPid(parentId,pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Organ organ){
        organ.setCreateTime(new Date());
        organ.setUpdateTime(new Date());
        organ.setValid("1");
        organ.setCreater(1L);
        try {
            int k = organService.insert(organ);
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
    public Response<String> edit(Organ organ){
        organ.setCreateTime(new Date());
        organ.setUpdateTime(new Date());
        organ.setValid("1");
        organ.setCreater(1L);
        try {
            int k = organService.updateByPrimaryKey(organ);
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
            int k = organService.deleteByPrimaryKey(organId);
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
    public Response<Organ> selectOne(Long organId){
         try {
            return renderSuccess(organService.selectByPrimaryKey(organId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @GetMapping(value = "getPath")
    @ResponseBody
    public Response<List<Organ>> getPath(Long organId){
         try {
             return renderSuccess(organService.getPath(organId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "listByPid")
    @ResponseBody
    public Response<List<Organ>> listByPid(Long parentId){
         List<Organ> list = null;
         try {
             list = organService.listByPid(parentId);
             return renderSuccess(list);
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }
}