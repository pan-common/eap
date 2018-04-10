package com.taiji.eap.wsm.water.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseServiceImpl;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.utils.UUIDUtils;
import com.taiji.eap.wsm.water.bean.ConfigTree;
import com.taiji.eap.wsm.water.dao.ConfigTreeDao;
import com.taiji.eap.wsm.water.service.ConfigTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ConfigTreeServiceImpl extends BaseServiceImpl implements ConfigTreeService{

    @Autowired
    private ConfigTreeDao ConfigTreeDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(String primaryKey) {
        int k = 0;
        k+=ConfigTreeDao.deleteByPrimaryKey(primaryKey);
        recursiveDelete(primaryKey);
        return k;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(ConfigTree ConfigTree) {
        ConfigTree.setId(UUIDUtils.getGUID());
        return ConfigTreeDao.insert(ConfigTree);
    }

    @Override
    public ConfigTree selectByPrimaryKey(String primaryKey) {
        return ConfigTreeDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(ConfigTree ConfigTree) {
        return ConfigTreeDao.updateByPrimaryKey(ConfigTree);
    }

    @Override
    public List<ConfigTree> list(String searchText) {
        return ConfigTreeDao.list(searchText);
    }

    @Override
    public List<ConfigTree> selectAll() throws Exception {
        return ConfigTreeDao.selectAll();
    }

    @Override
    public PageInfo<ConfigTree> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<ConfigTree> ConfigTrees = ConfigTreeDao.list(searchText);
        PageInfo<ConfigTree> pageInfo = new PageInfo<ConfigTree>(ConfigTrees);
        return pageInfo;
    }

    @Override
    public List<ConfigTree> listByPid(String parentId) throws Exception {
        return ConfigTreeDao.listByPid(parentId,"");
    }

    @Override
    public PageInfo<ConfigTree> listByPid(String parentId, int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<ConfigTree> list = ConfigTreeDao.listByPid(parentId,searchText);
        PageInfo<ConfigTree> pageInfo = new PageInfo<ConfigTree>(list);
        return pageInfo;
    }

    @Override
    public List<ConfigTree> getPath(String id) throws Exception {
        List<ConfigTree> list = new ArrayList<ConfigTree>();
        if(!id.equals(0)){
            disPlay(id, list);
        }
        list.add(new ConfigTree("0","根路径"));
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<BaseTree> treeView(String parentId) throws Exception {
        List<ConfigTree> list = ConfigTreeDao.selectAll();
        List<BaseTree> trees = new ArrayList<BaseTree>();
        for (ConfigTree tree: list) {
            if(parentId==tree.getParentId()){
                trees.add(findChildren(tree,list));
            }
        }
        return trees;
    }

    private ConfigTree findChildren(ConfigTree tree,List<ConfigTree> list){
        for (ConfigTree ConfigTree:list) {
            ConfigTree.setName(ConfigTree.getTitle());
            ConfigTree.setSpread(true);
            if(tree.getId()==ConfigTree.getParentId()){
                tree.getChildren().add(findChildren(ConfigTree,list));
            }
        }
        return tree;
    }

    private void disPlay(String id,List<ConfigTree> list){
        ConfigTree ConfigTree = ConfigTreeDao.selectByPrimaryKey(id);
        if(ConfigTree!=null){
            list.add(ConfigTree);
            disPlay(ConfigTree.getParentId(), list);
        }
    }

    /**
    * 递归删除
    * @param parentId
    */
    private void recursiveDelete(String parentId){
        List<ConfigTree> ConfigTrees =ConfigTreeDao.listByPid(parentId,"");
        if(ConfigTrees!=null&&!ConfigTrees.isEmpty()){
            for (ConfigTree ConfigTree: ConfigTrees) {
                ConfigTreeDao.deleteByPrimaryKey(ConfigTree.getId());
                recursiveDelete(ConfigTree.getId());
            }
        }
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(ConfigTree ConfigTree) {
        return ConfigTreeDao.insertSelective(ConfigTree);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(ConfigTree ConfigTree) {
        return ConfigTreeDao.updateByPrimaryKeySelective(ConfigTree);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<ConfigTree> queryAll(ConfigTree ConfigTree) {
        return ConfigTreeDao.queryAll(ConfigTree);
    }
}