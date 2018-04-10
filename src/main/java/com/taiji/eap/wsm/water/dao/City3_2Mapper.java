package com.taiji.eap.wsm.water.dao;

import com.taiji.eap.wsm.water.bean.City3_2;

import java.util.List;

public interface City3_2Mapper {

    int deleteByPrimaryKey(String id);

    int insert(City3_2 record);

    int insertSelective(City3_2 record);

    City3_2 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(City3_2 record);

    int updateByPrimaryKey(City3_2 record);
}