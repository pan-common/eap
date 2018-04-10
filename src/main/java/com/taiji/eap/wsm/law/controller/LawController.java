package com.taiji.eap.wsm.law.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.file.bean.CommonFileInfo;
import com.taiji.eap.common.file.service.FileService;
import com.taiji.eap.common.utils.DateUtils;
import com.taiji.eap.common.utils.UUIDUtils;
import com.taiji.eap.wsm.law.bean.Law;
import com.taiji.eap.wsm.law.service.LawService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("law")
public class LawController extends BaseController{

    @Autowired
    private LawService lawService;
    @Autowired
    private FileService fileService;


    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Law> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Law> pageInfo = null;
        try {
            pageInfo = lawService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    /**
     * 查询全部法律法规
     * @return
     */
    @GetMapping(value = "selectAll")
    @ResponseBody
    public List<Law> selectAll(){
        List<Law> laws = null;
        try {
            laws = lawService.selectAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return laws;
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(MultipartHttpServletRequest request, Law law){
        try {
            MultipartFile file = request.getFile("upload");
            String rootPath = this.getClass().getClassLoader().getResource("").getPath().split("target/")[0]+"file";
            //文件路径不存在则创建
            String datePath = DateUtils.getDatePath();
            File filePath = new File(rootPath+File.separator+"law"+File.separator+datePath);
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            Long fileSize = file.getSize();
            String fileNativeName = file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-2];
            String fileSuffix = file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
            String fileName = UUIDUtils.getGUID()+"."+fileSuffix;
            String relativePath = "file"+File.separator+"law"+File.separator+datePath+File.separator+fileName;
            File realFile = new File(filePath,fileName);
            file.transferTo(realFile);
            //创建文件记录
            CommonFileInfo commonFileInfo = new CommonFileInfo();
            commonFileInfo.setFileSuffix(fileSuffix);
            commonFileInfo.setFileNativeName(fileNativeName);
            commonFileInfo.setFileGenerateName(fileName.split("\\.")[0]);
            commonFileInfo.setRelativePath(relativePath);
            commonFileInfo.setAbsolutePath(filePath+File.separator+fileName);
            commonFileInfo.setFileSize(fileSize);
            fileService.insert(commonFileInfo);
            law.setFileId(commonFileInfo.getFileId());

            int k = lawService.insert(law);
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
    public Response<String> edit(Law law){
        try {
            int k = lawService.updateByPrimaryKey(law);
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
    public Response<String> delete(String lawId){
        try {
            int k = lawService.deleteByPrimaryKey(lawId);
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
    public Response<Law> selectOne(String lawId){
         try {
            return renderSuccess(lawService.selectByPrimaryKey(lawId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}