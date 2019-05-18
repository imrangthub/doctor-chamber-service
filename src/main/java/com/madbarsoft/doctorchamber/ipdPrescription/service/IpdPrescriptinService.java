package com.madbarsoft.doctorchamber.ipdPrescription.service;

import com.madbarsoft.doctorchamber.ipdPrescription.PatientRequestParamEntity;
import com.madbarsoft.doctorchamber.util.Response;


public interface IpdPrescriptinService {
	public Response nurseStationList(Long userNo);
	public Response patientList(PatientRequestParamEntity obj);

}
