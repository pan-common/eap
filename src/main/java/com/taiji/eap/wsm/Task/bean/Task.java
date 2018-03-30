
package com.taiji.eap.wsm.Task.bean;

import java.util.Date;
import java.util.List;

import com.taiji.eap.common.area.bean.Area;
import com.taiji.eap.common.dictionary.annotation.Dictionary;
import com.taiji.eap.common.shiro.bean.SysUser;
import com.taiji.eap.wsm.baseInfo.bean.BaseInfo;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class Task extends BaseModel{

    private String taskId;//任务主键
    private String taskName;//任务名称
    private String taskContent;//任务内容
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date startTime;//任务开始时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date endTime;//任务结束时间
    private String taskSheng;//省
    private String taskShi;//市
    private String taskXian;//县
    private Long taskCreator;//任务创建人
    private String remarks;//任务备注
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date createTime;//任务创建时间

    private List<BaseInfo> baseInfos;

    private List<Area> areas;//任务涉及地区

    private BaseInfo principal;//主要负责人

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public String getTaskSheng() {
        return taskSheng;
    }

    public void setTaskSheng(String taskSheng) {
        this.taskSheng = taskSheng;
    }


    public String getTaskShi() {
        return taskShi;
    }

    public void setTaskShi(String taskShi) {
        this.taskShi = taskShi;
    }


    public String getTaskXian() {
        return taskXian;
    }

    public void setTaskXian(String taskXian) {
        this.taskXian = taskXian;
    }


    public Long getTaskCreator() {
        return taskCreator;
    }

    public void setTaskCreator(Long taskCreator) {
        this.taskCreator = taskCreator;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<BaseInfo> getBaseInfos() {
        return baseInfos;
    }

    public void setBaseInfos(List<BaseInfo> baseInfos) {
        this.baseInfos = baseInfos;
    }

    public BaseInfo getPrincipal() {
        return principal;
    }

    public void setPrincipal(BaseInfo principal) {
        this.principal = principal;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
