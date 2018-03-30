
package com.taiji.eap.wsm.baseInfo.bean;

import java.util.Date;

import com.taiji.eap.common.dictionary.annotation.Dictionary;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class BaseInfo extends BaseModel{
    private String baseId;//基本信息ID
    private Long userId;//用户ID
    private String fullName;//姓名
    @Dictionary(dataSource = "dictionary",params = "195")
    private String gender;//性别
    @Dictionary(dataSource = "dictionary",params = "198")
    private String nation;//民族
    @Dictionary(dataSource = "dictionary",params = "202")
    private String education;//受教育程度
    @Dictionary(dataSource = "dictionary",params = "207")
    private String maritalStatus;//婚姻状况
    private String identityCard;//身份证号码
    @Dictionary(dataSource = "dictionary",params = "213")
    private String politicsStatus;//政治面貌
    @Dictionary(dataSource = "dictionary",params = "34")
    private String zsbz;//正式编制
    private String phoneNumber;//电话号码
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date updateTime;//修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date createTime;//创建时间
    private String valid;//是否有效
    private String userName;//登陆名
    @Dictionary(dataSource = "dictionary",params = "227")
    private String organId;//部门
    @Dictionary(dataSource = "dictionary",params = "218")
    private String jobTitle;//职称

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }


    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }


    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }


    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }


    public String getZsbz() {
        return zsbz;
    }

    public void setZsbz(String zsbz) {
        this.zsbz = zsbz;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
