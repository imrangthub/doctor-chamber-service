package com.madbarsoft.doctorchamber.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.authentication.service.AuthService;
import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Md. Jahurul Islam
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping("/login")
	public Response login(@RequestBody UserEntity reqObj) {
		return authService.login(reqObj);
	}

}
