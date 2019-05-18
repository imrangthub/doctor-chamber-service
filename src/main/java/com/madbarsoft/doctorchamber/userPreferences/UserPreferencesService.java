package com.madbarsoft.doctorchamber.userPreferences;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class UserPreferencesService {

	@Autowired
	private UserPreferencesRepository userPreferencesRepository;

	public Response gridList(HttpServletRequest request) {
		return userPreferencesRepository.gridList(request);
	}

	public Response listByDoctorNo(Long userNo) {
		return userPreferencesRepository.listByDoctorNo(userNo);
	}

	public Response save(String userPref) {
		return userPreferencesRepository.save(userPref);
	}

	public Response update(UserPreferencesEntity obj) {
		return userPreferencesRepository.update(obj);
	}

	public Response delete(Long id) {
		return userPreferencesRepository.detele(id);
	}
	
	public UserPreferencesEntity  getPreferenceByDoctorNoAndKey(Long userNo, String preferenceKye) {
		return userPreferencesRepository.getPreferenceByDoctorNoAndKey(userNo,preferenceKye);
	}
	
	public List<UserPreferencesEntity>  getPreferenceByDoctorNo(Long userNo) {
		return userPreferencesRepository.getPreferenceByDoctorNo(userNo);
	}
	
	public UserPreferencesEntity getPreferenceByKey(List<UserPreferencesEntity> preferenceList, String preferenceKey) {
		return userPreferencesRepository.getPreferenceByKey(preferenceList,preferenceKey);
	}
}
