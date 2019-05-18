package com.madbarsoft.doctorchamber.physicalExamination;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;


/**
 * @author Md. Jahurul Islam
 *
 */
@Service
public class PhysicalExaminationService {

@Autowired
PhysicalExaminationRepository physicalExamRepository;



public Response gridList(HttpServletRequest request) {
	  return physicalExamRepository.gridList(request);
}


  public Response list(PhysicalExaminationEntity reqObj) {
	  
	  return physicalExamRepository.list(reqObj);
  }
	
  public Response save(PhysicalExaminationEntity vital) {
	  
	  return physicalExamRepository.save(vital);
  }
  
  
  public Response update(PhysicalExaminationEntity vital) {
	  return physicalExamRepository.update(vital);
  }
  
  public Response delete(Long id) {
	  
	  return physicalExamRepository.detele(id);
  }
}
