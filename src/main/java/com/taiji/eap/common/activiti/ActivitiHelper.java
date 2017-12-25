package com.taiji.eap.common.activiti;

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
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class ActivitiHelper {
    @Resource
    private RepositoryService repositoryService;//用于获得activiti服务
    @Resource
    private RuntimeService runtimeService;//用于管理运行时流程实例
    @Resource
    private TaskService taskService;//用于管理运行时任务
    @Resource
    private FormService formService;//用于管理任务表单
    @Resource
    private HistoryService historyService;//管理流程实例、任务实例等历史数据
    @Resource
    private ManagementService managementService;//用于管理定时任务
    @Resource
    private IdentityService identityService;//用于管理组织结构

    public ActivitiHelper() {

    }
    /**
     * activiti服务列表
     * @param process_key
     * @return
     */
    public List<ProcessDefinition> activitiListByprocesskey(String process_key){
        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(process_key)
                .orderByProcessDefinitionVersion()
                .desc()
                .list();
        return processDefinitions;
    }
    /**
     * 当前任务的执行情况
     * @param pdfid
     * @return
     */
    public List<ProcessInstance> listProcInstByPdfid(String pdfid){
        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery()
                .processDefinitionId(pdfid)
                .list();
        return processInstances;
    }
    /**
     * 部署流程
     * @param xmlPath
     * @return
     */
    public Deployment deployProcDefByPath(String xmlPath){
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource(xmlPath)
                .deploy();
        return deployment;
    }
    /**
     * 删除部署的流程
     * @param process_key
     */
    public void deleteProcDefByprocesskey(String process_key){
        List<ProcessDefinition> processDefinitions = this.activitiListByprocesskey(process_key);
        for (ProcessDefinition task : processDefinitions) {
            List<Task> tasks = taskService.createTaskQuery().processDefinitionId(task.getId()).list();
            for (Task t : tasks) {
                taskService.deleteTask(t.getId());
            }
            repositoryService.deleteDeployment(task.getDeploymentId());
        }
    }
    public RepositoryService getRepositoryService() {
        return repositoryService;
    }
    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }
    public RuntimeService getRuntimeService() {
        return runtimeService;
    }
    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }
    public TaskService getTaskService() {
        return taskService;
    }
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    public FormService getFormService() {
        return formService;
    }
    public void setFormService(FormService formService) {
        this.formService = formService;
    }
    public HistoryService getHistoryService() {
        return historyService;
    }
    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }
    public ManagementService getManagementService() {
        return managementService;
    }
    public void setManagementService(ManagementService managementService) {
        this.managementService = managementService;
    }
    public IdentityService getIdentityService() {
        return identityService;
    }
    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

}
