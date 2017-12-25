package com.taiji.eap.common.activiti.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.activiti.bean.DeploymentResponse;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.utils.ToWeb;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 潘宏智
 * @date 2017-12-18 13:01
 */
@Controller
@RequestMapping("deployments")
public class DeploymentController extends BaseController{


    @Autowired
    RepositoryService repositoryService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("getOne")
    public Object getOne(@PathVariable("id") String id) {
        Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(id).singleResult();
        return ToWeb.buildResult().setObjData(new DeploymentResponse(deployment));
    }

    @GetMapping("getList")
    @ResponseBody
    public PageInfo<DeploymentResponse> getList(Integer pageNum, Integer pageSize) {
        List<Deployment> deployments = repositoryService.createDeploymentQuery()
                .listPage(pageSize * (pageNum - 1), pageSize);
        long count = repositoryService.createDeploymentQuery().count();
        List<DeploymentResponse> list = new ArrayList<>();
        for (Deployment deployment:deployments) {
            list.add(new DeploymentResponse(deployment));
        }
        PageInfo<DeploymentResponse> pageInfo = new PageInfo<>();
        pageInfo.setList(list);
        pageInfo.setTotal(count);
        pageInfo.setPageNum((int) (count/pageSize+1));
        pageInfo.setPageSize(pageSize);
        pageInfo.setPages(pageNum);
        return pageInfo;
    }

    @PostMapping("postOne")
    public Object postOne(@RequestBody Deployment entity) {
        return null;
    }

    @PostMapping("putOne")
    public Object putOne(@PathVariable("id") String s, @RequestBody Deployment entity) {
        return null;
    }

    @PostMapping("patchOne")
    public Object patchOne(@PathVariable("id") String s, @RequestBody Deployment entity) {
        return null;
    }

    @PostMapping("deleteOne")
    @ResponseBody
    public Response<String> deleteOne(String id) {
        repositoryService.deleteDeployment(id);
        return renderSuccess("删除成功");
    }
}
