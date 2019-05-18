package com.madbarsoft.doctorchamber.shortKey;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class ShortKeyService {

	@Autowired
	private ShortKeyRepository shortKeyRepository;

	public Response gridList(HttpServletRequest request) {
		return shortKeyRepository.gridList(request);
	}

	public Response listByDoctorNo(ShortKeyEntity obj) {
		return shortKeyRepository.listByDoctorNo(obj);
	}

	public Response save(ShortKeyEntity obj) {
		return shortKeyRepository.save(obj);
	}

	public Response update(ShortKeyEntity diagnosis) {
		return shortKeyRepository.update(diagnosis);
	}

	public Response delete(Long id) {
		return shortKeyRepository.detele(id);
	}

}
