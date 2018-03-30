package com.taiji.eap.wsm.Task.dao;

import com.taiji.eap.wsm.Task.bean.Task;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TaskDao {
     /**
     * 通过主键删除数据
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey);
     /**
     * 添加数据
     * @param Task
     * @return
     */
    int insert(Task Task);
     /**
     * 通过主键查询数据
     * @param primaryKey
     * @return
     */
    Task selectByPrimaryKey(String primaryKey);
     /**
     * 修改数据
     * @param Task
     * @return
     */
    int updateByPrimaryKey(Task Task);
     /**
     * 搜索数据
     * @param searchText 搜索条件
     * @return
     */
    List<Task> list(@Param("searchText") String searchText);

     /**
     * 查询全部数据
     * @return
     */
    List<Task> selectAll();
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

    /**
     * 获取用户当前任务列表
     * @return
     */
    List<Task> getCurrentTaskByUserId(@Param("userId")String userId);

    /**
     * 获取用户历史任务列表
     * @return
     */
    List<Task> getHistoryTaskByUserId(@Param("userId")String userId);
}