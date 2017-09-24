package com.taiji.eap.biz.patient.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.taiji.eap.biz.patient.entity.Patient;

public interface PatientDao {

	public List<Patient> getPatients(@Param("area_id")String area_id);
	
}
