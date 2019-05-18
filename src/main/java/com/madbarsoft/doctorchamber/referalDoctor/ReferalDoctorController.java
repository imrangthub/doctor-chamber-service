package com.madbarsoft.doctorchamber.referalDoctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Mohammad lockman
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/referalDoctor")
public class ReferalDoctorController {

	@Autowired
	ReferalDoctorService referalDoctorService;

	@PostMapping("/create")
	public Response create(@RequestBody String reqObj) {
		return referalDoctorService.save(reqObj);
	}

	@PutMapping("/update")
	public Response updateDefultTemplate(@RequestBody String reqObj) {
		return referalDoctorService.updateDefultTemplate(reqObj);
	}
	
	@PostMapping("/delete")
	public Response delete(@RequestBody Long id) {
		return referalDoctorService.delete(id);
	}

	@PostMapping("/list")
	public Response getAll(@RequestBody(required = false) String reqObj) {
		return referalDoctorService.list(reqObj);
	}



}
