package com.taiji.eap.common.generator.controller;

import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.generator.bean.Table;
import com.taiji.eap.common.generator.bean.Test;
import com.taiji.eap.common.generator.dao.GeneratorDao;
import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/generator")
public class GeneratorController extends BaseController{

	@Autowired
	GeneratorDao generatorDao;

	@RequestMapping(value="/getTables",method=RequestMethod.GET)
	@ResponseBody
	public List<Table> getTables(String parent_code){
		return generatorDao.selectTables();
	}

	@GetMapping("/main")
	public String main(){
		return "system/generator/main";
	} 

	@GetMapping("/test")
	public ModelAndView test(){
		ModelAndView mav= new ModelAndView();  
		mav.addObject("city","����");
		mav.setViewName("test");  
		return mav;
	}

	@PostMapping("/createCode")
	@ResponseBody
	public void createCode(Test test){
		Properties p = new Properties();
		// ����properties�ļ�
		try {
			p.load(this.getClass().getResourceAsStream("/velocity.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Velocity.init(p);
		Template template = Velocity.getTemplate("velocity/test.vm");
		System.out.println(template);
	}

}
