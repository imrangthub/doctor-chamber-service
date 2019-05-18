package com.madbarsoft.doctorchamber.medicalCertificate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/api/medicalCertificate")
public class MedicalCertificateController {

	@Autowired
	CertificateService CertificateService;

	@PostMapping("/list")
	public Response getCertificate(@RequestBody(required = false) String reqObj) {
		return CertificateService.getCertificate(reqObj);
	}

	@PostMapping("/search")
	public Response findByCriteria(@RequestBody String searchCriteria) {
		return CertificateService.findByCriteria(searchCriteria);
	}

	@PostMapping("/create")
	public Response create(@RequestBody String reqObj) {
		return CertificateService.generateCertificate(reqObj);
	}

}
