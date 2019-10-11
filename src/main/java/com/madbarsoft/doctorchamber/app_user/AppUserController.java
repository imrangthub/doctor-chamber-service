package com.madbarsoft.doctorchamber.app_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/app_user")
public class AppUserController {

	@Autowired
	private AppUserService doctorWisePscripService;

	@GetMapping("/list")
	public Response getEmplist(@RequestBody(required = false) AppUserEntity reqObj) {
		return doctorWisePscripService.list(reqObj);
	}

	@PostMapping("/list")
	public Response list(@RequestBody(required = false) AppUserEntity reqObj) {
		return doctorWisePscripService.list(reqObj);
	}

}
