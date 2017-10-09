package com.taiji.eap.common.activiti.controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taiji.eap.common.activiti.service.ActivitiService;
import com.taiji.eap.common.base.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("activiti")
public class ActivitiController extends BaseController{
	
	@Autowired
	private ActivitiService activitiService;

	@GetMapping("create")
	public void create(HttpServletRequest request, HttpServletResponse response){
		try {
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

			RepositoryService repositoryService = processEngine.getRepositoryService();

			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode editorNode = objectMapper.createObjectNode();
			editorNode.put("id", "canvas");
			editorNode.put("resourceId", "canvas");
			ObjectNode stencilSetNode = objectMapper.createObjectNode();
			stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
			editorNode.put("stencilset", stencilSetNode);
			Model modelData = repositoryService.newModel();

			ObjectNode modelObjectNode = objectMapper.createObjectNode();
			modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, "hello1111");
			modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
			String description = "hello1111";
			modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
			modelData.setMetaInfo(modelObjectNode.toString());
			modelData.setName("hello1111");
			modelData.setKey("12313123");

			//保存模型
			repositoryService.saveModel(modelData);
			repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
			response.sendRedirect(request.getContextPath() + "/modeler.html?modelId=" + modelData.getId());
		} catch (Exception e) {
			System.out.println("创建模型失败：");
		}
	}
	
	@GetMapping(value={"deployment","deployment.do"})
	@ResponseBody
	public void deploymentProcessDefinition(String bpmn,String png){
		Deployment deployment = activitiService.deploymentProcessDefinition(bpmn,png);
		System.out.println(deployment.toString());
	}
	
	@GetMapping(value={"list","list.do"})
	@ResponseBody
	public void activitiList(String process_key){
		List<ProcessDefinition> processDefinitions =activitiService.activitiListByprocesskey(process_key);
		System.out.println(processDefinitions);
	}

}
