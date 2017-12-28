package com.taiji.eap.biz.zxjg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.zxjg.bean.Zxjg;
import com.taiji.eap.biz.zxjg.dao.ZxjgDao;
import com.taiji.eap.biz.zxjg.service.ZxjgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

@Service
public class ZxjgServiceImpl implements ZxjgService,Pipeline {

    @Autowired
    private ZxjgDao zxjgDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return zxjgDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Zxjg zxjg) {
        return zxjgDao.insert(zxjg);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int plInser(List<Zxjg> zxjgs) throws Exception {
        int k = 0;
        for (int i = 0; i < zxjgs.size(); i++) {
            k+=zxjgDao.insert(zxjgs.get(i));
        }
        return k;
    }


    @Override
    public Zxjg selectByPrimaryKey(Long primaryKey) {
        return zxjgDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Zxjg zxjg) {
        return zxjgDao.updateByPrimaryKey(zxjg);
    }

    @Override
    public List<Zxjg> list(String searchText) {
        return zxjgDao.list(searchText);
    }

    @Override
    public PageInfo<Zxjg> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Zxjg> zxjgs = zxjgDao.list(searchText);
        PageInfo<Zxjg> pageInfo = new PageInfo<Zxjg>(zxjgs);
        return pageInfo;
    }


    @Override
    public void process(ResultItems resultItems, Task task) {
        Zxjg zxjg =  resultItems.get("result");
        insert(zxjg);
    }
}