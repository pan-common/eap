package com.taiji.eap.wsm.water.dao;


import com.taiji.eap.wsm.water.bean.City1_1;

public interface City1_1Mapper {

    int deleteByPrimaryKey(String id);

    int insert(City1_1 record);

    int insertSelective(City1_1 record);

    City1_1 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(City1_1 record);

    int updateByPrimaryKey(City1_1 record);
}