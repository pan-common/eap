package com.taiji.eap.common.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.LayuiTree;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.shiro.bean.SysResource;
import com.taiji.eap.common.shiro.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("resource")
public class SysResourceController extends BaseController{
	
	@Autowired
	private SysResourceService sysResourceService;
	
	
	@GetMapping(value="selectTreeMenu")
	@ResponseBody
	public Response<List<SysResource>> selectTreeMenu(){
//		ShiroUser shiroUser = getShiroUser();
//		List<Long> roleIds = shiroUser.getRoles();
//		List<Long> organIds = shiroUser.getOrgans();
//		List<SysResource> sysResources =sysResourceService.selectUserMenu(roleIds,organIds);
		List<SysResource> sysResources =sysResourceService.selectAllMenu();
		return renderSuccess(sysResources);
	}

	/**
	 * 跳转页面
	 * @param request
	 * @param url
	 * @return
	 */
	@GetMapping(value="link")
	public ModelAndView link(HttpServletRequest request, String url){
		Map<String, String> map = request.getParameterMap();
		return toView(url, map);
	}
	
	@GetMapping(value="getPath")
	@ResponseBody
	public Response<List<SysResource>> getPath(Long resourceId){
		List<SysResource> sysResources = sysResourceService.getPath(resourceId);
		return renderSuccess(sysResources);
	}

	@GetMapping(value ="list")
	@ResponseBody
	public PageInfo<SysResource> list(Long parentId,Integer pageNum,Integer pageSize,String searchText){
		PageInfo<SysResource> pageInfo = sysResourceService.list(parentId,pageNum,pageSize,searchText);
		return pageInfo;
	}
	@PostMapping(value = "add")
	@ResponseBody
	public Response<String> add(SysResource resource){
		resource.setCreateTime(new Date());
		resource.setUpdateTime(new Date());
		resource.setValid("1");
		resource.setCreater(1L);
		int k = sysResourceService.add(resource);
		if(k>0){
			return renderSuccess("添加成功");
		}else {
			return renderError("失败");
		}
	}

	@PostMapping(value = "edit")
	@ResponseBody
	public Response<String> edit(SysResource resource){
		resource.setUpdateTime(new Date());
		resource.setValid("1");
		resource.setCreater(1L);
		int k = sysResourceService.edit(resource);
		if(k>0){
			return renderSuccess("添加成功");
		}else {
			return renderError("失败");
		}
	}

	@PostMapping(value = "delete")
	@ResponseBody
	public Response<String> delete(Long resourceId){
		int k = sysResourceService.delete(resourceId);
		if(k>0){
			return renderSuccess("删除成功");
		}else {
			return renderError("失败");
		}
	}

	@GetMapping(value = "selectOne")
	@ResponseBody
	public Response<SysResource> selectOne(Long resourceId){
		return  renderSuccess(sysResourceService.selectOne(resourceId));
	}

	@GetMapping(value = "layuiTreeView")
	@ResponseBody
	public Response<List<LayuiTree>> layuiTreeView(){
		return renderSuccess(sysResourceService.treeView());
	}

}
