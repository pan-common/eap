package com.taiji.eap.common.shiro.filter;

import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 潘宏智
 * @date
 */
public abstract class AbstractMobileAuthenticationFilter extends AuthenticationFilter{

    public static final String TOKEN = "token";

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getParameter(TOKEN);
        if(isAccess(token)){
            return  onAccessSuccess(request,(HttpServletResponse)servletResponse);
        }
        return onAccessFail(request,(HttpServletResponse)servletResponse);
    }

    /**
     * 判断token的合法性
     * @param token
     * @return
     */
    public abstract boolean isAccess(String token);

    /**
     * 认证成功的操作处理
     * @param request
     * @param response
     * @return
     */
    public abstract boolean onAccessSuccess(HttpServletRequest request,HttpServletResponse response);

    /**
     * 认证失败的操作处理
     * @param request
     * @param response
     * @return
     */
    public abstract boolean onAccessFail(HttpServletRequest request,HttpServletResponse response);
}
