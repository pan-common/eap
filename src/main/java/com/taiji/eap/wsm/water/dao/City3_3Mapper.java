package com.taiji.eap.wsm.water.dao;

import com.taiji.eap.wsm.water.bean.City3_3;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface City3_3Mapper {

    int deleteByPrimaryKey(String id);

    int insert(City3_3 record);

    int insertSelective(City3_3 record);

    City3_3 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(City3_3 record);

    int updateByPrimaryKey(City3_3 record);
}