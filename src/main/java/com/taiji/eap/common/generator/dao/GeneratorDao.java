package com.taiji.eap.common.generator.dao;

import java.util.List;

import com.taiji.eap.common.generator.bean.Table;

public interface GeneratorDao {

	public List<Table> selectTables();
	
}
