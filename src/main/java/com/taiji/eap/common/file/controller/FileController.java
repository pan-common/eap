package com.taiji.eap.common.file.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.file.bean.CommonFileInfo;
import com.taiji.eap.common.file.service.FileService;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.utils.DateUtils;
import com.taiji.eap.common.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("file")
public class FileController extends BaseController{

    @Autowired
    private FileService fileService;

    /**
     * MD文档图片上传
     * @param request
     * @param response
     * @param attach
     * @return
     */
    @PostMapping(value = "editormdFileUpload")
    @ResponseBody
    public Response<String> editormdFileUpload(HttpServletRequest request, HttpServletResponse response,
                                               @RequestParam(value = "editormd-image-file",required = false)MultipartFile attach){
        String rootPath = this.getClass().getClassLoader().getResource("").getPath().split("target/")[0]+"file";
        /**
         * 文件路径不存在则创建
         */
        String datePath = DateUtils.getDatePath();
        File filePath = new File(rootPath+File.separator+datePath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        String fileSuffix = attach.getOriginalFilename().split("\\.")[attach.getOriginalFilename().split("\\.").length-1];
        String fileName = UUIDUtils.getGUID()+"."+fileSuffix;
        String relativePath = "file"+File.separator+datePath+File.separator+fileName;
        File realFile = new File(filePath,fileName);
        try {
            attach.transferTo(realFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer servletPath = request.getRequestURL();
        return  renderSuccess(servletPath.toString().split("eap")[0]+relativePath);
    }

    @PostMapping(value = "batchPicUpload")
    @ResponseBody
    public Response<String> batchPicUpload(MultipartHttpServletRequest request){

        String rootPath = this.getClass().getClassLoader().getResource("").getPath().split("target/")[0]+"file";
        /**
         * 文件路径不存在则创建
         */
        String datePath = DateUtils.getDatePath();
        File filePath = new File(rootPath+File.separator+datePath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        Iterator<String> iter = request.getFileNames();
        while (iter.hasNext()){
            MultipartFile file = request.getFile(iter.next());
            if(file != null){
                String fileSuffix = file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
                String fileName = UUIDUtils.getGUID()+"."+fileSuffix;
                String relativePath = "file"+File.separator+datePath+File.separator+fileName;
                File realFile = new File(filePath,fileName);
                try {
                    file.transferTo(realFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                StringBuffer servletPath = request.getRequestURL();
                return  renderSuccess(servletPath.toString().split("eap")[0]+relativePath);
            }
        }
        return renderError("上传失败");
    }

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<CommonFileInfo> list(Integer pageNum, Integer pageSize, String searchText){
        PageInfo<CommonFileInfo> pageInfo = null;
        try {
            pageInfo = fileService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(CommonFileInfo file){
        file.setCreateTime(new Date());
        file.setUpdateTime(new Date());
        file.setValid("1");
        file.setCreater(1L);
        try {
            int k = fileService.insert(file);
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
    public Response<String> edit(CommonFileInfo file){
        file.setCreateTime(new Date());
        file.setUpdateTime(new Date());
        file.setValid("1");
        file.setCreater(1L);
        try {
            int k = fileService.updateByPrimaryKey(file);
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
    public Response<String> delete(String fileId){
        try {
            int k = fileService.deleteByPrimaryKey(fileId);
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
    public Response<CommonFileInfo> selectOne(String fileId){
        try {
            return renderSuccess(fileService.selectByPrimaryKey(fileId));
        } catch (Exception e) {
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }
}