package com.taiji.eap.biz.zxjg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.jcxmjg.bean.Jcxmjg;
import com.taiji.eap.biz.jcxmjg.dao.JcxmjgDao;
import com.taiji.eap.biz.zxjg.bean.Zxjg;
import com.taiji.eap.biz.zxjg.dao.ZxjgDao;
import com.taiji.eap.biz.zxjg.service.ZxjgService;
import com.taiji.eap.common.datasource.annotation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;

@Service
@DataSource("jcpt")
public class ZxjgServiceImpl implements ZxjgService,Pipeline {

    @Autowired
    private ZxjgDao zxjgDao;

    @Autowired
    private JcxmjgDao jcxmjgDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return zxjgDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Zxjg zxjg) {
        return zxjgDao.insert(zxjg);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int plInser(List<Zxjg> zxjgs) throws Exception {
        int k = 0;
        for (int i = 0; i < zxjgs.size(); i++) {
            k+=zxjgDao.deleteByZxjg(zxjgs.get(i).getQybh(),zxjgs.get(i).getJcdbh(),zxjgs.get(i).getSj());
            k+=zxjgDao.insert(zxjgs.get(i));
            List<Jcxmjg> jcxmjgs = zxjgs.get(i).getJcxmjgs();
            for (int j = 0; j < jcxmjgs.size(); j++) {
                jcxmjgs.get(j).setZxjgId(zxjgs.get(i).getZxjgId());
                k+=jcxmjgDao.insert(jcxmjgs.get(j));
            }
        }
        return k;
    }


    @Override
    public Zxjg selectByPrimaryKey(Long primaryKey) {
        return zxjgDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Zxjg zxjg) {
        return zxjgDao.updateByPrimaryKey(zxjg);
    }

    @Override
    public List<Zxjg> list(String searchText) {
        return zxjgDao.list(searchText, null, null, null, null);
    }

    @Override
    public PageInfo<Zxjg> list(int pageNum, int pageSize, String searchText, String qybh, String jcdid, String startDate, String endDate) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Zxjg> zxjgs = zxjgDao.list(searchText,qybh,jcdid,startDate,endDate);
        PageInfo<Zxjg> pageInfo = new PageInfo<Zxjg>(zxjgs);
        return pageInfo;
    }


    @Override
    public void process(ResultItems resultItems, Task task) {
        Zxjg zxjg =  resultItems.get("result");
        insert(zxjg);
    }
}