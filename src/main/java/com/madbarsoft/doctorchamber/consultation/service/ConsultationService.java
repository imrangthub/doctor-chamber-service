package com.madbarsoft.doctorchamber.consultation.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.madbarsoft.doctorchamber.consultation.ConsultationEntity;
import com.madbarsoft.doctorchamber.util.Response;

public interface ConsultationService {

	public Response list();
	
	public Response gridList(HttpServletRequest request);

	public Response listWithFilter(Map<String, String> queryMap);

	public Response save(ConsultationEntity brand);

	// public Response update(ConsultationEntity brand);
	//
	// public Response remove(Long id);
	//
	// public Response delete(Long id);
	//
	public Response findByConsultationId(ConsultationEntity reqObj);

	//
	//
	public Response findByHospitalNumber(String hnNumber);

	public Response findByDoctorNo(Long doctorNo);

	public Response findListDocotorNo(Long doctorNo);
	//
	// public Response updateByAppointmentNo(Long appointmentNo);
	//
	// public Response updateByAppointmentNoConsIn(Long appointmentNo);
	//
	// public Response registrationListWithFilter(Map<String, String> queryMap);

}
