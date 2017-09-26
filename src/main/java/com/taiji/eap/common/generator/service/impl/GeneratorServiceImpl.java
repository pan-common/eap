package com.taiji.eap.common.generator.service.impl;

import com.taiji.eap.common.generator.bean.*;
import com.taiji.eap.common.generator.dao.GeneratorDao;
import com.taiji.eap.common.generator.service.GeneratorService;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class GeneratorServiceImpl implements GeneratorService{

    @Autowired
    private GeneratorDao generatorDao;

    @Override
    public List<Table> selectTables(String schema) {
        return generatorDao.selectTables(schema);
    }

    @Override
    public List<Column> selectColums(String schema, String table) {
        return generatorDao.selectColums(schema,table);
    }

    @Override
    public void execute(Param param) {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/properties/velocity.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Velocity.init(properties);
        List<Column> columns = selectColums(param.getSchema(),param.getTableName());
        generateBean(param,columns);
    }

    @Override
    public List<LayuiTree> projectTreeView(String path) throws Exception{
        List<LayuiTree> layuiTrees = new ArrayList<LayuiTree>();
        File file = new File(path);
        if(file.exists()){
            FileTreeView fileTreeView = new FileTreeView();
            fileTreeView.setPackageName("com.taiji.eap");
            fileTreeView.setFileName(file.getName());
            fileTreeView.setName("com.taiji.eap");
            fileTreeView.setSpread(true);
            fileTreeView.setType(LayuiTree.DICTIONARY);
            disPlay(file,fileTreeView);
            layuiTrees.add(fileTreeView);
        }else{
            throw new Exception("文件夹不存在");
        }
        return layuiTrees;
    }

    private void disPlay(File file, FileTreeView fileTreeView){
        if(file.isDirectory()){
            FileTreeView treeView = new FileTreeView();
            treeView.setPackageName(file.getPath());
            treeView.setFileName(file.getName());
            treeView.setName(file.getName());
            treeView.setSpread(false);
            treeView.setType(LayuiTree.DICTIONARY);
            fileTreeView.addChildren(treeView);
            File[] files = file.listFiles();
            if(files.length>0){
                for (File itemFile:files ) {
                    disPlay(itemFile,treeView);
                }
            }
        }
    }

    /**
     * 生成bean
     */
    private void generateBean(Param param,List<Column> columns){
        Template template = Velocity.getTemplate("velocity/bean.vm");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("param",param);
        velocityContext.put("columns",columns);

        StringWriter sw = new StringWriter();
        template.merge(velocityContext,sw);
        System.out.println(sw.toString());
    }

    /**
     * 生成service
     */
    private void generateService(){

    }

    /**
     * 生成Dao
     */
    private void generateDao(){

    }

    /**
     * 生成controller
     */
    private void generateController(){

    }

    /**
     * 生成JSP
     */
    private void generateJsp(){

    }
}
