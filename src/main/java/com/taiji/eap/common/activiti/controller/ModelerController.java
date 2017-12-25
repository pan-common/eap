package com.taiji.eap.common.activiti.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.utils.Status;
import com.taiji.eap.common.utils.ToWeb;
import org.activiti.bpmn.constants.BpmnXMLConstants;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.IOUtils;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("models")
public class ModelerController extends BaseController{

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("newModel")
    public void newModel(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        String name = "new-process";
        String description = "";
        int revision = 1;
        String key = "process";
        try {
            ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

            RepositoryService repositoryService = processEngine.getRepositoryService();

            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put("id", "canvas");
            editorNode.put("resourceId", "canvas");
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.put("stencilset", stencilSetNode);
            Model modelData = repositoryService.newModel();

            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            modelObjectNode.put(ModelDataJsonConstants.MODEL_ID,"1111");
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
            modelData.setMetaInfo(modelObjectNode.toString());
            modelData.setName(name);
            modelData.setKey(key);

            //保存模型
            repositoryService.saveModel(modelData);
            repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
            response.sendRedirect(request.getContextPath() + "/modeler.html?modelId=" + modelData.getId());
        } catch (Exception e) {
            System.out.println("创建模型失败：");
        }
    }

    /**
     * 编辑模型
     * @param request
     * @param response
     * @param id
     */
    @GetMapping(value = "editModel")
    public void editModel(HttpServletRequest request, HttpServletResponse response,String id){
        try {
            response.sendRedirect(request.getContextPath() + "/modeler.html?modelId=" + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出xm定义文件
     * @param id
     * @param response
     */
    @GetMapping(value = "export")
    public void export(String id,HttpServletResponse response){
        try {
            Model modelData = repositoryService.getModel(id);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            JsonNode editorNode = objectMapper.readTree(repositoryService.getModelEditorSource(modelData.getId()));
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
            BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
            byte[] bpmnBytes = xmlConverter.convertToXML(bpmnModel);
            ByteArrayInputStream in = new ByteArrayInputStream(bpmnBytes);
            IOUtils.copy(in,response.getOutputStream());
            String fileName = bpmnModel.getMainProcess().getId()+".bpmn20.xml";
            response.setHeader("Content-Disposition","attachment;filename="+fileName);
            response.flushBuffer();
        }catch (Exception e){
            logger.error("导出model的xml文件失败：modelId={}",id,e);
        }

    }

    /**
     * 流程转模型
     * @param id
     * @return
     * @throws UnsupportedEncodingException
     * @throws XMLStreamException
     */
    @PostMapping("convertToModel")
    @ResponseBody
    public Response<String> convertToModel(String id)throws UnsupportedEncodingException,XMLStreamException{
        //查询流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionId(id).singleResult();
        InputStream bpmnStream = repositoryService.getResourceAsStream(
                processDefinition.getDeploymentId(),
                processDefinition.getResourceName());
        XMLInputFactory xif = XMLInputFactory.newInstance();
        InputStreamReader in = new InputStreamReader(bpmnStream,"UTF-8");
        XMLStreamReader xtr = xif.createXMLStreamReader(in);
        BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xtr);
        BpmnJsonConverter converter = new BpmnJsonConverter();
        ObjectNode modelNode = converter.convertToJson(bpmnModel);
        Model modelData = repositoryService.newModel();
        modelData.setKey(processDefinition.getKey());
        modelData.setName(processDefinition.getName());
        modelData.setCategory(processDefinition.getCategory());
        modelData.setDeploymentId(processDefinition.getDeploymentId());
        modelData.setVersion(processDefinition.getVersion());
        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME,processDefinition.getName());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION,1);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION,processDefinition.getDescription());
        modelData.setMetaInfo(modelObjectNode.toString());
        //保存模型并设置模型属性
        repositoryService.saveModel(modelData);
        repositoryService.addModelEditorSource(modelData.getId(),modelNode.toString().getBytes("utf-8"));
        return renderSuccess("转换成功");
    }


    /**
     * 发布模型为流程定义
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("deployment")
    @ResponseBody
    public Response<String> deploy(String id) throws Exception{
        Model modelData = repositoryService.getModel(id);
        byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());
        if(bytes==null){
            return renderError("模型数据为空，请先设计流程并成功保存，再进行发布。");
        }
        JsonNode modelNode = new ObjectMapper().readTree(bytes);
        BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        if(model.getProcesses().size()==0){
            return renderError("数据模型不符要求，请至少设计一条主线流程。");
        }
        byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(model);
        //发布流程
        String processName = modelData.getName()+".bpmn20.xml";
        Deployment deployment = repositoryService.createDeployment()
                .name(modelData.getName())
                .addString(processName,new String(bpmnBytes,"UTF-8")).deploy();
        modelData.setDeploymentId(deployment.getId());
        repositoryService.saveModel(modelData);
        return renderSuccess("发布成功");
    }

    @GetMapping(value = "getOne")
    public Object getOne(@PathVariable("id")String id) {
        Model model = repositoryService.createModelQuery().modelId(id).singleResult();
        return ToWeb.buildResult().setObjData(model);
    }

    @GetMapping(value = "getList")
    @ResponseBody
    public PageInfo<Model> getList(Integer pageNum,Integer pageSize,String searchText) {
        List<Model> list = repositoryService.createModelQuery().listPage(pageSize * (pageNum - 1)
                , pageSize);
        long count = repositoryService.createModelQuery().count();
        PageInfo<Model> modelPageInfo = new PageInfo<>();
        modelPageInfo.setList(list);
        modelPageInfo.setTotal(count);
        modelPageInfo.setPageNum((int) (count/pageSize+1));
        modelPageInfo.setPageSize(pageSize);
        modelPageInfo.setPages(pageNum);
        return modelPageInfo;
    }

    @GetMapping(value = "postOne")
    public Object postOne(@RequestBody Model entity) {
        throw new UnsupportedOperationException();
    }

    @GetMapping(value = "putOne")
    public Object putOne(@PathVariable("id") String id, @RequestBody Model entity) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(value = "patchOne")
    public Object patchOne(@PathVariable("id") String s, @RequestBody Model entity) {
        throw new UnsupportedOperationException();
    }

    @PostMapping("deleteOne")
    @ResponseBody
    public Response<String> deleteOne(String id) {
        repositoryService.deleteModel(id);
        return renderSuccess("删除成功");
    }
}
