package com.madbarsoft.doctorchamber.presReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/presReport")
public class PresReportController {

	@Autowired
	private PresReportService presReportService;

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestBody(required = false) PresReportEntity reqObj) {
		return presReportService.listByDoctorNo(reqObj);
	}

}
