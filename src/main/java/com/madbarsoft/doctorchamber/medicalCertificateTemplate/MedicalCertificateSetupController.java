package com.madbarsoft.doctorchamber.medicalCertificateTemplate;

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
@RequestMapping("/api/medicalCertificateTemplate")
public class MedicalCertificateSetupController {

	@Autowired
	CertificateTemplateSetupService certificateTemplateSetupService;

	@PostMapping("/create")
	public Response create(@RequestBody String reqObj) {
		return certificateTemplateSetupService.save(reqObj);
	}

	@PutMapping("/update")
	public Response updateDefultTemplate(@RequestBody String reqObj) {
		return certificateTemplateSetupService.updateDefultTemplate(reqObj);
	}
	
	@PostMapping("/delete")
	public Response delete(@RequestBody Long id) {
		return certificateTemplateSetupService.delete(id);
	}

	@PostMapping("/list")
	public Response getAll(@RequestBody(required = false) String reqObj) {
		return certificateTemplateSetupService.list(reqObj);
	}

	@GetMapping("tag/list")
	public Response getAllTag() {
		return certificateTemplateSetupService.getAllTag();
	}

}
