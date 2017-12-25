package com.taiji.eap.common.activiti.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.activiti.bean.ProcessDefinitionResponse;
import com.taiji.eap.common.base.BaseController;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("processDefinition")
public class ProcessDefinitionController extends BaseController{

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("getList")
    @ResponseBody
    public PageInfo<ProcessDefinitionResponse> getList(Integer pageNum, Integer pageSize){
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionVersion()
                .asc()
                .listPage(pageSize * (pageNum - 1)
                , pageSize);
       List<ProcessDefinitionResponse> responses = new ArrayList<>();
        for (ProcessDefinition processDefinition: list) {
            ProcessDefinitionResponse response = new ProcessDefinitionResponse();
            response.setId(processDefinition.getId());
            response.setCategory(processDefinition.getCategory());
            response.setName(processDefinition.getName());
            response.setKey(processDefinition.getKey());
            response.setDescription(processDefinition.getDescription());
            response.setVersion(processDefinition.getVersion());
            response.setResourceName(processDefinition.getResourceName());
            response.setDeploymentId(processDefinition.getDeploymentId());
            response.setDiagramResourceName(processDefinition.getDiagramResourceName());
            response.setHasStartFormKey(processDefinition.hasStartFormKey());
            response.setHasGraphicalNotation(processDefinition.hasGraphicalNotation());
            response.setSuspended(processDefinition.isSuspended());
            responses.add(response);
        }
        long count = repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionVersion()
                .asc()
                .count();
        PageInfo<ProcessDefinitionResponse> pageInfo = new PageInfo<>();
        pageInfo.setList(responses);
        pageInfo.setTotal(count);
        pageInfo.setPageNum((int) (count/pageSize+1));
        pageInfo.setPageSize(pageSize);
        pageInfo.setPages(pageNum);
        return pageInfo;
    }


}
