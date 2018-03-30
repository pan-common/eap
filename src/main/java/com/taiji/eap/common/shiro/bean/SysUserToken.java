package com.taiji.eap.common.shiro.bean;

import java.util.Date;

/**
 * @author 潘宏智
 * @date
 */
public class SysUserToken {

    private String tokenId;

    private String userName;

    private Date createTime;

    private String deviceType;

    public SysUserToken(String tokenId, String userName, Date createTime, String deviceType) {
        this.tokenId = tokenId;
        this.userName = userName;
        this.createTime = createTime;
        this.deviceType = deviceType;
    }

    public SysUserToken() {
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "SysUserToken{" +
                "tokenId='" + tokenId + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }
}
