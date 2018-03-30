package com.taiji.eap.common.redis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.datasource.annotation.DataSource;
import com.taiji.eap.common.redis.bean.RedisKey;
import com.taiji.eap.common.redis.dao.RedisKeyDao;
import com.taiji.eap.common.redis.dao.impl.RedisFactoryDao;
import com.taiji.eap.common.redis.service.RedisKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class RedisKeyServiceImpl implements RedisKeyService{

    private static final String REDIS_KEY = "redis:keynames";

    @Autowired
    private RedisKeyDao redisKeyDao;

    @Autowired
    private RedisFactoryDao<String> redisFactoryDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        int k = 0;
        k+=redisKeyDao.deleteByPrimaryKey(primaryKey);
        recursiveDelete(primaryKey);
        redisFactoryDao.delete(REDIS_KEY);
        return k;
    }

    @Transactional
    @Override
    public int insert(RedisKey redisKey) {
        redisFactoryDao.delete(REDIS_KEY);
        return redisKeyDao.insert(redisKey);
    }

    @Override
    public RedisKey selectByPrimaryKey(Long primaryKey) {
        return redisKeyDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(RedisKey redisKey) {
        redisFactoryDao.delete(REDIS_KEY);
        return redisKeyDao.updateByPrimaryKey(redisKey);
    }

    @Override
    public List<RedisKey> list(String searchText) {
        return redisKeyDao.list(searchText);
    }

    @Override
    public PageInfo<RedisKey> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<RedisKey> redisKeys = redisKeyDao.list(searchText);
        PageInfo<RedisKey> pageInfo = new PageInfo<RedisKey>(redisKeys);
        return pageInfo;
    }

    @Override
    public List<RedisKey> listByPid(Long parentId) throws Exception {
        return redisKeyDao.listByPid(parentId,"");
    }

    @Override
    public PageInfo<RedisKey> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<RedisKey> list = redisKeyDao.listByPid(parentId,searchText);

        for (RedisKey redisKey: list) {
            if(!redisKey.getKeyType().equals("02")){
                redisKey.setDataSize(String.valueOf(redisFactoryDao.size(redisKey.getKeyValue())));
            }
        }

        PageInfo<RedisKey> pageInfo = new PageInfo<RedisKey>(list);
        return pageInfo;
    }

    @Override
    public List<RedisKey> getPath(Long keyId) throws Exception {
        List<RedisKey> list = new ArrayList<RedisKey>();
        if(keyId!=0){
            disPlay(keyId, list);
        }
        list.add(new RedisKey(0L,"根路径"));
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<BaseTree> treeView(Long parentId) throws Exception {
        List<RedisKey> list = redisKeyDao.selectAll();
        List<BaseTree> trees = new ArrayList<BaseTree>();
        for (RedisKey tree: list) {
            if(Objects.equals(parentId, tree.getParentId())){
                trees.add(findChildren(tree,list));
            }
        }
        return trees;
    }

    @Override
    public List<String> getAllKeys() throws Exception{
        List<String> keys = redisFactoryDao.getDatas(REDIS_KEY,"", new RedisFactoryDao.OnRedisSelectListener() {
            @Override
            public List fruitless() {
                List<RedisKey> redisKeys = redisKeyDao.getAllRedisKey();
                List<String> keys = new ArrayList<>();
                for (int i = 0; i < redisKeys.size(); i++) {
                    keys.add(displayKeyName(redisKeys.get(i).getKeyId()));
                }
                return keys;
            }
        });
        return keys;
    }

    private String displayKeyName(Long keyId){
        List<RedisKey> redisKeys = new ArrayList<>();
        disPlay(keyId,redisKeys);
        Collections.reverse(redisKeys);
        String key = "";
        for (int i = 0; i < redisKeys.size(); i++) {
            if(i==0) {
               key+=redisKeys.get(i).getKeyValue();
            }else {
                key += ":" + redisKeys.get(i).getKeyValue();
            }
        }
        return key;
    }

    private RedisKey findChildren(RedisKey tree,List<RedisKey> list){
        for (RedisKey redisKey:list) {
            redisKey.setName(redisKey.getKeyName());
            redisKey.setSpread(true);
            if(tree.getKeyId()==redisKey.getParentId()){
                tree.getChildren().add(findChildren(redisKey,list));
            }
        }
        return tree;
    }

    private void disPlay(Long keyId,List<RedisKey> list){
        RedisKey redisKey = redisKeyDao.selectByPrimaryKey(keyId);
        if(redisKey!=null){
            list.add(redisKey);
            disPlay(redisKey.getParentId(), list);
        }
    }

    /**
    * 递归删除
    * @param parentId
    */
    private void recursiveDelete(Long parentId){
        List<RedisKey> redisKeys =redisKeyDao.listByPid(parentId,"");
        if(redisKeys!=null&&!redisKeys.isEmpty()){
            for (RedisKey redisKey: redisKeys) {
                redisKeyDao.deleteByPrimaryKey(redisKey.getKeyId());
                recursiveDelete(redisKey.getKeyId());
            }
        }
    }
}