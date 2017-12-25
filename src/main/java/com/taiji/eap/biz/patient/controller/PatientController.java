package com.taiji.eap.biz.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.patient.entity.Patient;
import com.taiji.eap.biz.patient.service.PatientService;
import com.taiji.eap.common.http.entity.Response;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value="/getPatients",method=RequestMethod.GET)
	@ResponseBody
	public Response<PageInfo<Patient>> getPatients(String area_id,int pageNum,int pageSize){
		String aa = "[{\"unit\":\"℃\",\"itemName\":\"体温\",\"itemType\":\"FORM_ITEM_V_TYPE_3\",\"itemId\":\"2\",\"checkType\":\"FORM_ITEMS_SZJP_01\",\"itemWidth\":\"90\",\"iorder\":\"01\",\"maxValue\":\"42\",\"minValue\":\"34\",\"checkClass\":\"com.hrhy.cc.inputcheck.FloatCheck\",\"hisType\":\"1\"},{\"unit\":\"次/分\",\"itemName\":\"脉搏\",\"itemType\":\"FORM_ITEM_V_TYPE_3\",\"itemId\":\"4\",\"checkType\":\"FORM_ITEMS_SZJP_02\",\"itemWidth\":\"90\",\"iorder\":\"02\",\"maxValue\":\"180\",\"minValue\":\"20\",\"checkClass\":\"com.hrhy.cc.inputcheck.GeneralCheck\",\"hisType\":\"3\"},{\"unit\":\"次/分\",\"itemName\":\"呼吸\",\"itemType\":\"FORM_ITEM_V_TYPE_3\",\"itemId\":\"5\",\"checkType\":\"FORM_ITEMS_SZJP_03\",\"itemWidth\":\"90\",\"iorder\":\"03\",\"maxValue\":\"99\",\"minValue\":\"0\",\"checkClass\":\"com.hrhy.cc.inputcheck.GeneralCheck\",\"hisType\":\"5\"},{\"unit\":\"次/分\",\"itemName\":\"心率\",\"itemType\":\"FORM_ITEM_V_TYPE_3\",\"itemId\":\"30\",\"checkType\":\"FORM_ITEMS_SZJP_06\",\"itemWidth\":\"90\",\"iorder\":\"04\",\"maxValue\":\"180\",\"minValue\":\"0\",\"checkClass\":\"com.hrhy.cc.inputcheck.GeneralCheck\",\"hisType\":\"4\"},{\"unit\":\"mmHg\",\"itemName\":\"血压\",\"itemType\":\"FORM_ITEM_V_TYPE_3\",\"itemId\":\"6\",\"checkType\":\"FORM_ITEMS_SZJP_04\",\"itemWidth\":\"140\",\"iorder\":\"05\",\"maxValue\":\"300\",\"minValue\":\"0\",\"checkClass\":\"com.hrhy.cc.inputcheck.BloodCheck\",\"hisType\":\"FORM_NUMBER_CHECK_08\"},{\"unit\":\"kg\",\"itemName\":\"体重\",\"itemType\":\"FORM_ITEM_V_TYPE_3\",\"itemId\":\"9\",\"checkType\":\"FORM_ITEMS_SZJP_10\",\"itemWidth\":\"90\",\"iorder\":\"06\",\"maxValue\":\"300\",\"minValue\":\"0\",\"checkClass\":\"com.hrhy.cc.inputcheck.GeneralCheck\",\"hisType\":\"12\"},{\"unit\":\"次/天\",\"itemName\":\"大便\",\"itemType\":\"FORM_ITEM_V_TYPE_3\",\"itemId\":\"7\",\"checkType\":\"FORM_ITEMS_SZJP_07\",\"itemWidth\":\"90\",\"iorder\":\"09\",\"maxValue\":\"3\",\"minValue\":\"0\",\"checkClass\":\"com.hrhy.cc.inputcheck.ShitCheck\",\"hisType\":\"9\"}]";
		return patientService.getPatients(area_id,pageNum,pageSize);
	}

}
