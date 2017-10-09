package com.taiji.eap.common.generator.dao;

import java.util.List;

import com.taiji.eap.common.generator.bean.Column;
import com.taiji.eap.common.generator.bean.Table;
import org.apache.ibatis.annotations.Param;

public interface GeneratorDao {
	/**
	 * 查询数据库下表
	 * @param schema
	 * @return
	 */
	public List<Table> selectTables(@Param("schema") String schema);

	/**
	 * 查询数据库下全部视图
	 * @param schema
	 * @return
	 */
	public List<Table> selectViews(@Param("schema") String schema);

	/**
	 * 查询表总全部列
	 * @param schema
	 * @param table
	 * @return
	 */
	public List<Column> selectColums(@Param("schema")String schema,@Param("table")String table);
}
