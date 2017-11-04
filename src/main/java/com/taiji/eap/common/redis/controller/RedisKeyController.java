package com.taiji.eap.common.redis.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.redis.bean.RedisKey;
import com.taiji.eap.common.redis.service.RedisKeyService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("redisKey")
public class RedisKeyController extends BaseController{

    @Autowired
    private RedisKeyService redisKeyService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<RedisKey> list(Long parentId,Integer pageNum,Integer pageSize,String searchText){
        PageInfo<RedisKey> pageInfo = null;
        try {
            pageInfo = redisKeyService.listByPid(parentId,pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(RedisKey redisKey){
        try {
            int k = redisKeyService.insert(redisKey);
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
    public Response<String> edit(RedisKey redisKey){
        try {
            int k = redisKeyService.updateByPrimaryKey(redisKey);
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
    public Response<String> delete(Long keyId){
        try {
            int k = redisKeyService.deleteByPrimaryKey(keyId);
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
    public Response<RedisKey> selectOne(Long keyId){
         try {
            return renderSuccess(redisKeyService.selectByPrimaryKey(keyId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
    @GetMapping(value = "getPath")
    @ResponseBody
    public Response<List<RedisKey>> getPath(Long keyId){
         try {
             return renderSuccess(redisKeyService.getPath(keyId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "listByPid")
    @ResponseBody
    public Response<List<RedisKey>> listByPid(Long parentId){
         List<RedisKey> list = null;
         try {
             list = redisKeyService.listByPid(parentId);
             return renderSuccess(list);
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
         }
    }

    @GetMapping(value = "treeView")
    @ResponseBody
    public Response<List<LayuiTree>> treeView(Long parentId){
        List<LayuiTree> layuiTrees = null;
        try {
            layuiTrees = redisKeyService.treeView(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return renderSuccess(layuiTrees);
    }
}