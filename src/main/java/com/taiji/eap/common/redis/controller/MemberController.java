package com.taiji.eap.common.redis.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.taiji.eap.common.base.BaseController;
import com.taiji.eap.common.redis.bean.Member;
import com.taiji.eap.common.redis.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController extends BaseController{

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value={"/add","/add.do"},method={RequestMethod.GET})
	@ResponseBody
	public ModelAndView add(){
		Map<String, String> map = new HashMap<String, String>();
		Member member = new Member();
		member.setId("1");
		member.setNickname("panhongzhi");
		memberService.add(member);
		return toView("system/redis/add", map);
	}
	
}
