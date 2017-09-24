package com.taiji.eap.common.activiti.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import com.taiji.eap.common.activiti.service.ActivitiService;

@Service
public class ActivitiServiceImpl implements ActivitiService{

	@Resource
	private RepositoryService repositoryService;//���ڻ��activiti����
	@Resource
	private RuntimeService runtimeService;//���ڹ�������ʱ����ʵ��
	@Resource
	private TaskService taskService;//���ڹ�������ʱ����
	@Resource
	private FormService formService;//���ڹ��������
	@Resource
	private HistoryService historyService;//��������ʵ��������ʵ������ʷ����
	@Resource
	private ManagementService managementService;//���ڹ���ʱ����
	@Resource
	private IdentityService identityService;//���ڹ�����֯�ṹ

	@Override
	public Deployment deploymentProcessDefinition(String... xmlPath) {
		Deployment deployment = repositoryService.createDeployment()
				.addClasspathResource(xmlPath[0])
				.addClasspathResource(xmlPath[1])
				.deploy();
		return deployment;
	}
	
	@Override
	public List<ProcessDefinition> activitiListByprocesskey(String process_key) {
		List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery()
				.processDefinitionKey(process_key)
				.orderByProcessDefinitionVersion()
				.desc()
				.list();
		return processDefinitions;
	}

	@Override
	public void deleteProcDefByprocesskey(String process_key) {
		List<ProcessDefinition> processDefinitions = this.activitiListByprocesskey(process_key);
		for (ProcessDefinition task : processDefinitions) {
			List<Task> tasks = taskService.createTaskQuery().processDefinitionId(task.getId()).list();
			for (Task t : tasks) {
				taskService.deleteTask(t.getId());
			}
			repositoryService.deleteDeployment(task.getDeploymentId());
		}
	}


}
