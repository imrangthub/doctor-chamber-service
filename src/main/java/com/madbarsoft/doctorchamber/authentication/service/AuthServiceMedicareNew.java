package com.madbarsoft.doctorchamber.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.madbarsoft.doctorchamber.authentication.UserEntity;
import com.madbarsoft.doctorchamber.authentication.repository.AuthRepositoryMedicareNew;
import com.madbarsoft.doctorchamber.util.Response;

public class AuthServiceMedicareNew implements AuthService {

	@Autowired
	AuthRepositoryMedicareNew authRepository;

	
	
	public Response login(UserEntity user) {
		return authRepository.login(user);

	}

	@Override
	public Response oncologyLogin(UserEntity user) {
		return authRepository.oncologyLogin(user);
	}

}
