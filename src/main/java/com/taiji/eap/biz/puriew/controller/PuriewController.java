
package com.taiji.eap.biz.puriew.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.biz.puriew.bean.Puriew;
import com.taiji.eap.biz.puriew.service.PuriewService;
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
@RequestMapping("puriew")
public class PuriewController extends BaseController{

    @Autowired
    private PuriewService puriewService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Puriew> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Puriew> pageInfo = null;
        try {
            pageInfo = puriewService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Puriew puriew){
        puriew.setCreateTime(new Date());
        puriew.setUpdateTime(new Date());
        puriew.setValid("1");
        puriew.setCreater(1L);
        try {
            int k = puriewService.insert(puriew);
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
    public Response<String> edit(Puriew puriew){
        puriew.setCreateTime(new Date());
        puriew.setUpdateTime(new Date());
        puriew.setValid("1");
        puriew.setCreater(1L);
        try {
            int k = puriewService.updateByPrimaryKey(puriew);
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
            int k = puriewService.deleteByPrimaryKey(puriewId);
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
    public Response<Puriew> selectOne(Long puriewId){
         try {
            return renderSuccess(puriewService.selectByPrimaryKey(puriewId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}