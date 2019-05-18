package com.madbarsoft.doctorchamber.authentication.service;

import com.madbarsoft.doctorchamber.authentication.UserEntity;
import com.madbarsoft.doctorchamber.util.Response;

public interface AuthService {
	
	public Response login(UserEntity user);
	public Response oncologyLogin(UserEntity user);
	
}
