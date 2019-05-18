package com.madbarsoft.doctorchamber.consultation.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.madbarsoft.doctorchamber.consultation.ConsultationEntity;
import com.madbarsoft.doctorchamber.consultation.repository.ConsultationRepositoryMedicareLive;
import com.madbarsoft.doctorchamber.util.Response;

public class ConsultationServiceMedicareLive implements ConsultationService {

	@Autowired
	ConsultationRepositoryMedicareLive consulationRepository;

	public Response list() {
		return consulationRepository.list();
	}

	public Response gridList(HttpServletRequest request) {
		return consulationRepository.gridList(request);
	}

	public Response listWithFilter(Map<String, String> queryMap) {

		return consulationRepository.listWithFilter(queryMap);
	}
	
//	@Override
//	public Response registrationListWithFilter(Map<String, String> queryMap) {
//		return consulationRepository.registrationListWithFilter(queryMap);
//	}

	public Response save(ConsultationEntity brand) {

		return consulationRepository.save(brand);
	}

	public Response update(ConsultationEntity brand) {

		return consulationRepository.update(brand);
	}

	public Response remove(Long id) {

		return consulationRepository.remove(id);
	}

	public Response delete(Long id) {

		return consulationRepository.detele(id);
	}

	public Response findByConsultationId(ConsultationEntity reqObj) {
		return consulationRepository.findByConsultationId(reqObj);
	}

	public Response findByHospitalNumber(String hnNumber) {
		return consulationRepository.findByHospitalNumber(hnNumber);
	}

	public Response findByDocotorNo(Long doctorNo) {
		return consulationRepository.findByDoctorNo(doctorNo);
	}

	public Response updateByAppointmentNo(Long appointmentNo) {
		return consulationRepository.updateByAppointmentNo(appointmentNo);
	}
	
	public Response updateByAppointmentNoConsIn(Long appointmentNo) {
		return consulationRepository.consltInByAppointmentNo(appointmentNo);
	}
}
