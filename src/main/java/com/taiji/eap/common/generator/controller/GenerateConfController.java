package com.taiji.eap.common.generator.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.GenerateConf;
import com.taiji.eap.common.generator.service.GenerateConfService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("generateConf")
public class GenerateConfController extends BaseController{

    @Autowired
    private GenerateConfService generateConfService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<GenerateConf> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<GenerateConf> pageInfo = null;
        try {
            pageInfo = generateConfService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(GenerateConf generateConf){
        try {
            int k = generateConfService.insert(generateConf);
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
    public Response<String> edit(GenerateConf generateConf){
        try {
            int k = generateConfService.updateByPrimaryKey(generateConf);
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
    public Response<String> delete(Long configId){
        try {
            int k = generateConfService.deleteByPrimaryKey(configId);
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
    public Response<GenerateConf> selectOne(Long configId){
         try {
            return renderSuccess(generateConfService.selectByPrimaryKey(configId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}