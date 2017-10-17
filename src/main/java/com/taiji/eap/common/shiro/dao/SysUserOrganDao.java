package com.taiji.eap.common.shiro.dao;

import java.util.List;

public interface SysUserOrganDao {

    /**
     * 通过用户ID获取部门ID列表
     * @param userId
     * @return
     */
    List<Long> getOrganIdsByUserId(Long userId);
}
