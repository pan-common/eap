package com.taiji.eap.common.generator.dao;

import java.util.List;

import com.taiji.eap.common.generator.bean.Column;
import org.apache.ibatis.annotations.Param;

public interface GeneratorDao {

	/**
	 * 查询表总全部列
	 * @param schema
	 * @param table
	 * @return
	 */
	public List<Column> selectColums(@Param("schema")String schema,@Param("table")String table);
}
