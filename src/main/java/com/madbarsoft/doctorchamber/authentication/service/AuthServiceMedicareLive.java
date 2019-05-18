package com.madbarsoft.doctorchamber.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.madbarsoft.doctorchamber.authentication.UserEntity;
import com.madbarsoft.doctorchamber.authentication.repository.AuthRepositoryMedicareLive;
import com.madbarsoft.doctorchamber.userPreferences.UserPreferencesService;
import com.madbarsoft.doctorchamber.util.Response;

public class AuthServiceMedicareLive implements AuthService {

	@Autowired
	AuthRepositoryMedicareLive authRepository;
	
	
	
	@Override
	public Response login(UserEntity user) {
		return authRepository.login(user);

	}
	
	@Override
	public Response oncologyLogin(UserEntity user) {
		return authRepository.oncologyLogin(user);

	}



}
