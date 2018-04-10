package com.taiji.eap.wsm.water.dao;

import com.taiji.eap.wsm.water.bean.City4_1;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface City4_1Mapper {

    int deleteByPrimaryKey(String id);

    int insert(City4_1 record);

    int insertSelective(City4_1 record);

    City4_1 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(City4_1 record);

    int updateByPrimaryKey(City4_1 record);
}