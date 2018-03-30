package com.taiji.eap.wsm.Task.bean;

/**
 * @author 潘宏智
 * @date
 */
public class TaskArea {

    private Long id;
    private String taskId;
    private Integer areaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
