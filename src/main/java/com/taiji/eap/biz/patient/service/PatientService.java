package com.taiji.eap.biz.patient.service;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.biz.patient.entity.Patient;
import com.taiji.eap.common.http.entity.Response;

public interface PatientService {
	public Response<PageInfo<Patient>> getPatients(String area_id, int pageNum, int pageSize);
}
