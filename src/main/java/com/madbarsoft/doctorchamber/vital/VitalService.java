package com.madbarsoft.doctorchamber.vital;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;


/**
 * @author Md. Jahurul Islam
 *
 */
@Service
public class VitalService {

@Autowired
VitalRepository vitalRepository;



public Response gridList(HttpServletRequest request) {
	  return vitalRepository.gridList(request);
}


  public Response list(VitalEntity reqObj) {
	  
	  return vitalRepository.list(reqObj);
  }
	
  public Response save(VitalEntity vital) {
	  
	  return vitalRepository.save(vital);
  }
  
  
  public Response update(VitalEntity vital) {
	  return vitalRepository.update(vital);
  }
  
  public Response delete(Long id) {
	  
	  return vitalRepository.detele(id);
  }
}
