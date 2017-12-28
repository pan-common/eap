package com.taiji.eap.common.generator.service.impl;

import com.taiji.eap.common.base.BaseTree;
import com.taiji.eap.common.datasource.bean.Table;
import com.taiji.eap.common.datasource.dao.DataSourceDao;
import com.taiji.eap.common.generator.bean.*;
import com.taiji.eap.common.generator.dao.GeneratorDao;
import com.taiji.eap.common.generator.service.ColumnExtendService;
import com.taiji.eap.common.generator.service.GenerateConfService;
import com.taiji.eap.common.generator.service.GeneratorService;
import com.taiji.eap.common.shiro.bean.SysResource;
import com.taiji.eap.common.shiro.service.SysResourceService;
import com.taiji.eap.common.utils.FileUtil;
import com.taiji.eap.common.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class GeneratorServiceImpl implements GeneratorService{

    @Autowired
    private DataSourceDao dataSourceDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private ColumnExtendService columnExtendService;

    @Autowired
    private SysResourceService sysResourceService;

    @Autowired
    private GenerateConfService generateConfService;

    @Override
    public List<Table> selectTables(String schema) {
        return dataSourceDao.selectTables(schema,"TABLE");
    }

    @Override
    public List<Table> selectViews(String schema) {
        return dataSourceDao.selectTables(schema,"VIEW");
    }

    @Override
    public List<Column> selectColums(String schema, String table) {
        List<Column> list = new ArrayList<>();
        if(!StringUtils.isEmpty(table)){
            list.addAll(generatorDao.selectColums(schema,table));
        }
        return list;
    }

    @Override
    public void execute(Param param) throws Exception{
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/properties/velocity.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Velocity.init(properties);
        List<ColumnExtend> columns = columnExtendService.listByTable(param.getSchema(),param.getTableName());
        if(columns.isEmpty()){
            throw new Exception("未找到表的扩展属性！");
        }

        param.setIsExtenaField(isExtenaField(columns)?"01":"02");//01是 02 否

        boolean isHavePk = false;
        boolean isTree = false;
        for (ColumnExtend column:columns) {
            if(column.getColumnKey()!=null&&column.getColumnKey().equals("PRI")) {
                isHavePk = true;
            }
            if(param.getIsTree().equals("01")) {
                if (column.getColumnName() != null && column.getColumnName().equals(param.getParentField())) {
                    isTree = true;
                }
            }
        }
        if(!isHavePk) {
            throw new Exception("未找到主键！");
        }
        if(param.getIsTree().equals("01")&&!isTree) {
            throw new Exception("未找到名为" + param.getParentField() + "的字段，表非树结构或字段名录入错误！");
        }
        //生成实体类
        if(param.getGenerateItems().contains("bean")) {
            generateBean(param, columns);
        }
        if(param.getGenerateItems().contains("dao")) {
            //生成Dao
            generateDao(param, columns);
            //生成mapper.xml文件
            generateMapper(param, columns);
        }
        if(param.getGenerateItems().contains("service")) {
            //生成service
            generateService(param, columns);
            //生成service实现类
            generateServiceImpl(param, columns);
        }
        if(param.getGenerateItems().contains("controller")) {
            //生成Controller
            generateController(param, columns);
        }
        if(param.getGenerateItems().contains("jsp")) {
            if(param.getPageStyle().equals("01")) {
                //生成jsp主界面
                generateJspMain(param, columns);
                //生成jsp表单界面
                generateJspForm(param, columns);
                if (param.getIsTree().equals("01")) {
                    generateJspTreeView(param, columns);
                    generateJspZTree(param, columns);
                }
            }else if(param.getPageStyle().equals("02")){
                //生成easyui风格的界面
                generateEasyUiJsp(param, columns);
            }
        }
        if(param.getMenuId()!=null&&param.getMenuName()!=null&&!param.getMenuName().equals("")&&!param.getMenuId().equals("")) {
            //挂靠菜单
            SysResource sysResource = new SysResource();
            sysResource.setResourceName(param.getMenuName());
            sysResource.setParentId(Long.valueOf(param.getMenuId()));
            sysResource.setTypeCode("01");
            sysResource.setTypeDesc("菜单");
            sysResource.setResIcon("fa-trademark");
            if(param.getPageStyle().equals("01")) {
                sysResource.setLink("sysResource/link?url=" + param.getPagePath().replaceAll("\\\\", "/") + "/" + param.getAlias() + "/main");
            }else if(param.getPageStyle().equals("02")){
                sysResource.setLink("sysResource/link?url=" + param.getPagePath().replaceAll("\\\\", "/") + "/" + param.getAlias() + "/easyui/main");
            }
            sysResource.setSeq(1);
            sysResource.setNote("无");
            sysResource.setValid("1");
            sysResource.setCreateTime(new Date());
            sysResource.setUpdateTime(new Date());
            sysResource.setCreater(0L);
            sysResourceService.insert(sysResource);
        }

        GenerateConf generateConf = new GenerateConf();
        generateConf.setAlias(param.getAlias());
        generateConf.setAliasUse(param.getAliasUse());
        generateConf.setColumnExtendId(UUIDUtils.getGUID());
        generateConf.setConnectionUrl(param.getConnectionURL());
        generateConf.setDeleteWay(param.getDeleteWay());
        generateConf.setDriverClass(param.getDriverClass());
        generateConf.setFilePath(param.getFilePath());
        generateConf.setFormColumnNum(param.getFormColumnNum());
        generateConf.setGenerateItems(param.getGenerateItems());
        generateConf.setIsTree(param.getIsTree());
        generateConf.setMenuId(param.getMenuId());
        generateConf.setMenuName(param.getMenuName());
        generateConf.setNameField(param.getNameField());
        generateConf.setPackageName(param.getPackageName());
        generateConf.setPageFilePath(param.getPageFilePath());
        generateConf.setPagePath(param.getPagePath());
        generateConf.setParentField(param.getParentField());
        generateConf.setPassword(param.getPassword());
        generateConf.setProjectPath(param.getProjectPath());
        generateConf.setTableSchema(param.getSchema());
        generateConf.setTableName(param.getTableName());
        generateConf.setUserId(param.getUserId());
        generateConfService.insert(generateConf);
    }

    private boolean isExtenaField(List<ColumnExtend> columns) {
        int k = 0;
        for (int i = 0; i < columns.size(); i++) {
            if(columns.get(i).getColumnName().equals("create_time")||
                    columns.get(i).getColumnName().equals("update_time")||
                    columns.get(i).getColumnName().equals("valid")||
                    columns.get(i).getColumnName().equals("creater")){
                k++;
            }
        }
        return k==4?true:false;
    }

    private String replaceTemplate(Param param,List<ColumnExtend> columns,String templateFilePath){
        Template template = Velocity.getTemplate(templateFilePath);
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("param",param);
        velocityContext.put("columns",columns);
        StringWriter sw = new StringWriter();
        template.merge(velocityContext,sw);
        return sw.toString();
    }

    /**
     * 生成bean
     */
    private void generateBean(Param param,List<ColumnExtend> columns){
        String content = replaceTemplate(param,columns,"/velocity/bean.vm");
        String filePath = param.getFilePath()+"/bean";
        String fileName =param.getAlias().substring(0,1).toUpperCase()
                +param.getAlias().substring(1,param.getAlias().length())+".java";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }
    /**
     * 生成Dao
     */
    private void generateDao(Param param,List<ColumnExtend> columns){
        String content = replaceTemplate(param,columns,"/velocity/dao.vm");
        String filePath = param.getFilePath()+"/dao";
        String fileName =param.getAlias().substring(0,1).toUpperCase()
                +param.getAlias().substring(1,param.getAlias().length())+"Dao.java";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }

    private void generateMapper(Param param,List<ColumnExtend> columns){
        String content = replaceTemplate(param,columns,"/velocity/mapper.vm");
        String filePath = param.getFilePath()+"/dao/mapper";
        String fileName =param.getAlias().substring(0,1).toUpperCase()
                +param.getAlias().substring(1,param.getAlias().length())+"Mapper.xml";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }

    /**
     * 生成service
     */
    private void generateService(Param param,List<ColumnExtend> columns){
        String content = replaceTemplate(param,columns,"/velocity/service.vm");
        String filePath = param.getFilePath()+"/service";
        String fileName =param.getAlias().substring(0,1).toUpperCase()
                +param.getAlias().substring(1,param.getAlias().length())+"Service.java";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }

    /**
     * 生成service的实现
     */
    private void generateServiceImpl(Param param,List<ColumnExtend> columns){
        String content = replaceTemplate(param,columns,"/velocity/serviceImpl.vm");
        String filePath = param.getFilePath()+"/service/impl";
        String fileName =param.getAlias().substring(0,1).toUpperCase()
                +param.getAlias().substring(1,param.getAlias().length())+"ServiceImpl.java";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }

    /**
     * 生成controller
     */
    private void generateController(Param param,List<ColumnExtend> columns){
        String content = replaceTemplate(param,columns,"/velocity/controller.vm");
        String filePath = param.getFilePath()+"/controller";
        String fileName =param.getAlias().substring(0,1).toUpperCase()
                +param.getAlias().substring(1,param.getAlias().length())+"Controller.java";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }

    /**
     * 生成JSP主页面
     */
    private void generateJspMain(Param param,List<ColumnExtend> columns){
        Collections.sort(columns);
        String content = replaceTemplate(param,columns,"/velocity/jspMain.vm");
        String filePath = param.getPageFilePath();
        String fileName ="main.jsp";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }

    /**
     * 生成easyui风格的界面
     * @param param
     * @param columns
     */
    private void generateEasyUiJsp(Param param, List<ColumnExtend> columns) {
        Collections.sort(columns);
        String content = replaceTemplate(param,columns,"/velocity/easyuiJsp.vm");
        String filePath = param.getPageFilePath()+"/easyui";
        String fileName ="main.jsp";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }

    /**
     * 生成JSP Form也页面
     * @param param
     * @param columns
     */
    private void generateJspForm(Param param,List<ColumnExtend> columns){
        List<ColumnExtend> formColumns = new ArrayList<ColumnExtend>();
        for (int i = 0; i <columns.size() ; i++) {
            if(columns.get(i).getFormShow().equals("01")){
                formColumns.add(columns.get(i));
            }
        }
        Collections.sort(columns);
        Collections.sort(formColumns);
        Template template = Velocity.getTemplate("/velocity/jspForm.vm");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("param",param);
        velocityContext.put("columns",columns);
        velocityContext.put("formColumns",formColumns);
        StringWriter sw = new StringWriter();
        template.merge(velocityContext,sw);
        String content = sw.toString();
        String filePath = param.getPageFilePath();
        String fileName ="form.jsp";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }

    /**
     * 生成JSP TreeView页面
     * @param param
     * @param columns
     */
    private void generateJspTreeView(Param param,List<ColumnExtend> columns){
        Collections.sort(columns);
        String content = replaceTemplate(param,columns,"/velocity/jspTreeView.vm");
        String filePath = param.getPageFilePath();
        String fileName ="treeView.jsp";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }

    /**
     * 生成JSP TreeView页面
     * @param param
     * @param columns
     */
    private void generateJspZTree(Param param,List<ColumnExtend> columns){
        Collections.sort(columns);
        String content = replaceTemplate(param,columns,"/velocity/jspZTree.vm");
        String filePath = param.getPageFilePath();
        String fileName ="zTree.jsp";
        FileUtil.writeStrToFile(filePath,fileName,content);
    }

    private void generateMybatis(Param param,List<ColumnExtend> columns){
        String content = replaceTemplate(param,columns,"/velocity/generatorConfig.vm");
        String filePath = param.getProjectPath().replace("java","resource");
//        String fileName =param.getAlias().substring(0,1).toUpperCase()
//                +param.getAlias().substring(1,param.getAlias().length())+"Dao.java";
        FileUtil.writeStrToFile(filePath,"generatorConfig.xml",content);

        List<String> warnings = new ArrayList<String>();
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        boolean overwrite = true;
        try {
            Configuration config = configurationParser.parseConfiguration(new File(filePath,"generatorConfig.xml"));
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator generator = new MyBatisGenerator(config,callback,warnings);
            generator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BaseTree> projectTreeView(String path) throws Exception{
        List<BaseTree> baseTrees = new ArrayList<BaseTree>();
        File file = new File(path);
        if(file.exists()){
            FileTreeView fileTreeView = new FileTreeView();
            fileTreeView.setPackageName("com.taiji.eap");
            fileTreeView.setFileName(file.getName());
            fileTreeView.setName("com.taiji.eap");
            fileTreeView.setSpread(true);
            fileTreeView.setType(BaseTree.DICTIONARY);
            disPlay(file,fileTreeView);
            baseTrees.add(fileTreeView);
        }else{
            throw new Exception("文件夹不存在");
        }
        return baseTrees;
    }

    @Override
    public List<BaseTree> jspTreeView(String path) throws Exception{
        List<BaseTree> baseTrees = new ArrayList<BaseTree>();
        File file = new File(path);
        if(file.exists()){
            FileTreeView fileTreeView = new FileTreeView();
            fileTreeView.setPackageName(file.getName());
            fileTreeView.setFileName(file.getName());
            fileTreeView.setName("views");
            fileTreeView.setSpread(true);
            fileTreeView.setType(BaseTree.DICTIONARY);
            disPlay(file,fileTreeView);
            baseTrees.add(fileTreeView);
        }else{
            throw new Exception("文件夹不存在");
        }
        return baseTrees;
    }

    private void disPlay(File file, FileTreeView fileTreeView){
        if(file.isDirectory()){
            FileTreeView treeView = new FileTreeView();
            if(file.getPath().split("java\\\\").length>1) {
                treeView.setPackageName(file.getPath().split("java\\\\")[1].replaceAll("\\\\", "."));
            }else if(file.getPath().split("views\\\\").length>1){
                treeView.setPackageName(file.getPath().split("views\\\\")[1]);
            }
            treeView.setFileName(file.getName());
            treeView.setName(file.getName());
            treeView.setSpread(false);
            treeView.setType(BaseTree.DICTIONARY);
            fileTreeView.addChildren(treeView);
            File[] files = file.listFiles();
            if(files.length>0){
                for (File itemFile:files ) {
                    disPlay(itemFile,treeView);
                }
            }
        }
    }
}
