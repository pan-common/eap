package com.taiji.eap.common.shiro.dao;

import com.taiji.eap.common.shiro.bean.SysUserToken;
import org.apache.ibatis.annotations.Param;

/**
 * @author 潘宏智
 * @date
 */
public interface SysUserTokenDao {

    /**
     * 通过tokenId查询token信息
     * @param token
     * @return
     */
    SysUserToken selectByPrimaryKey(@Param("tokenId") String token);

    /**
     * 插入用户登陆token信息
     * @param sysUserToken
     * @return
     */
    int insert(SysUserToken sysUserToken);

    /**
     * 删除用户token信息通过用户ID
     * @param userName
     * @return
     */
    int deleteByUserId(@Param("userName") String userName,@Param("deviceType")String deviceType);

    /**
     * 通过用户名查询用户的token信息
     * @param userName 用户名
     * @param deviceType 设备类型
     * @return
     */
    SysUserToken selectUserTokenByUserName(@Param("userName") String userName,@Param("deviceType")String deviceType);
}
