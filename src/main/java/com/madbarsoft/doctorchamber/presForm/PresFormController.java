package com.madbarsoft.doctorchamber.presForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/presForm")
public class PresFormController {

	@Autowired
	private PresFormService presFormService;

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestBody(required = false) PresFormEntity reqObj) {
		return presFormService.listByDoctorNo(reqObj);
	}

}
