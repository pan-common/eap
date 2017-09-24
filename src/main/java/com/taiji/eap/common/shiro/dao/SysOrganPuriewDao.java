package com.taiji.eap.common.shiro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysOrganPuriewDao {

	List<Long> selectPuriewIdByOrganIds(@Param("organIds")List<Long> organIds);

}
