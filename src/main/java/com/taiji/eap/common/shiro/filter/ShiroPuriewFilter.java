package com.taiji.eap.common.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ShiroPuriewFilter extends PermissionsAuthorizationFilter{

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        Subject subject = getSubject(request,response);
        String[] puriew = (String[]) mappedValue;
        boolean isPermitted = false;
        if (puriew != null && puriew.length > 0) {
            for (String string : puriew) {
                if (subject.isPermitted(string)) {
                    isPermitted = true;
                    break;
                }
            }
        } else {
            isPermitted = true;
        }
        return isPermitted;
    }
}
