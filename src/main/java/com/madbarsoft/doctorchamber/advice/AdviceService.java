package com.madbarsoft.doctorchamber.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class AdviceService {

	@Autowired
	private AdviceRepository adviceRepository;

	public Response gridList(HttpServletRequest request) {
		return adviceRepository.gridList(request);
	}

	public Response listByDoctorNo(AdviceEntity obj) {
		return adviceRepository.listByDoctorNo(obj);
	}

	public Response save(AdviceEntity obj) {
		return adviceRepository.save(obj);
	}

	public Response update(AdviceEntity diagnosis) {
		return adviceRepository.update(diagnosis);
	}

	public Response delete(Long id) {
		return adviceRepository.detele(id);
	}

}


