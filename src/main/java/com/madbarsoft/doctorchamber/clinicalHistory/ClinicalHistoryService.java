package com.madbarsoft.doctorchamber.clinicalHistory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class ClinicalHistoryService {

	@Autowired
	private ClinicalHistoryRepository clinicalHistoryRepository;
	

	public Response gridList(HttpServletRequest request) {
	
		return clinicalHistoryRepository.gridList(request);

	}

	public Response listByDoctorNo(ClinicalHistoryEntity obj) {
		return clinicalHistoryRepository.listByDoctorNo(obj);
	}
	
	public Response save(ClinicalHistoryEntity obj) {
		return clinicalHistoryRepository.save(obj);
	}
	
	public Response update(ClinicalHistoryEntity diagnosis) {
		return clinicalHistoryRepository.update(diagnosis);
	}
	
	public Response delete(Long id) {
		return clinicalHistoryRepository.detele(id);
	}

}
