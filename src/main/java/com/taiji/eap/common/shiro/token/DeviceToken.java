package com.taiji.eap.common.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author 潘宏智
 * @date
 */
public class DeviceToken extends UsernamePasswordToken{

    private String deviceType;

    public DeviceToken(String username, String password, String deviceType) {
        super(username, password);
        this.deviceType = deviceType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
