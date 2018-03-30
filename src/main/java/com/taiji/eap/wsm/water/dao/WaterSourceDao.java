package com.taiji.eap.wsm.water.dao;

import com.taiji.eap.wsm.water.bean.WaterSource;

import java.util.List;

public interface WaterSourceDao {

    List<WaterSource> selectAll();
}
