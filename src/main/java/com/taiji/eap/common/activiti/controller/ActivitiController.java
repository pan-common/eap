package com.taiji.eap.common.activiti.controller;

import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taiji.eap.common.activiti.service.ActivitiService;
import com.taiji.eap.common.base.BaseController;

@Controller
@RequestMapping("activiti")
public class ActivitiController extends BaseController{
	
	@Autowired
	private ActivitiService activitiService;
	
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
