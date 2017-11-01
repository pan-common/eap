package com.taiji.eap.common.query.service.impl;

import com.taiji.eap.common.query.dao.QueryDao;
import com.taiji.eap.common.query.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl implements QueryService{

    @Autowired
    private QueryDao queryDao;

    @Override
    public String getTime() {
        return queryDao.getTime();
    }
}
