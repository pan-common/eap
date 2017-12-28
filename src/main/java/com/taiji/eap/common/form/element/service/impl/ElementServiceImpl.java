package com.taiji.eap.common.form.element.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.form.element.bean.Element;
import com.taiji.eap.common.form.element.dao.ElementDao;
import com.taiji.eap.common.form.element.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ElementServiceImpl implements ElementService{

    @Autowired
    private ElementDao elementDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        int k = 0;
        k+=elementDao.deleteByPrimaryKey(primaryKey);
        recursiveDelete(primaryKey);
        return k;
    }

    @Transactional
    @Override
    public int insert(Element element) {
        return elementDao.insert(element);
    }

    @Override
    public Element selectByPrimaryKey(Long primaryKey) {
        return elementDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Element element) {
        return elementDao.updateByPrimaryKey(element);
    }

    @Override
    public List<Element> list(String searchText) {
        return elementDao.list(searchText);
    }

    @Override
    public PageInfo<Element> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Element> elements = elementDao.list(searchText);
        PageInfo<Element> pageInfo = new PageInfo<Element>(elements);
        return pageInfo;
    }

    @Override
    public List<Element> listByPid(Long parentId) throws Exception {
        return elementDao.listByPid(parentId,"");
    }

    @Override
    public PageInfo<Element> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Element> list = elementDao.listByPid(parentId,searchText);
        PageInfo<Element> pageInfo = new PageInfo<Element>(list);
        return pageInfo;
    }

    @Override
    public List<Element> getPath(Long elementId) throws Exception {
        List<Element> list = new ArrayList<Element>();
        if(elementId!=0){
            disPlay(elementId, list);
        }
        list.add(new Element(0L,"根路径"));
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<BaseTree> treeView(Long parentId) throws Exception {
        List<Element> list = elementDao.selectAll();
        List<BaseTree> trees = new ArrayList<BaseTree>();
        for (Element tree: list) {
            if(parentId==tree.getParentId()){
                trees.add(findChildren(tree,list));
            }
        }
        return trees;
    }

    private Element findChildren(Element tree,List<Element> list){
        for (Element element:list) {
            element.setName(element.getElementName());
            element.setSpread(true);
            if(tree.getElementId()==element.getParentId()){
                tree.getChildren().add(findChildren(element,list));
            }
        }
        return tree;
    }

    private void disPlay(Long elementId,List<Element> list){
        Element element = elementDao.selectByPrimaryKey(elementId);
        if(element!=null){
            list.add(element);
            disPlay(element.getParentId(), list);
        }
    }

    /**
    * 递归删除
    * @param parentId
    */
    private void recursiveDelete(Long parentId){
        List<Element> elements =elementDao.listByPid(parentId,"");
        if(elements!=null&&!elements.isEmpty()){
            for (Element element: elements) {
                elementDao.deleteByPrimaryKey(element.getElementId());
                recursiveDelete(element.getElementId());
            }
        }
    }
}