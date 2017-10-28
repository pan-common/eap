package com.taiji.eap.biz.qyjcxx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.qyjcxx.bean.Jcdw;
import com.taiji.eap.biz.qyjcxx.bean.Jcyz;
import com.taiji.eap.biz.qyjcxx.bean.ZfjcJcqk;
import com.taiji.eap.common.generator.bean.EasyUISubmitData;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.biz.qyjcxx.bean.Qyjcxx;
import com.taiji.eap.biz.qyjcxx.dao.QyjcxxDao;
import com.taiji.eap.biz.qyjcxx.service.QyjcxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class QyjcxxServiceImpl implements QyjcxxService{

    @Autowired
    private QyjcxxDao qyjcxxDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return qyjcxxDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Qyjcxx qyjcxx) {
        return qyjcxxDao.insert(qyjcxx);
    }

    @Override
    public Qyjcxx selectByPrimaryKey(Long primaryKey) {
        return qyjcxxDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Qyjcxx qyjcxx) {
        return qyjcxxDao.updateByPrimaryKey(qyjcxx);
    }

    @Override
    public List<Qyjcxx> list(String searchText) {
        return qyjcxxDao.list(searchText);
    }

    @Override
    public List<Map<String, String>> listMap(String searchText) {
        return qyjcxxDao.listMap(searchText);
    }

    @Override
    public PageInfo<Qyjcxx> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Qyjcxx> qyjcxxs = qyjcxxDao.list(searchText);
        PageInfo<Qyjcxx> pageInfo = new PageInfo<Qyjcxx>(qyjcxxs);
        return pageInfo;
    }

    @Override
    public int easyuiSubmitData(EasyUISubmitData<Qyjcxx> easyUISubmitData) {
        List<Qyjcxx> inserted = easyUISubmitData.getInserted();
        List<Qyjcxx> updated = easyUISubmitData.getUpdated();
        List<Qyjcxx> deleted = easyUISubmitData.getDeleted();
        int k = 0;
        if(inserted!=null&&!inserted.isEmpty()) {
            for (int i = 0; i < inserted.size(); i++) {
                k += qyjcxxDao.insert(inserted.get(i));
            }
        }
        if(deleted!=null&&!deleted.isEmpty()) {
            for (int i = 0; i < deleted.size(); i++) {
                k += qyjcxxDao.deleteByPrimaryKey(deleted.get(i).getId());
            }
        }
        if(updated!=null&&!updated.isEmpty()) {
            for (int i = 0; i < updated.size(); i++) {
                k += qyjcxxDao.updateByPrimaryKey(updated.get(i));
            }
        }
        return k;
    }

    @Override
    public List<Qyjcxx> listByPid(Long parentId) throws Exception {
        return qyjcxxDao.listByPid(parentId,"");
    }

    @Override
    public PageInfo<Qyjcxx> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Qyjcxx> list = qyjcxxDao.listByPid(parentId,searchText);
        PageInfo<Qyjcxx> pageInfo = new PageInfo<Qyjcxx>(list);
        return pageInfo;
    }

    @Override
    public List<Qyjcxx> getPath(Long id) throws Exception {
        List<Qyjcxx> list = new ArrayList<Qyjcxx>();
        if(id!=0){
            disPlay(id, list);
        }
        list.add(new Qyjcxx(0L,"根路径"));
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<LayuiTree> treeView(Long parentId) throws Exception {
        List<Qyjcxx> list = qyjcxxDao.selectAll();
        List<LayuiTree> trees = new ArrayList<LayuiTree>();
        for (Qyjcxx tree: list) {
            if(parentId==tree.getParentId()){
                trees.add(findChildren(tree,list));
            }
        }
        return trees;
    }

    @Override
    public int saveZfjcqk(ZfjcJcqk zfjcJcqk) {
        return qyjcxxDao.saveZfjcqk(zfjcJcqk);
    }

    @Override
    public int saveJcdw(Jcdw jcdw) {
        return qyjcxxDao.saveJcdw(jcdw);
    }

    @Override
    public int saveJcyz(Jcyz jcyz) {
        return qyjcxxDao.saveJcyz(jcyz);
    }

    @Transactional
    @Override
    public int saveZfjcqks(List<ZfjcJcqk> zfjcJcqks) {
        int a = 0;
        for (int i = 0; i < zfjcJcqks.size(); i++) {
            a+=qyjcxxDao.saveZfjcqk(zfjcJcqks.get(i));
            List<Jcdw> jcdws = zfjcJcqks.get(i).getJcdws();
            for (int j = 0; j < jcdws.size(); j++) {
                a+=qyjcxxDao.saveJcdw(jcdws.get(j));
                List<Jcyz> jcyzs = jcdws.get(j).getJcyzs();
                for (int k = 0; k < jcyzs.size(); k++) {
                    a+=qyjcxxDao.saveJcyz(jcyzs.get(k));
                }
            }
        }
        return a;
    }

    @Override
    public String getNameByCode(String code) {
        return qyjcxxDao.getNameByCode(code);
    }

    @Override
    public String getCodeByName(String name) {
        return qyjcxxDao.getCodeByName(name);
    }

    private Qyjcxx findChildren(Qyjcxx tree,List<Qyjcxx> list){
        for (Qyjcxx qyjcxx:list) {
            qyjcxx.setName(qyjcxx.getName());
            qyjcxx.setSpread(true);
            if(tree.getId()==qyjcxx.getParentId()){
                tree.getChildren().add(findChildren(qyjcxx,list));
            }
        }
        return tree;
    }

    private void disPlay(Long id,List<Qyjcxx> list){
    Qyjcxx qyjcxx = qyjcxxDao.selectByPrimaryKey(id);
        if(qyjcxx!=null){
            list.add(qyjcxx);
            disPlay(qyjcxx.getParentId(), list);
        }
    }
}