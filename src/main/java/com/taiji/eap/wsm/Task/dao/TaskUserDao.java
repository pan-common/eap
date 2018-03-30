package com.taiji.eap.wsm.Task.dao;

import com.taiji.eap.wsm.Task.bean.TaskUser;
import org.apache.ibatis.annotations.Param;

public interface TaskUserDao {

    int insert(TaskUser taskUser);

    /**
     * 通过taskid删除任务成员
     * @param taskId
     * @return
     */
    int deleteByTaskId(@Param("taskId") String taskId);

}
