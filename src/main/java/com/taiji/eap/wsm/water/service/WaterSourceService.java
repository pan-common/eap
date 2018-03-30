package com.taiji.eap.wsm.water.service;

import com.taiji.eap.wsm.water.bean.WaterSource;

import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
public interface WaterSourceService {

    List<WaterSource> selectAll() throws Exception;

    /**
     * 查询全部地级上的数据
     * @return
     * @throws Exception
     */
    List<WaterSource> selectDjsAll() throws Exception;

    /**
     * 查询全部地级下的数据
     * @return
     * @throws Exception
     */
    List<WaterSource> selectDjxAll() throws Exception;


}
