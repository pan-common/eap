package com.taiji.eap.common.generator.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.*;
import com.taiji.eap.common.generator.dao.GeneratorDao;
import com.taiji.eap.common.generator.service.DataSourceService;
import com.taiji.eap.common.generator.service.GeneratorService;
import com.taiji.eap.common.http.entity.Response;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/generator")
public class GeneratorController extends BaseController{

	@Autowired
	GeneratorService generatorService;

	@Autowired
	DataSourceService dataSourceService;

	@GetMapping(value = "getTables")
	@ResponseBody
	public Response<List<LayuiTree>> getTables(){
		LayuiTree connect = new Connect();
		connect.setName("默认数据库连接");
		connect.setSpread(true);
		connect.setType(LayuiTree.CONNECT);
		List<LayuiTree> layuiTrees = new ArrayList<LayuiTree>();
		layuiTrees.add(connect);
		for (int i = 0; i < layuiTrees.size(); i++) {
			List<LayuiTree> dataSources = dataSourceService.getDataSources();
			layuiTrees.get(i).addChildrens(dataSources);
			for (int j = 0; j < dataSources.size(); j++) {
				List<Table> tables = generatorService.selectTables(((DataSource)dataSources.get(i)).getDatabaseName());
				for (int k = 0; k < tables.size() ; k++) {
					tables.get(k).setName(tables.get(k).gettName());
					tables.get(k).setSpread(true);
					tables.get(k).setType(LayuiTree.TABLE);
					dataSources.get(j).addChildren(tables.get(k));
				}
			}
		}
		return renderSuccess(layuiTrees);
	}

	@GetMapping(value = "getColumns")
	@ResponseBody
	public PageInfo<Column> getColumns(String schema, String table){
		List<Column> columns = generatorService.selectColums(schema,table);
		PageInfo<Column> pageInfo = new PageInfo<Column>(columns);
		return pageInfo;
	}

	@PostMapping(value = "execute")
	@ResponseBody
	public void execute(Param param){
		generatorService.execute(param);
	}

	/**
	 * 获取项目路径树状视图
	 */
	@GetMapping(value = "projectTreeView")
	@ResponseBody
	public Response<List<LayuiTree>> projectTreeView(){
		String path = this.getClass().getClassLoader().getResource("").getPath().split("target/")[0]+"src/main/java/com/taiji/eap";
		path = path.substring(1,path.length());
		List<LayuiTree> layuiTrees = null;
		try {
			layuiTrees = generatorService.projectTreeView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return renderError(e.getMessage());
		}
		return renderSuccess(layuiTrees);
	}

}
