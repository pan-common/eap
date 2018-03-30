package com.taiji.eap.wsm.water.service.impl;

import com.taiji.eap.common.datasource.annotation.DataSource;
import com.taiji.eap.common.redis.dao.impl.RedisFactoryDao;
import com.taiji.eap.wsm.water.bean.WaterSource;
import com.taiji.eap.wsm.water.dao.WaterSourceDao;
import com.taiji.eap.wsm.water.service.WaterSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
@Service
@DataSource("oracle")
public class WaterSourceServiceImpl implements WaterSourceService{

    @Autowired
    private WaterSourceDao waterSourceDao;

    @Autowired
    private RedisFactoryDao<WaterSource> redisFactoryDao;

    @Override
    public List<WaterSource> selectAll() throws Exception {
        List<WaterSource> waterSources = new ArrayList<>();
        waterSources.addAll(selectDjsAll());
        waterSources.addAll(selectDjxAll());
        return waterSources;
    }

    @DataSource("oracle")
    @Override
    public List<WaterSource> selectDjsAll() throws Exception {
        List<WaterSource> waterSources = redisFactoryDao.getDatas("waterSource:djsWaterSource", "", new RedisFactoryDao.OnRedisSelectListener() {
            @Override
            public List fruitless() {
                return waterSourceDao.selectAll();
            }
        });
        return waterSources;
    }

    @DataSource("djx")
    @Override
    public List<WaterSource> selectDjxAll() throws Exception {
        List<WaterSource> waterSources = redisFactoryDao.getDatas("waterSource:djxWaterSource", "", new RedisFactoryDao.OnRedisSelectListener() {
            @Override
            public List fruitless() {
                return waterSourceDao.selectAll();
            }
        });
        return waterSources;
    }


}
