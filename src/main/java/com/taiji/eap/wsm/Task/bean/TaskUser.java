package com.taiji.eap.wsm.Task.bean;

/**
 * @author 潘宏智
 * @date
 */
public class TaskUser {

    private Long id;//主键
    private Long userId;//用户ID
    private String taskId;//任务ID
    private String isPrincipal;//是否主要负责人

    public TaskUser(Long id, Long userId, String taskId, String isPrincipal) {
        this.id = id;
        this.userId = userId;
        this.taskId = taskId;
        this.isPrincipal = isPrincipal;
    }

    public TaskUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(String isPrincipal) {
        this.isPrincipal = isPrincipal;
    }

    @Override
    public String toString() {
        return "TaskUserDao{" +
                "id=" + id +
                ", userId=" + userId +
                ", taskId='" + taskId + '\'' +
                ", isPrincipal='" + isPrincipal + '\'' +
                '}';
    }
}
