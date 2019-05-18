package com.madbarsoft.doctorchamber.userDataPreferences;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class UserDataPreferencesService {

	@Autowired
	private UserDataPreferencesRepository userDataPreferencesRepository;

	public Response gridList(HttpServletRequest request) {
		return userDataPreferencesRepository.gridList(request);
	}

	public Response listByDoctorNo(Long userNo) {
		return userDataPreferencesRepository.listByDoctorNo(userNo);
	}

	public Response save(UserDataPreferencesEntity obj) {
		return userDataPreferencesRepository.save(obj);
	}

	public Response update(UserDataPreferencesEntity obj) {
		return userDataPreferencesRepository.update(obj);
	}

	public Response delete(Long id) {
		return userDataPreferencesRepository.detele(id);
	}
}
