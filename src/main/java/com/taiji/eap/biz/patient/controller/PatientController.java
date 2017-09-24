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
		return patientService.getPatients(area_id,pageNum,pageSize);
	}

}
