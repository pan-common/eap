package com.taiji.eap.wsm.water.dao;

import com.taiji.eap.wsm.water.bean.City1_3;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface City1_3Mapper {


    int deleteByPrimaryKey(String id);

    int insert(City1_3 record);

    int insertSelective(City1_3 record);

    City1_3 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(City1_3 record);

    int updateByPrimaryKey(City1_3 record);
}