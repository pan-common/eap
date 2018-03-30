package com.taiji.eap.common.shiro.exception;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;

/**
 * 用户已经登陆异常
 * @author 潘宏智
 * @date
 */
public class HaveLandedException extends AuthenticationException {

    public HaveLandedException() {
        super();
    }

    public HaveLandedException(String message) {
        super(message);
    }

    public HaveLandedException(Throwable cause) {
        super(cause);
    }

    public HaveLandedException(String message, Throwable cause) {
        super(message, cause);
    }
}
