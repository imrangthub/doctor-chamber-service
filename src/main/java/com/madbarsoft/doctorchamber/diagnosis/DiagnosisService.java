package com.madbarsoft.doctorchamber.diagnosis;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.chiefComplain.ChiefComplainEntity;
import com.madbarsoft.doctorchamber.util.Def;
import com.madbarsoft.doctorchamber.util.Response;


@Service
public class DiagnosisService {
	
	@Autowired
	DiagnosisRepository diagnosisRepository;
	
	
	public Response gridList(HttpServletRequest request) {
		return diagnosisRepository.gridList(request);
	}
	  
	  public Response listByDoctorNo(DiagnosisEntity obj) {
		  return diagnosisRepository.listByDoctorNo(obj);
	  }
		
	  public Response save(DiagnosisEntity diagnosis) {
		  
		  return diagnosisRepository.save(diagnosis);
	  }
	  
	  
	  public Response update(DiagnosisEntity diagnosis) {
		  
		  return diagnosisRepository.update(diagnosis);
	  }
	  
	  public Response delete(Long id) {
		  
		  return diagnosisRepository.detele(id);
	  }
	
}
