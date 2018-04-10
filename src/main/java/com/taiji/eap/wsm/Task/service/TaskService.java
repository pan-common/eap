package com.taiji.eap.wsm.Task.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.wsm.Task.bean.Task;
import com.taiji.eap.wsm.Task.bean.TaskArea;
import com.taiji.eap.wsm.baseInfo.bean.BaseInfo;

import java.util.List;

public interface TaskService{
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 插入数据
     * @param Task
     * @return
     */
    int insert(Task Task) throws Exception;
     /**
     * 根据主键查询数据
     * @param primaryKey
     * @return
     */
    Task selectByPrimaryKey(String primaryKey) throws Exception;
     /**
     * 根据主键修改数据
     * @param Task
     * @return
     */
    int updateByPrimaryKey(Task Task) throws Exception;
     /**
     * 无分页查询数据
     * @param searchText 搜索条件
     * @return
     */
    List<Task> list(String searchText) throws Exception;
     /**
     * 分页查询数据
     * @param pageNum 当前页数
     * @param pageSize 每页行数
     * @param searchText 搜索条件
     * @return
     * @throws Exception
     */
    PageInfo<Task> list(int pageNum, int pageSize, String searchText) throws Exception;
    /**
    * 选择性插入
    * @param Task
    * @return
    */
    int insertSelective(Task Task);
    /**
    * 选择性修改
    * @param Task
    * @return
    */
    int updateByPrimaryKeySelective(Task Task);
    /**
    * 按条件查询
    * @param Task
    * @return
    */
    List<Task> queryAll(Task Task);

    PageInfo<Task> getTaskByUserId(String userId, String taskType, Integer pageNum, Integer pageSize) throws Exception;

    int saveTaskArea(String taskId, List<String> areaId);

    List<Integer> getAreaIdsByTaskId(String taskId);

    List<TaskArea> getTaskAreasByTaskId(String taskId);

    List<Task> selectAll();
}