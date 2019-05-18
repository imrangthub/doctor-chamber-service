package com.madbarsoft.doctorchamber.investigation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;


@Service
public class InvestigationService {


	@Autowired
	InvestigationRepository investigationRepository;
	
	public Response gridList(HttpServletRequest request) {
		return investigationRepository.list(new InvestigationEntity());
	}

	  public Response list(InvestigationEntity investigationEntity) {  
		  return investigationRepository.list(investigationEntity);
	  }
		
	  public Response save(InvestigationEntity investigationEntity) {
		  
		  return investigationRepository.save(investigationEntity);
	  }
	  
	  
	  public Response update(InvestigationEntity investigationEntity) {
		  
		  return investigationRepository.update(investigationEntity);
	  }
	  
	  public Response delete(Long id) {
		  
		  return investigationRepository.detele(id);
	  }
}
