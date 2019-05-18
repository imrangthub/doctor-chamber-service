package com.madbarsoft.doctorchamber.ipdPrescription.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.madbarsoft.doctorchamber.ipdPrescription.PatientRequestParamEntity;
import com.madbarsoft.doctorchamber.ipdPrescription.repository.IpdPrescriptionRepositoryMedicareNew;
import com.madbarsoft.doctorchamber.util.Response;

public class IpdPrescriptionServiceMedicareNew implements IpdPrescriptinService {

	@Autowired
	IpdPrescriptionRepositoryMedicareNew ipdPrescriptionRepositoryMedicareNew;
	
	@Override
	public Response nurseStationList(Long userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response patientList(PatientRequestParamEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}


}
