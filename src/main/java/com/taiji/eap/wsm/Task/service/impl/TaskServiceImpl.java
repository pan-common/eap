package com.taiji.eap.wsm.Task.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.area.bean.Area;
import com.taiji.eap.common.area.service.AreaService;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.utils.UUIDUtils;
import com.taiji.eap.wsm.Task.bean.Task;
import com.taiji.eap.wsm.Task.bean.TaskArea;
import com.taiji.eap.wsm.Task.bean.TaskUser;
import com.taiji.eap.wsm.Task.dao.TaskAreaDao;
import com.taiji.eap.wsm.Task.dao.TaskDao;
import com.taiji.eap.wsm.Task.dao.TaskUserDao;
import com.taiji.eap.wsm.Task.service.TaskService;
import com.taiji.eap.wsm.baseInfo.bean.BaseInfo;
import com.taiji.eap.wsm.baseInfo.dao.BaseInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl extends BaseController implements TaskService{

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskUserDao taskUserDao;
    @Autowired
    private TaskAreaDao taskAreaDao;

    @Autowired
    private BaseInfoDao baseInfoDao;


    @Autowired
    private AreaService areaService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(String primaryKey) {
        int k = 0;
        k+= taskUserDao.deleteByTaskId(primaryKey);
        k+=taskDao.deleteByPrimaryKey(primaryKey);
        return k;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Task task) throws Exception {
        int k = 0;
        String taskId = UUIDUtils.getGUID();
        //插入任务相关人员信息
        List<BaseInfo> users = new ArrayList<>();
        users.add(task.getPrincipal());
        users.addAll(task.getBaseInfos());
        for (int i = 0; i < users.size(); i++) {
            TaskUser taskUser = new TaskUser();
            taskUser.setTaskId(taskId);
            taskUser.setUserId(Long.valueOf(users.get(i).getUserId()));
            if(users.get(i).getUserId().equals(task.getPrincipal().getUserId())){
                taskUser.setIsPrincipal("1");
            }else {
                taskUser.setIsPrincipal("2");
            }
            k+=taskUserDao.insert(taskUser);
        }
        //插入任务相关地区信息
        List<Area> areas = task.getAreas();
        if(areas!=null&&areas.size()>0) {
            for (int i = 0; i < areas.size(); i++) {
                TaskArea taskArea = new TaskArea();
                taskArea.setTaskId(taskId);
                taskArea.setAreaId(areas.get(i).getAreaId());
                k += taskAreaDao.insert(taskArea);
            }
        }
        //插入任务信息
        task.setTaskId(taskId);
        task.setCreateTime(new Date());
        task.setTaskCreator(getCurrentUser().getUserId());
        k+=taskDao.insert(task);
        return k;
    }

    @Override
    public Task selectByPrimaryKey(String primaryKey) throws Exception {
        //通过taskId查询用户
        Task task = taskDao.selectByPrimaryKey(primaryKey);
        List<BaseInfo> baseInfos = baseInfoDao.selectByTaskId(primaryKey,"2");
        BaseInfo principal = baseInfoDao.selectByTaskId(primaryKey,"1").get(0);
        task.setBaseInfos(baseInfos);
        task.setPrincipal(principal);
        List<Area> areas = taskAreaDao.getAreaByTaskId(primaryKey);
        task.setAreas(areas);
        return task;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Task task) {
        int k = 0;
        String taskId = task.getTaskId();
        //删除任务相关人员
        k+=taskUserDao.deleteByTaskId(taskId);
        //添加任务相关人员
        List<BaseInfo> users = new ArrayList<>();
        users.add(task.getPrincipal());
        users.addAll(task.getBaseInfos());
        for (int i = 0; i < users.size(); i++) {
            TaskUser taskUser = new TaskUser();
            taskUser.setTaskId(taskId);
            taskUser.setUserId(Long.valueOf(users.get(i).getUserId()));
            if(users.get(i).getUserId().equals(task.getPrincipal().getUserId())){
                taskUser.setIsPrincipal("1");
            }else {
                taskUser.setIsPrincipal("2");
            }
            k+=taskUserDao.insert(taskUser);
        }
        //删除任务相关地区
        taskAreaDao.deleteAreaByTaskId(taskId);
        //插入任务相关地区信息
        List<Area> areas = task.getAreas();
        for (int i = 0; i < areas.size(); i++) {
            TaskArea taskArea = new TaskArea();
            taskArea.setTaskId(taskId);
            taskArea.setAreaId(areas.get(i).getAreaId());
            k+=taskAreaDao.insert(taskArea);
        }
        //插入任务信息
        task.setCreateTime(new Date());
        task.setTaskCreator(getCurrentUser().getUserId());
        k+=taskDao.updateByPrimaryKey(task);
        return k;
    }

    @Override
    public List<Task> list(String searchText) {
        return taskDao.list(searchText);
    }

    @Override
    public PageInfo<Task> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Task> tasks = taskDao.list(searchText);
        for (int i = 0; i < tasks.size(); i++) {
            if(!StringUtils.isEmpty(tasks.get(i).getTaskSheng().trim())) {
                tasks.get(i).setTaskSheng(areaService.selectByPrimaryKey(Integer.valueOf(tasks.get(i).getTaskSheng())).getAreaName());
            }
            if(!StringUtils.isEmpty(tasks.get(i).getTaskShi().trim())) {
                tasks.get(i).setTaskShi(areaService.selectByPrimaryKey(Integer.valueOf(tasks.get(i).getTaskShi())).getAreaName());
            }
            if(!StringUtils.isEmpty(tasks.get(i).getTaskXian().trim())) {
                tasks.get(i).setTaskXian(areaService.selectByPrimaryKey(Integer.valueOf(tasks.get(i).getTaskXian())).getAreaName());
            }
        }
        PageInfo<Task> pageInfo = new PageInfo<Task>(tasks);
        return pageInfo;
    }

    @Override
    public PageInfo<Task> getTaskByUserId(String userId, String taskType, Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Task> tasks;
        if(taskType.equals("1")){
            tasks = taskDao.getCurrentTaskByUserId(userId);
        }else {
            tasks = taskDao.getHistoryTaskByUserId(userId);
        }

        for (int i = 0; i <tasks.size() ; i++) {
            Task task = tasks.get(i);
            //添加任务成员
            List<BaseInfo> baseInfos = baseInfoDao.selectByTaskId(task.getTaskId(),"2");
            BaseInfo principal = baseInfoDao.selectByTaskId(task.getTaskId(),"1").get(0);
            tasks.get(i).setBaseInfos(baseInfos);
            tasks.get(i).setPrincipal(principal);
            //添加任务区域
            List<Area> areas = taskAreaDao.getAreaByTaskId(task.getTaskId());
            tasks.get(i).setAreas(areas);
        }

        PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        return pageInfo;
    }

    @Override
    public int saveTaskArea(String taskId, List<String> areaId) {
        int k = 0;
        k+=taskAreaDao.deleteAreaByTaskId(taskId);
        for (int i = 0; i < areaId.size(); i++) {
            TaskArea taskArea = new TaskArea();
            taskArea.setTaskId(taskId);
            taskArea.setAreaId(Integer.valueOf(areaId.get(i)));
            k+=taskAreaDao.insert(taskArea);
        }
        return k;
    }

    @Override
    public List<Integer> getAreaIdsByTaskId(String taskId) {
        List<Integer> areaIds = taskAreaDao.getAreaIdsByTaskId(taskId);
        return areaIds;
    }

    @Override
    public List<TaskArea> getTaskAreasByTaskId(String taskId) {
        return taskAreaDao.getTaskAreasByTaskId(taskId);
    }

    @Override
    public List<Task> selectAll() {
        List<Task> tasks =  taskDao.selectAll();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            //添加任务成员
            List<BaseInfo> baseInfos = baseInfoDao.selectByTaskId(task.getTaskId(),"2");
            BaseInfo principal = baseInfoDao.selectByTaskId(task.getTaskId(),"1").get(0);
            tasks.get(i).setBaseInfos(baseInfos);
            tasks.get(i).setPrincipal(principal);
            //添加任务区域
            List<Area> areas = taskAreaDao.getAreaByTaskId(task.getTaskId());
            tasks.get(i).setAreas(areas);
        }
        return tasks;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(Task task) {
        return taskDao.insertSelective(task);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(Task task) {
        return taskDao.updateByPrimaryKeySelective(task);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Task> queryAll(Task task) {
        return taskDao.queryAll(task);
    }

}