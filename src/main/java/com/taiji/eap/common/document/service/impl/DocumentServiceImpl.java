package com.taiji.eap.common.document.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.document.bean.Document;
import com.taiji.eap.common.document.dao.DocumentDao;
import com.taiji.eap.common.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentDao documentDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        int k = 0;
        k+=documentDao.deleteByPrimaryKey(primaryKey);
        recursiveDelete(primaryKey);
        return k;
    }

    @Transactional
    @Override
    public int insert(Document document) {
        return documentDao.insert(document);
    }

    @Transactional
    @Override
    public int insertSelective(Document document) throws Exception {
        return documentDao.insertSelective(document);
    }

    @Override
    public Document selectByPrimaryKey(Long primaryKey) {
        return documentDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Document document) {
        return documentDao.updateByPrimaryKey(document);
    }

    @Transactional
    @Override
    public int updateSelectiveByPrimaryKey(Document document) throws Exception {
        return documentDao.updateSelectiveByPrimaryKey(document);
    }

    @Override
    public List<Document> list(String searchText) {
        return documentDao.list(searchText);
    }

    @Override
    public PageInfo<Document> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Document> documents = documentDao.list(searchText);
        PageInfo<Document> pageInfo = new PageInfo<Document>(documents);
        return pageInfo;
    }

    @Override
    public List<Document> listByPid(Long parentId) throws Exception {
        return documentDao.listByPid(parentId,"");
    }

    @Override
    public PageInfo<Document> listByPid(Long parentId, int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Document> list = documentDao.listByPid(parentId,searchText);
        PageInfo<Document> pageInfo = new PageInfo<Document>(list);
        return pageInfo;
    }

    @Override
    public List<Document> getPath(Long documentId) throws Exception {
        List<Document> list = new ArrayList<Document>();
        if(documentId!=0){
            disPlay(documentId, list);
        }
        list.add(new Document(0L,"根路径"));
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<BaseTree> treeView(Long parentId) throws Exception {
        List<Document> list = documentDao.selectAll();
        List<BaseTree> trees = new ArrayList<BaseTree>();
        for (Document tree: list) {
            if(parentId==tree.getParentId()){
                trees.add(findChildren(tree,list));
            }
        }
        return trees;
    }

    private Document findChildren(Document tree,List<Document> list){
        for (Document document:list) {
            document.setName(document.getDocumentTitle());
            document.setSpread(true);
            if(tree.getDocumentId()==document.getParentId()){
                tree.getChildren().add(findChildren(document,list));
            }
        }
        return tree;
    }

    private void disPlay(Long documentId,List<Document> list){
        Document document = documentDao.selectByPrimaryKey(documentId);
        if(document!=null){
            list.add(document);
            disPlay(document.getParentId(), list);
        }
    }

    /**
    * 递归删除
    * @param parentId
    */
    private void recursiveDelete(Long parentId){
        List<Document> documents =documentDao.listByPid(parentId,"");
        if(documents!=null&&!documents.isEmpty()){
            for (Document document: documents) {
                documentDao.deleteByPrimaryKey(document.getDocumentId());
                recursiveDelete(document.getDocumentId());
            }
        }
    }
}