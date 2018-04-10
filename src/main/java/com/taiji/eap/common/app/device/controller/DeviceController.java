package com.taiji.eap.common.app.device.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.app.device.bean.Device;
import com.taiji.eap.common.app.device.service.DeviceService;
import com.taiji.eap.common.http.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("device")
public class DeviceController extends BaseController{

    @Autowired
    private DeviceService deviceService;

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Device> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Device> pageInfo = null;
        try {
            pageInfo = deviceService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Device device){
        try {
            int k = deviceService.insert(device);
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
    public Response<String> edit(Device device){
        try {
            int k = deviceService.updateByPrimaryKey(device);
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
    public Response<String> delete(String deviceId){
        try {
            int k = deviceService.deleteByPrimaryKey(deviceId);
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
    public Response<Device> selectOne(String deviceId){
         try {
            return renderSuccess(deviceService.selectByPrimaryKey(deviceId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }
}