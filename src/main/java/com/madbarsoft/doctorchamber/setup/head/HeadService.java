package com.madbarsoft.doctorchamber.setup.head;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class HeadService {

	@Autowired
	HeadRepository headRepository;

	public Response gridList(HttpServletRequest request) {
		return headRepository.gridList(request);
	}

	public Response listByDoctorNo(HeadEntity obj) {
		return headRepository.listByDoctorNo(obj);
	}

	public Response listByDoctorNo(Long doctorNo) {
		return headRepository.listByDoctorNo(doctorNo);
	}
	
	public Response save(HeadEntity obj) {
		return headRepository.save(obj);
	}

	public Response update(HeadEntity diagnosis) {
		return headRepository.update(diagnosis);
	}
	
	public Response saveOrupdate(HeadEntity diagnosis) {
		return headRepository.saveOrupdate(diagnosis);
	}

	public Response delete(Long id) {
		return headRepository.detele(id);
	}

}
