package com.taiji.eap.common.activiti.service;

import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

public interface ActivitiService {
	/**
	 * ��������
	 * @param xmlPath
	 * @return
	 */
	public Deployment deploymentProcessDefinition(String... xmlPath);
	/**
	 * ��ȡactiviti�����б�
	 * @param process_key
	 * @return
	 */
	public List<ProcessDefinition> activitiListByprocesskey(String process_key);
	/**
	 * ɾ����������
	 * @param process_key
	 */
	public void deleteProcDefByprocesskey(String process_key);

}
