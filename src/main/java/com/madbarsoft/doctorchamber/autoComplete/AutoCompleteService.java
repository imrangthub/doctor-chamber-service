package com.madbarsoft.doctorchamber.autoComplete;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class AutoCompleteService {

	@Autowired
	private AutoCompleteRepository autoCompleteRepository;

	public Response gridList(HttpServletRequest request) {
		return autoCompleteRepository.gridList(request);
	}

	public Response listByDoctorNo(AutoCompleteEntity obj) {
		return autoCompleteRepository.listByDoctorNo(obj);
	}

	public Response save(AutoCompleteEntity obj) {
		return autoCompleteRepository.save(obj);
	}

	public Response update(AutoCompleteEntity diagnosis) {
		return autoCompleteRepository.update(diagnosis);
	}

	public Response delete(Long id) {
		return autoCompleteRepository.detele(id);
	}

}
