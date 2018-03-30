package com.taiji.eap.common.generator.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.datasource.bean.DataSource;
import com.taiji.eap.common.datasource.bean.Table;
import com.taiji.eap.common.datasource.service.DataSourceService;
import com.taiji.eap.common.generator.bean.*;
import com.taiji.eap.common.generator.service.ColumnExtendService;
import com.taiji.eap.common.generator.service.GeneratorService;
import com.taiji.eap.common.http.entity.Response;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/generator")
public class GeneratorController extends BaseController{

	@Autowired
	GeneratorService generatorService;

	@Autowired
	DataSourceService dataSourceService;

	@Autowired
	ColumnExtendService columnExtendService;

	@GetMapping(value = "getTables")
	@ResponseBody
	public Response<List<BaseTree>> getTables(){
		BaseTree connect = new Connect();
		connect.setName("默认数据库连接");
		connect.setSpread(true);
		connect.setType(BaseTree.CONNECT);
		List<BaseTree> baseTrees = new ArrayList<BaseTree>();
		baseTrees.add(connect);
		for (int i = 0; i < baseTrees.size(); i++) {
			List<BaseTree> dataSources = dataSourceService.getDataSourceTree();
			baseTrees.get(i).addChildrens(dataSources);
			for (int j = 0; j < dataSources.size(); j++) {
				BaseTree tableTree = new TableType();
				tableTree.setType(BaseTree.OTHER);
				tableTree.setSpread(true);
				tableTree.setName("表");
				List<Table> tables = generatorService.selectTables(((DataSource)dataSources.get(i)).getConnectName());
				for (int k = 0; k < tables.size() ; k++) {
					tables.get(k).setName(tables.get(k).gettName());
					tables.get(k).setSpread(true);
					tables.get(k).setType(BaseTree.TABLE);
					tables.get(k).setDriverClass(((DataSource)dataSources.get(i)).getDriverClassName());
					tables.get(k).setConnectionURL(((DataSource)dataSources.get(i)).getUrl());
					tables.get(k).setUserId(((DataSource)dataSources.get(i)).getUsername());
					tables.get(k).setPassword(((DataSource)dataSources.get(i)).getPassword());
					tableTree.addChildren(tables.get(k));
				}
				dataSources.get(j).addChildren(tableTree);
				BaseTree viewTree = new TableType();
				viewTree.setType(BaseTree.OTHER);
				viewTree.setSpread(true);
				viewTree.setName("视图");
				List<Table> views = generatorService.selectViews(((DataSource)dataSources.get(i)).getConnectName());
				for (int k = 0; k <views.size() ; k++) {
					views.get(k).setName(views.get(k).gettName());
					views.get(k).setSpread(true);
					views.get(k).setType(BaseTree.TABLE);
					views.get(k).setDriverClass(((DataSource)dataSources.get(i)).getDriverClassName());
					views.get(k).setConnectionURL(((DataSource)dataSources.get(i)).getUrl());
					views.get(k).setUserId(((DataSource)dataSources.get(i)).getUsername());
					views.get(k).setPassword(((DataSource)dataSources.get(i)).getPassword());
					viewTree.addChildren(views.get(k));
				}
				dataSources.get(j).addChildren(viewTree);
			}
		}
		return renderSuccess(baseTrees);
	}

	@GetMapping(value = "getColumns")
	@ResponseBody
	public PageInfo<Column> getColumns(String schema, String table){
		List<Column> columns = generatorService.selectColums(schema,table);
		PageInfo<Column> pageInfo = new PageInfo<Column>(columns);
		return pageInfo;
	}

	@GetMapping(value = "columnExtendlist")
	@ResponseBody
	public PageInfo<ColumnExtend> columnExtendlist(String schema, String table,String searchText){
		PageInfo<ColumnExtend> pageInfo = null;
		try {
			pageInfo = columnExtendService.listByTable(schema,table,searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}
	@GetMapping(value = "columnExtendFormlist")
	@ResponseBody
	public PageInfo<ColumnExtend> columnExtendFormlist(String schema, String table,String searchText){
		PageInfo<ColumnExtend> pageInfo = null;
		try {
			pageInfo = columnExtendService.listFormByTable(schema,table,searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	@PostMapping(value = "init")
	@ResponseBody
	public Response<String> initColumnExtend(String schema, String table){
		List<Column> columns = generatorService.selectColums(schema,table);
		int k = columnExtendService.initColumnExtend(columns,schema,table);
		if(k>0) {
			return renderSuccess("初始化成功");
		} else {
			return renderError("初始化失败");
		}
	}

	@PostMapping(value = "execute")
	@ResponseBody
	public Response<String> execute(Param param){
		String projectPath = this.getClass().getClassLoader().getResource("").getPath().split("target/")[0]+"src/main/java/";
		param.setProjectPath(projectPath);
		String filePath = projectPath + param.getPackageName().replaceAll("\\.","/");
		if(param.getAliasUse()!=null&&param.getAliasUse().equals("1")){
			filePath = filePath +"/"+ param.getAlias();
		}
		param.setFilePath(filePath);
		String pagePath = this.getClass().getClassLoader().getResource("").getPath().split("target/")[0]+"src/main/webapp/WEB-INF/views/";
		String pageFilePath = pagePath+param.getPagePath()+"/"+param.getAlias();
		param.setPageFilePath(pageFilePath);
		try {
			generatorService.execute(param);
			return renderSuccess("代码生成成功");
		} catch (Exception e) {
			e.printStackTrace();
			return renderError(e.getMessage());
		}
	}

	/**
	 * 获取项目路径树状视图
	 */
	@GetMapping(value = "projectTreeView")
	@ResponseBody
	public Response<List<BaseTree>> projectTreeView(){
		String path = this.getClass().getClassLoader().getResource("").getPath().split("target/")[0]+"src/main/java/com/taiji/eap";
		path = path.substring(1,path.length());
		List<BaseTree> baseTrees = null;
		try {
			baseTrees = generatorService.projectTreeView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return renderError(e.getMessage());
		}
		return renderSuccess(baseTrees);
	}

	/**
	 * 获取JSP页面路径树状视图
	 * @return
	 */
	@GetMapping(value = "jspTreeView")
	@ResponseBody
	public Response<List<BaseTree>> jspTreeView(){
		String path = this.getClass().getClassLoader().getResource("").getPath().split("target/")[0]+"src/main/webapp/WEB-INF/views";
		path = path.substring(1,path.length());
		List<BaseTree> baseTrees = null;
		try {
			baseTrees = generatorService.jspTreeView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return renderError(e.getMessage());
		}
		return renderSuccess(baseTrees);
	}

	/**
	 * 生成表同步的sql语句
	 * @param table 表名
	 * @return
	 */
	@PostMapping(value = "syncSql")
	@ResponseBody
	public Response<String> syncSql(String schema,String table){
		String sql = generatorService.syncSql(schema,table);
		return renderSuccess(sql);
	}

}
