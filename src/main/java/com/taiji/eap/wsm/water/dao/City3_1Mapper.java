package com.taiji.eap.wsm.water.dao;

import com.taiji.eap.wsm.water.bean.City3_1;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface City3_1Mapper {

    int deleteByPrimaryKey(String id);

    int insert(City3_1 record);

    int insertSelective(City3_1 record);

    City3_1 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(City3_1 record);

    int updateByPrimaryKey(City3_1 record);
}