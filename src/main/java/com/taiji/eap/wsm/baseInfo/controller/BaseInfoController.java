package com.taiji.eap.wsm.baseInfo.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.dictionary.annotation.DictionaryResponse;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.wsm.baseInfo.bean.BaseInfo;
import com.taiji.eap.wsm.baseInfo.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("baseInfo")
public class BaseInfoController extends BaseController{

    @Autowired
    private BaseInfoService baseInfoService;

    @GetMapping(value = "list")
    @ResponseBody
    @DictionaryResponse
    public PageInfo<BaseInfo> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<BaseInfo> pageInfo = null;
        try {
            pageInfo = baseInfoService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(BaseInfo baseInfo){
        try {
            int k = baseInfoService.insert(baseInfo);
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
    public Response<String> edit(BaseInfo baseInfo){
        try {
            int k = baseInfoService.updateByPrimaryKey(baseInfo);
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
    public Response<String> delete(String baseId){
        try {
            int k = baseInfoService.deleteByPrimaryKey(baseId);
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
    public Response<BaseInfo> selectOne(String baseId){
         try {
            return renderSuccess(baseInfoService.selectByPrimaryKey(baseId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }

    @GetMapping(value = "selectOneByUserId")
    @ResponseBody
    public BaseInfo selectOneByUserId(String userId){
        BaseInfo baseInfo = null;
        try {
            baseInfo = baseInfoService.selectOneByUserId(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return baseInfo;
    }
}