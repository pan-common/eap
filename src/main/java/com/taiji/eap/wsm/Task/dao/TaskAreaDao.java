package com.taiji.eap.wsm.Task.dao;

import com.taiji.eap.common.area.bean.Area;
import com.taiji.eap.wsm.Task.bean.TaskArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
public interface TaskAreaDao {
    
    int insert(TaskArea taskArea);

    int deleteAreaByTaskId(@Param("taskId") String taskId);

    List<Integer> getAreaIdsByTaskId(@Param("taskId")String taskId);


    List<Area> getAreaByTaskId(String primaryKey);

    List<TaskArea> getTaskAreasByTaskId(String taskId);
}
