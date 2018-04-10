package com.taiji.eap.common.dictionary.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.dictionary.dao.DictionaryDao;
import com.taiji.eap.common.dictionary.service.DictionaryService;
import com.taiji.eap.common.redis.dao.impl.RedisFactoryDao;
import com.taiji.eap.common.redis.dao.impl.StringRedisFactoryDao;
import com.taiji.eap.common.shiro.bean.SysResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    private DictionaryDao dictionaryDao;

    @Autowired
    private RedisFactoryDao<Dictionary> redisFactoryDao;

    @Autowired
    private StringRedisFactoryDao stringRedisFactoryDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        redisFactoryDao.deleteByPattern("allDictionary");
        return dictionaryDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Dictionary dictionary) {
        redisFactoryDao.deleteByPattern("allDictionary");
        return dictionaryDao.insert(dictionary);
    }

    @Override
    public int insertMissParam(Dictionary dictionary) throws Exception {
        redisFactoryDao.deleteByPattern("allDictionary");
        Dictionary dic =  dictionaryDao.queryFirst(dictionary.getParentId());
        if(dic!=null) {
            //开始时间
            String startDate = dictionary.getParam1();
            //结束时间
            String endDate = dictionary.getParam2();
            //上期结束时间
            String lastEndDate = dic.getParam2();
            if (lastEndDate.compareTo(startDate) >= 0) {
                throw new Exception("本期开始时间在上期结束时间之前，请确认");
            } else {
                if (startDate.compareTo(endDate) >= 0) {
                    throw new Exception("结束时间在开始时间之前，请确认");
                }
            }
            dictionary.setSeq(dic.getSeq()+1);
            dictionary.setKeystone(String.valueOf(Integer.valueOf(dic.getKeystone())+1));
        }else {
            dictionary.setSeq(1);
            dictionary.setKeystone("1");
        }

        return dictionaryDao.insert(dictionary);
    }

    @Override
    public Dictionary selectByPrimaryKey(Long primaryKey) {
        return dictionaryDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(Dictionary dictionary) {
        int k = dictionaryDao.updateByPrimaryKey(dictionary);
        redisFactoryDao.deleteByPattern("dictionary:"+dictionary.getParentId());
        redisFactoryDao.deleteByPattern("allDictionary");
        return k;
    }

    @Override
    public List<Dictionary> list(String searchText) {
        return dictionaryDao.list(searchText);
    }

    @Override
    public PageInfo<Dictionary> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Dictionary> dictionaries = dictionaryDao.listByPid(parentId,searchText);
        PageInfo<Dictionary> pageInfo = new PageInfo<Dictionary>(dictionaries);
        return pageInfo;
    }

    @Override
    public List<Dictionary> listByPid(Long parentId) throws Exception {
        List<Dictionary> dictionaries =redisFactoryDao.getDatas("dictionary", String.valueOf(parentId), new RedisFactoryDao.OnRedisSelectListener() {
            @Override
            public List fruitless() {
                return dictionaryDao.listByPid(parentId,"");
            }
        });
        return dictionaries;
    }

    @Override
    public List<Dictionary> getPath(Long dicId) throws Exception {
        List<Dictionary> list = new ArrayList<Dictionary>();
        if(dicId!=0){
            disPlay(dicId, list);
        }
        list.add(new Dictionary(0L,"数据字典"));
        Collections.reverse(list);
        return list;
    }

    @Override
    public String getValueByKey(String keystone, Long parentId) throws Exception {
        String value = stringRedisFactoryDao.getValue("dictionary", String.valueOf(parentId)+":"+ keystone ,
                new StringRedisFactoryDao.OnRedisSelectListener() {
                    @Override
                    public String fruitless() {
                        return dictionaryDao.getValueByKey(keystone,parentId);
                    }
                });
        return value;
    }

    @Override
    public Dictionary getDictionaryByKey(String keystone, Long parentId) {
        return dictionaryDao.getDictionaryByKey(keystone,parentId);
    }

    @Override
    public List<Dictionary> selectAll() throws Exception {
        List<Dictionary> dictionaries = redisFactoryDao.getDatas("allDictionary", "", new RedisFactoryDao.OnRedisSelectListener() {
            @Override
            public List fruitless() {
                return dictionaryDao.selectAll();
            }
        });
        return dictionaries;
    }

    private void disPlay(Long dicId,List<Dictionary> list){
        Dictionary dictionary = dictionaryDao.selectByPrimaryKey(dicId);
        if(dictionary!=null){
            list.add(dictionary);
            disPlay(dictionary.getParentId(), list);
        }
    }

}
