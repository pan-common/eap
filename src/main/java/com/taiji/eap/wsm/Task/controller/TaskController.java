package com.taiji.eap.wsm.Task.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.dictionary.service.DictionaryService;
import com.taiji.eap.wsm.Task.bean.Task;
import com.taiji.eap.wsm.Task.bean.TaskArea;
import com.taiji.eap.wsm.Task.service.TaskService;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.wsm.baseInfo.bean.BaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("task")
public class TaskController extends BaseController{

    @Autowired
    private TaskService taskService;

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));
    }

    @GetMapping(value = "list")
    @ResponseBody
    public PageInfo<Task> list(Integer pageNum,Integer pageSize,String searchText){
        PageInfo<Task> pageInfo = null;
        try {
            pageInfo = taskService.list(pageNum,pageSize,searchText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    @GetMapping(value = "selectAll")
    @ResponseBody
    public List<Task> selectAll(){
        List<Task> tasks = new ArrayList<>();
        try {
            tasks = taskService.selectAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    @GetMapping(value = "getTaskByUserId")
    @ResponseBody
    public PageInfo<Task> getTaskByUserId(String userId,String taskType,Integer pageNum,Integer pageSize){
        PageInfo<Task> pageInfo = null;
        try {
        pageInfo = taskService.getTaskByUserId(userId,taskType,pageNum,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Response<String> add(Task task){
        try {
            int k = taskService.insert(task);
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
    public Response<String> edit(Task Task){
        try {
            int k = taskService.updateByPrimaryKey(Task);
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
    public Response<String> delete(String taskId){
        try {
            int k = taskService.deleteByPrimaryKey(taskId);
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
    public Response<Task> selectOne(String taskId){
         try {
            return renderSuccess(taskService.selectByPrimaryKey(taskId));
         } catch (Exception e) {
             e.printStackTrace();
             return renderError(e.getMessage());
          }
    }

    @PostMapping(value = "saveTaskArea")
    @ResponseBody
    public Response<String> saveTaskArea(String taskId,String areaIds){
        if(!StringUtils.isEmpty(areaIds)){
            String[] arr = areaIds.split(",");
            List<String> longs = Arrays.asList(arr);
            int k = taskService.saveTaskArea(taskId,longs);
            if(k>0) {
                return renderSuccess("保存成功");
            } else {
                return renderError("保存失败");
            }
        }else {
            return renderError("没有数据提交");
        }
    }

    @GetMapping(value = "getAreaIdsByTaskId")
    @ResponseBody
    public Response<List<Integer>> getAreaIdsByTaskId(String taskId){
        return renderSuccess(taskService.getAreaIdsByTaskId(taskId));
    }

    @GetMapping(value = "getTaskAreasByTaskId")
    @ResponseBody
    public List<TaskArea> getTaskAreasByTaskId(String taskId){
        return taskService.getTaskAreasByTaskId(taskId);
    }

    /**
     * 添加期数
     * @param dictionary
     * @return
     */
    @PostMapping(value = "addIssue")
    @ResponseBody
    public Response<String> addIssue(Dictionary dictionary){
        dictionary.setCreateTime(new Date());
        dictionary.setUpdateTime(new Date());
        dictionary.setValid("1");
        dictionary.setCreater(getCurrentUser().getUserId());
        try {
            int k = dictionaryService.insertMissParam(dictionary);
            if(k>0){
                return renderSuccess("添加成功");
            }else {
                return renderError("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return renderError(e.getMessage());
        }
    }

    @PostMapping(value = "editIssue")
    @ResponseBody
    public Response<String> editIssue(Dictionary dictionary){
        dictionary.setUpdateTime(new Date());
        dictionary.setValid("1");
        dictionary.setCreater(getCurrentUser().getUserId());
        try {
            int k = dictionaryService.updateByPrimaryKey(dictionary);
            if(k>0){
                return renderSuccess("修改成功");
            }else {
                return renderError("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return renderError(e.getMessage());
        }

    }

}