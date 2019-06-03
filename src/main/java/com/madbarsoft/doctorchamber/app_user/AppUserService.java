package com.madbarsoft.doctorchamber.app_user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class AppUserService {

	@Autowired
	private AppUserRepository appUserRepository;

	public Response list(AppUserEntity obj) {
		return appUserRepository.list(obj);
	}
	

}
