package com.madbarsoft.doctorchamber.chiefComplain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class ChiefComplainService {

	@Autowired
	private ChiefComplainRepository chiefComRepository;
	

	public Response gridList(HttpServletRequest request) {
	
		return chiefComRepository.gridList(request);

	}

	public Response listByDoctorNo(ChiefComplainEntity obj) {
		return chiefComRepository.listByDoctorNo(obj);
	}
	
	public Response save(ChiefComplainEntity obj) {
		return chiefComRepository.save(obj);
	}
	
	public Response update(ChiefComplainEntity diagnosis) {
		return chiefComRepository.update(diagnosis);
	}
	
	public Response delete(Long id) {
		return chiefComRepository.detele(id);
	}

}
