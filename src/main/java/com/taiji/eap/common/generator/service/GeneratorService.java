package com.taiji.eap.common.generator.service;

import com.taiji.eap.common.generator.bean.Column;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.generator.bean.Param;
import com.taiji.eap.common.datasource.bean.Table;

import java.util.List;

public interface GeneratorService {

   public List<Table> selectTables(String schema);

   public List<Column> selectColums(String schema,String table);

   public void execute(Param param) throws Exception;

   List<LayuiTree> projectTreeView(String path) throws Exception;

    List<LayuiTree> jspTreeView(String path) throws Exception;

    List<Table> selectViews(String databaseName);
}
