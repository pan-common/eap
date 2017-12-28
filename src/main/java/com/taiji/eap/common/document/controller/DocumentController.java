package com.taiji.eap.common.document.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.document.bean.Document;
import com.taiji.eap.common.document.service.DocumentService;
import com.taiji.eap.common.http.entity.Response;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("document")
public class DocumentController extends BaseController{

    @Autowired
    private DocumentService documentService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Document> list(Long parentId,Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Document> pageInfo = null;
        try {
            pageInfo = documentService.listByPid(parentId,pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Document document){
        document.setCreateTime(new Date());
        document.setUpdateTime(new Date());
        document.setValid("1");
        document.setCreater(1L);
        try {
            int k = documentService.insert(document);
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
    public Response<String> edit(Document document){
        document.setDocumentMdContent(StringEscapeUtils.unescapeHtml4(document.getDocumentMdContent()));
        document.setCreateTime(new Date());
        document.setUpdateTime(new Date());
        document.setValid("1");
        document.setCreater(1L);

        try {
            int k = documentService.updateSelectiveByPrimaryKey(document);
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
    public Response<String> delete(Long documentId){
        try {
            int k = documentService.deleteByPrimaryKey(documentId);
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
    public Response<Document> selectOne(Long documentId){
         try {
            return renderSuccess(documentService.selectByPrimaryKey(documentId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @GetMapping(value = "getPath")
    @ResponseBody
    public Response<List<Document>> getPath(Long documentId){
         try {
             return renderSuccess(documentService.getPath(documentId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "listByPid")
    @ResponseBody
    public Response<List<Document>> listByPid(Long parentId){
         List<Document> list = null;
         try {
             list = documentService.listByPid(parentId);
             return renderSuccess(list);
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "treeView")
    @ResponseBody
    public Response<List<BaseTree>> treeView(Long parentId){
        List<BaseTree> baseTrees = null;
        try {
            baseTrees = documentService.treeView(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderSuccess(baseTrees);
    }
}