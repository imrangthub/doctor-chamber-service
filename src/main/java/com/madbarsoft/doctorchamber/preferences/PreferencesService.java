package com.madbarsoft.doctorchamber.preferences;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class PreferencesService {

	@Autowired
	private PreferencesRepository preferencesRepository;

	public Response gridList(HttpServletRequest request) {
		return preferencesRepository.gridList(request);
	}
	
	public Response listByDoctorNo(String userNo) {
		return preferencesRepository.listByDoctorNo(userNo);
	}

/*	public Response listByDoctorNo(PrescriptionPreferencesEntity obj) {
		return preferencesRepository.listByDoctorNo(obj);
	}*/

	public Response save(PreferencesEntity obj) {
		return preferencesRepository.save(obj);
	}

	public Response update(PreferencesEntity obj) {
		return preferencesRepository.update(obj);
	}

	public Response delete(Long id) {
		return preferencesRepository.detele(id);
	}

}
