
package com.taiji.eap.common.generator.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.generator.bean.Column;
import org.apache.ibatis.annotations.Param;
import com.taiji.eap.common.generator.bean.ColumnExtend;
import java.util.List;

public interface ColumnExtendService{

    int deleteByPrimaryKey(Long primaryKey) throws Exception;

    int insert(ColumnExtend columnExtend) throws Exception;

    ColumnExtend selectByPrimaryKey(Long primaryKey) throws Exception;

    int updateByPrimaryKey(ColumnExtend columnExtend) throws Exception;

    List<ColumnExtend> list(String searchText) throws Exception;

    PageInfo<ColumnExtend> list(int pageNum, int pageSize, String searchText) throws Exception;

    int initColumnExtend(List<Column> columns, String schema, String table);

    List<ColumnExtend> listByTable(String schema, String table);

    PageInfo<ColumnExtend> listByTable(String schema, String table,String searchText);

    PageInfo<ColumnExtend> listFormByTable(String schema, String table, String searchText) throws Exception;
}