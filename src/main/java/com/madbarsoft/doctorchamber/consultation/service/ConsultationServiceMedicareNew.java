package com.madbarsoft.doctorchamber.consultation.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.madbarsoft.doctorchamber.consultation.ConsultationEntity;
import com.madbarsoft.doctorchamber.consultation.repository.ConsultationRepositoryMedicareNew;
import com.madbarsoft.doctorchamber.consultation.repository.ConsultationRepositoryMedicareDataTbl;
import com.madbarsoft.doctorchamber.util.Response;

public class ConsultationServiceMedicareNew implements ConsultationService {

	@Autowired
	ConsultationRepositoryMedicareNew consulationRepository;
	
	@Autowired
	private ConsultationRepositoryMedicareDataTbl consultationRepositoryMedicareDataTbl;
	
	public Response gridList(HttpServletRequest request) {
		return consultationRepositoryMedicareDataTbl.gridList(request);
	}

	public Response list() {
		return consulationRepository.list();
	}
//
//	public Response gridList(HttpServletRequest request) {
//		return consulationRepository.gridList(request);
//	}

	public Response listWithFilter(Map<String, String> queryMap) {

		return consulationRepository.listWithFilter(queryMap);
	}
	
//	public Response registrationListWithFilter(Map<String, String> queryMap) {
//
//		return consulationRepository.registrationListWithFilter(queryMap);
//	}
//
	public Response save(ConsultationEntity brand) {

		return consulationRepository.save(brand);
	}
	
	public Response findListDocotorNo(Long doctorNo) {
		return consulationRepository.findListDocotorNo(doctorNo);
	}
	
	public Response findByDoctorNo(Long doctorNo) {
		return consulationRepository.findByDoctorNo(doctorNo);
	}



//	public Response update(ConsultationEntity brand) {
//
//		return consulationRepository.update(brand);
//	}
//
//	public Response remove(Long id) {
//		return consulationRepository.remove(id);
//	}
//
//	public Response delete(Long id) {
//
//		return consulationRepository.detele(id);
//	}
//
	
	public Response findByConsultationId(ConsultationEntity reqObj) {
		return consulationRepository.findByConsultationId(reqObj);
	}

//	@Override
//	public Response save(ConsultationEntity brand) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//
	public Response findByHospitalNumber(String hnNumber) {
		return consulationRepository.findByHospitalNumber(hnNumber);
	}
//

//
//	public Response updateByAppointmentNo(Long appointmentNo) {
//		return consulationRepository.updateByAppointmentNo(appointmentNo);
//	}
//	
//	public Response updateByAppointmentNoConsIn(Long appointmentNo) {
//		return consulationRepository.consltInByAppointmentNo(appointmentNo);
//	}

}
