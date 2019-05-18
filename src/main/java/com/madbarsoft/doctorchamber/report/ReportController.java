package com.madbarsoft.doctorchamber.report;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.core.base.ReportBaseController;
import com.madbarsoft.core.report.CusJasperReportDef;
//import com.mysoft.prescriptionApp.base.BaseController;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/report")
public class ReportController extends ReportBaseController  {

	@Autowired
	ReportService  reportService;

	
	/*@GetMapping(value = "/prescription")
	public ResponseEntity<byte[]> report(@RequestParam("prescriptionId") long id) throws IOException {
		CusJasperReportDef report = reportService.prescription(id);
		return respondReportOutput(report, false);
	}*/
	
	@GetMapping(value = "/prescription")
	public ResponseEntity<byte[]> printPrescription(@RequestParam("prescriptionId") long id,@RequestParam("pClient") String pClient,@RequestParam("pLayout") String pLayout) throws IOException {
		CusJasperReportDef report = reportService.prescription(id,pClient,pLayout);
		return respondReportOutput(report, false);
	}
	
	@GetMapping(value = "/medicalCertificate")
	public ResponseEntity<byte[]> printMedicalCertificate(@RequestParam("certificateId") String certificateId,@RequestParam("doctorNo") Long doctorNo,@RequestParam("reportName") String reportName) throws IOException {
		CusJasperReportDef report = reportService.printMedicalCertificate(certificateId,doctorNo,reportName);
		return respondReportOutput(report, false);
	}
	
	
}
