package com.taiji.eap.biz.qywh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.qywh.bean.HbSjcjQyJbxx;
import com.taiji.eap.biz.qywh.dao.HbSjcjQyJbxxDao;
import com.taiji.eap.biz.qywh.service.HbSjcjQyJbxxService;
import com.taiji.eap.common.datasource.annotation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 潘宏智
 * @date
 */
@Service
@DataSource("jcpt")
public class HbSjcjQyJbxxServiceImpl implements HbSjcjQyJbxxService{

    @Autowired
    private HbSjcjQyJbxxDao hbSjcjQyJbxxDao;

    @Override
    public PageInfo<HbSjcjQyJbxx> selectByQymc(int pageNum, int pageSize, String qymc) {
        PageHelper.startPage(pageNum, pageSize);
        List<HbSjcjQyJbxx> hbSjcjQyJbxxes = hbSjcjQyJbxxDao.selectByQymc(qymc);
        PageInfo<HbSjcjQyJbxx> pageInfo = new PageInfo<>(hbSjcjQyJbxxes);
        return pageInfo;
    }
}
