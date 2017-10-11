
package com.taiji.eap.common.generator.dao;

import com.taiji.eap.common.generator.bean.ColumnExtend;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ColumnExtendDao {

    int deleteByPrimaryKey(Long primaryKey);

    int insert(ColumnExtend columnExtend);

    ColumnExtend selectByPrimaryKey(Long primaryKey);

    int updateByPrimaryKey(ColumnExtend columnExtend);

    List<ColumnExtend> list(@Param("searchText") String searchText);

    int deleteByTable(@Param("schema") String schema,@Param("table") String table);

    List<ColumnExtend> listByTable(@Param("schema")String schema, @Param("tableName")String table, @Param("searchText")String searchText);
}