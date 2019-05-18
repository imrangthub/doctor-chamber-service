package com.madbarsoft.doctorchamber.investigationResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/lab-nonlab-report")
public class LabNonLabReportController {

	@Autowired
	LabNonLabReportService labNonLabReportService;

	@PostMapping("/labReportList")
	public Response labReportList(@RequestParam("hnNumber") String hnNumber) {
		return labNonLabReportService.labReportList(hnNumber);
	}

	@PostMapping("/nonLabReportList")
	public Response nonLabReportList(@RequestParam("hnNumber") String hnNumber) {
		return labNonLabReportService.nonLabReportList(hnNumber);
	}

	@PostMapping("/labInvestigationDetailList")
	public Response labInvestigationDetailList(@RequestParam("regNumber") Long regNumber,
			@RequestParam("itemNo") Long itemNo) {
		return labNonLabReportService.labInvestigationDetailList(regNumber, itemNo);
	}

	@PostMapping("/nonLabInvestigationDetailList")
	public Response nonLabInvestigationDetailList(@RequestParam("invoiceNo") Long invoiceNo,
			@RequestParam("itemNo") Long itemNo) {
		return labNonLabReportService.nonLabInvestigationDetailList(invoiceNo, itemNo);
	}

}
