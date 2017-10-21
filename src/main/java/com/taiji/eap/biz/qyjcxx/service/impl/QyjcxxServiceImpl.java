package com.taiji.eap.biz.qyjcxx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.biz.qyjcxx.bean.Qyjcxx;
import com.taiji.eap.biz.qyjcxx.dao.QyjcxxDao;
import com.taiji.eap.biz.qyjcxx.service.QyjcxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public PageInfo<Qyjcxx> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Qyjcxx> qyjcxxs = qyjcxxDao.list(searchText);
        PageInfo<Qyjcxx> pageInfo = new PageInfo<Qyjcxx>(qyjcxxs);
        return pageInfo;
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

    private Qyjcxx findChildren(Qyjcxx tree,List<Qyjcxx> list){
        for (Qyjcxx qyjcxx:list) {
            qyjcxx.setName(qyjcxx.getQymc());
            qyjcxx.setText(qyjcxx.getQymc());
            qyjcxx.setSpread(true);
            qyjcxx.setIconCls("icon-tip");
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