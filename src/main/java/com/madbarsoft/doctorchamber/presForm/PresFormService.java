package com.madbarsoft.doctorchamber.presForm;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class PresFormService {

	@Autowired
	private PresFormRepository presFormRepository;

	public Response gridList(HttpServletRequest request) {
		return presFormRepository.gridList(request);
	}

	public Response listByDoctorNo(PresFormEntity obj) {
		return presFormRepository.listByDoctorNo(obj);
	}

	public Response save(PresFormEntity obj) {
		return presFormRepository.save(obj);
	}

	public Response update(PresFormEntity diagnosis) {
		return presFormRepository.update(diagnosis);
	}

	public Response delete(Long id) {
		return presFormRepository.detele(id);
	}

}
