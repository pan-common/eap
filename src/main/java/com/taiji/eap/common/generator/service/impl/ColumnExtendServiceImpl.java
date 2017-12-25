
package com.taiji.eap.common.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.Column;
import com.taiji.eap.common.generator.bean.ColumnExtend;
import com.taiji.eap.common.generator.dao.ColumnExtendDao;
import com.taiji.eap.common.generator.service.ColumnExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * @author 潘宏智  
 * @date 2017-12-18 14:11
 */  
@Service
public class ColumnExtendServiceImpl implements ColumnExtendService{

    @Autowired
    private ColumnExtendDao columnExtendDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return columnExtendDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(ColumnExtend columnExtend) {
        return columnExtendDao.insert(columnExtend);
    }

    @Override
    public ColumnExtend selectByPrimaryKey(Long primaryKey) {
        return columnExtendDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(ColumnExtend columnExtend) {
        return columnExtendDao.updateByPrimaryKey(columnExtend);
    }

    @Override
    public List<ColumnExtend> list(String searchText) {
        return columnExtendDao.list(searchText);
    }

    @Override
    public PageInfo<ColumnExtend> list(int pageNum, int pageSize, String searchText) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<ColumnExtend> columnExtends = columnExtendDao.list(searchText);
        PageInfo<ColumnExtend> pageInfo = new PageInfo<ColumnExtend>(columnExtends);
        return pageInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int initColumnExtend(List<Column> columns, String schema, String table) {
        int k = columnExtendDao.deleteByTable(schema,table);
        for (Column column: columns) {
            ColumnExtend columnExtend = new ColumnExtend(schema,table,column.getColumnName());
            columnExtend.setSeq(Integer.valueOf(column.getOrdinalPosition()));
            //表单显示
            columnExtend.setFormShow("01");
            //列表显示
            columnExtend.setListShow("01");
            //宽度
            columnExtend.setWidthPer("100");
            //输入框
            columnExtend.setInputType("01");
            //不查询
            columnExtend.setIsQuery("02");
            //不必填
            columnExtend.setRequired("01");
            k+=columnExtendDao.insert(columnExtend);
        }
        return k;
    }

    @Override
    public List<ColumnExtend> listByTable(String schema, String table) {
        List<ColumnExtend> columnExtends = columnExtendDao.listByTable(schema,table,null);
        return columnExtends;
    }

    @Override
    public PageInfo<ColumnExtend> listByTable(String schema, String table,String searchText) {
        List<ColumnExtend> columnExtends = columnExtendDao.listByTable(schema,table,searchText);
        PageInfo<ColumnExtend> pageInfo = new PageInfo<ColumnExtend>(columnExtends);
        return pageInfo;
    }

    @Override
    public PageInfo<ColumnExtend> listFormByTable(String schema, String table, String searchText) throws Exception {
        List<ColumnExtend> columnExtends = columnExtendDao.listFormByTable(schema,table,searchText);
        PageInfo<ColumnExtend> pageInfo = new PageInfo<ColumnExtend>(columnExtends);
        return pageInfo;
    }

}