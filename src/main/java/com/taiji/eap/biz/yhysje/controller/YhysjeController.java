package com.taiji.eap.biz.yhysje.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.biz.yhysje.bean.Yhysje;
import com.taiji.eap.biz.yhysje.service.YhysjeService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("yhysje")
public class YhysjeController extends BaseController{

    @Autowired
    private YhysjeService yhysjeService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Yhysje> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Yhysje> pageInfo = null;
        try {
            pageInfo = yhysjeService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Yhysje yhysje){
        try {
            int k = yhysjeService.insert(yhysje);
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
    public Response<String> edit(Yhysje yhysje){
        try {
            int k = yhysjeService.updateByPrimaryKey(yhysje);
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
            int k = yhysjeService.deleteByPrimaryKey(id);
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
    public Response<Yhysje> selectOne(Long id){
         try {
            return renderSuccess(yhysjeService.selectByPrimaryKey(id));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }

    @PostMapping(value = "importExcel")
    @ResponseBody
    public Response<String> importExcel(MultipartHttpServletRequest request){
        MultipartFile jk_upload = request.getFile("jk_upload");
        MultipartFile dk_upload = request.getFile("dk_upload");

        try {
            yhysjeService.importJk(jk_upload.getInputStream());
            yhysjeService.importDk(jk_upload.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return renderSuccess("导入成功");
    }
}