package com.taiji.eap.common.shiro.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 潘宏智
 * @date
 */
public class MobileAuthenticationFilter extends AbstractMobileAuthenticationFilter{


    @Override
    public boolean isAccess(String token) {

        return false;
    }

    @Override
    public boolean onAccessSuccess(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }

    @Override
    public boolean onAccessFail(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }
}
