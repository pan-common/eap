package com.taiji.eap.common.shiro.filter;

import java.util.Map;

public interface ShiroChainDefinitionsService {

    public static final String PORPERMS_STRING = "system[%s]";

    /**
     * 初始化框架权限资源配置
     */
    public void intiPermission();

    /**
     * 重新加载框架权限资源配置
     * @throws Exception
     */
    public void updatePermission() throws Exception;

    /**
     * 初始化第三方权限资源配置
     * @return
     */
    public Map<String, String> initOtherPermission();

    /**
     * 拆分多个地址生成正确的表达式
     * @param map
     * @return
     */
    public Map<String,String> dealWithExpression(Map<String, String> map);

}
