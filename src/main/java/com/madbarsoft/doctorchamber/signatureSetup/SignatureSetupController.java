package com.madbarsoft.doctorchamber.signatureSetup;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/signatureSetup")
public class SignatureSetupController {

	@Autowired
	private SignatureSetupService signatureSetupService;

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return signatureSetupService.gridList(request);
	}

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestBody(required = false) SignatureSetupEntity reqObj) {
		return signatureSetupService.listByDoctorNo(reqObj);
	}

	@PostMapping("/create")
	public Response create(@RequestBody SignatureSetupEntity reqObj) {
		return signatureSetupService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody SignatureSetupEntity reqObj) {
		return signatureSetupService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("reqId") long reqId) {
		return signatureSetupService.delete(reqId);

	}

}
