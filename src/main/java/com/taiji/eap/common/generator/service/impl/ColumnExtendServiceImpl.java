
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

@Service
public class ColumnExtendServiceImpl implements ColumnExtendService{

    @Autowired
    private ColumnExtendDao columnExtendDao;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long primaryKey) {
        return columnExtendDao.deleteByPrimaryKey(primaryKey);
    }

    @Transactional
    @Override
    public int insert(ColumnExtend columnExtend) {
        return columnExtendDao.insert(columnExtend);
    }

    @Override
    public ColumnExtend selectByPrimaryKey(Long primaryKey) {
        return columnExtendDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional
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

    @Transactional
    @Override
    public int initColumnExtend(List<Column> columns, String schema, String table) {
        int k = columnExtendDao.deleteByTable(schema,table);
        for (Column column: columns) {
            ColumnExtend columnExtend = new ColumnExtend(schema,table,column.getColumnName());
            k+=columnExtendDao.insert(columnExtend);
        }
        return k;
    }

    @Override
    public PageInfo<ColumnExtend> listByTable(String schema, String table,String searchText) {
        List<ColumnExtend> columnExtends = columnExtendDao.listByTable(schema,table,searchText);
        PageInfo<ColumnExtend> pageInfo = new PageInfo<ColumnExtend>(columnExtends);
        return pageInfo;
    }

}