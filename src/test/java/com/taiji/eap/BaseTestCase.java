package com.taiji.eap;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Before;
import org.junit.Test;

public class BaseTestCase{

	@Test
	public void test(){
		System.out.println("�������");
	}
	
	ProcessEngine processEngine = null;
	
	@Before
	public void init(){
		processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("spring-main.xml")
				.buildProcessEngine();
	}
	
	@Test
	public void deploymentProcessDefinitionTest(){
		RepositoryService repositoryService = processEngine.getRepositoryService();
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		deploymentBuilder.name("activiti");
		deploymentBuilder.addClasspathResource("activiti/MyProcess.bpmn");
		deploymentBuilder.addClasspathResource("activiti/MyProcess.png");
		Deployment deployment = deploymentBuilder.deploy();
		System.out.println("����ID��" + deployment.getId());//1
		System.out.println("�������ƣ�" + deployment.getName());//activiti���ų���
	}
	
}
