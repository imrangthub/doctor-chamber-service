package com.madbarsoft.doctorchamber.ipdPrescription.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.madbarsoft.doctorchamber.ipdPrescription.PatientRequestParamEntity;
import com.madbarsoft.doctorchamber.ipdPrescription.repository.IpdPrescriptionRepositoryMedicareLive;
import com.madbarsoft.doctorchamber.util.Response;


public class IpdPrescriptionServiceMedicareLive implements IpdPrescriptinService {

	@Autowired
	IpdPrescriptionRepositoryMedicareLive ipdPrescriptionRepositoryMedicareLive;

	@Override
	public Response nurseStationList(Long userNo) {
		return ipdPrescriptionRepositoryMedicareLive.getNurseStationList(userNo);
	}



	@Override
	public Response patientList(PatientRequestParamEntity obj) {
		return ipdPrescriptionRepositoryMedicareLive.getpatientList(obj.getRoomNo(),obj.getUserNo());
	}


}
