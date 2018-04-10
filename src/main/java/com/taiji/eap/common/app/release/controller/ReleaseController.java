package com.taiji.eap.common.app.release.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.app.release.bean.Release;
import com.taiji.eap.common.app.release.service.ReleaseService;
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

import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("release")
public class ReleaseController extends BaseController{

    @Autowired
    private ReleaseService releaseService;

    @Autowired
    private FileService fileService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Release> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Release> pageInfo = null;
        try {
            pageInfo = releaseService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    /**
     * 获取最新版本的APK
     * @return
     */
    @GetMapping(value = "getLastVersion")
    @ResponseBody
    public Response<Release> getLastVersion(){
        Release release = null;
        try {
            release = releaseService.getLastVersion();
        }catch (Exception e){
            e.printStackTrace();
            return renderError(e.getMessage());
        }
        return renderSuccess(release);
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(MultipartHttpServletRequest request,Release release){
        try {
            MultipartFile file = request.getFile("upload");
            String rootPath = this.getClass().getClassLoader().getResource("").getPath().split("target/")[0]+"file";
            //文件路径不存在则创建
            String datePath = DateUtils.getDatePath();
            File filePath = new File(rootPath+File.separator+"apk"+File.separator+datePath);
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            Long fileSize = file.getSize();
            String fileNativeName = file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-2];
            String fileSuffix = file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
            String fileName = UUIDUtils.getGUID()+"."+fileSuffix;
            String relativePath = "file"+File.separator+"apk"+File.separator+datePath+File.separator+fileName;
            File realFile = new File(filePath,fileName);
            file.transferTo(realFile);
            release.setUrl(relativePath);
            //创建文件记录
            CommonFileInfo commonFileInfo = new CommonFileInfo();
            commonFileInfo.setFileSuffix(fileSuffix);
            commonFileInfo.setFileNativeName(fileNativeName);
            commonFileInfo.setFileGenerateName(fileName.split("\\.")[0]);
            commonFileInfo.setRelativePath(relativePath);
            commonFileInfo.setAbsolutePath(filePath+File.separator+fileName);
            commonFileInfo.setFileSize(fileSize);
            fileService.insert(commonFileInfo);

            release.setFileId(commonFileInfo.getFileId());
            int k = releaseService.insert(release);
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
    public Response<String> edit(Release release){
        try {
            int k = releaseService.updateByPrimaryKey(release);
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
    public Response<String> delete(String versionId){
        try {
            int k = releaseService.deleteByPrimaryKey(versionId);
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
    public Response<Release> selectOne(String versionId){
         try {
            return renderSuccess(releaseService.selectByPrimaryKey(versionId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @PostMapping(value = "uploadFile")
    public Response<String> uploadFile(MultipartHttpServletRequest request){
        String rootPath = this.getClass().getClassLoader().getResource("").getPath().split("target/")[0]+"file";
        //文件路径不存在则创建
        String datePath = DateUtils.getDatePath();
        File filePath = new File(rootPath+File.separator+"apk"+File.separator+datePath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        request.getFile("");
        return renderSuccess("上传成功");
    }
}