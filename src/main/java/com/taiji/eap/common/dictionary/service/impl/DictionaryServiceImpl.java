package com.taiji.eap.common.dictionary.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.dictionary.bean.Dictionary;
import com.taiji.eap.common.dictionary.dao.DictionaryDao;
import com.taiji.eap.common.dictionary.service.DictionaryService;
import com.taiji.eap.common.shiro.bean.SysResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    private DictionaryDao dictionaryDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return dictionaryDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(Dictionary dictionary) {
        return dictionaryDao.insert(dictionary);
    }

    @Override
    public Dictionary selectByPrimaryKey(Long primaryKey) {
        return dictionaryDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Dictionary dictionary) {
        return dictionaryDao.updateByPrimaryKey(dictionary);
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
    public List<Dictionary> listByPid(Long parentId) {
        return dictionaryDao.listByPid(parentId,"");
    }

    @Override
    public List<Dictionary> getPath(Long dicId) throws Exception {
        List<Dictionary> list = new ArrayList<Dictionary>();
        list.add(new Dictionary(0L,"数据字典"));
        if(dicId!=0){
            disPlay(dicId, list);
        }
        return list;
    }

    private void disPlay(Long dicId,List<Dictionary> list){
        Dictionary dictionary = dictionaryDao.selectByPrimaryKey(dicId);
        if(dictionary!=null){
            list.add(list.size(), dictionary);
            disPlay(dictionary.getParentId(), list);
        }
    }

}
