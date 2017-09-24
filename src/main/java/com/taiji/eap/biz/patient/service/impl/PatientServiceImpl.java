package com.taiji.eap.biz.patient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.patient.dao.PatientDao;
import com.taiji.eap.biz.patient.entity.Patient;
import com.taiji.eap.biz.patient.service.PatientService;
import com.taiji.eap.common.http.entity.Response;
import com.taiji.eap.common.http.methods.HttpResponseHelper;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao patientDao;

	@Override
	public Response<PageInfo<Patient>> getPatients(String area_id, int pageNum,
			int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Patient> patients = patientDao.getPatients(area_id);
		PageInfo<Patient> list = new PageInfo<Patient>(patients);
		HttpResponseHelper<PageInfo<Patient>> helper = new HttpResponseHelper<PageInfo<Patient>>();
		return helper.getResponse(list);
	}

}
