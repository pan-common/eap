package com.taiji.eap.common.activiti.service;

import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

public interface ActivitiService {
	/**
	 * 部署流程
	 * @param xmlPath
	 * @return
	 */
	public Deployment deploymentProcessDefinition(String... xmlPath);
	/**
	 * 获取activiti服务列表
	 * @param process_key
	 * @return
	 */
	public List<ProcessDefinition> activitiListByprocesskey(String process_key);
	/**
	 * 删除部署流程
	 * @param process_key
	 */
	public void deleteProcDefByprocesskey(String process_key);

}
