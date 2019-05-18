/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madbarsoft.doctorchamber.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.madbarsoft.core.report.CusJasperReportDef;

/**
 * @author Md. Jahurul Islam
 *
 */
@Service
public class ReportService {

	@Autowired
	ReportRepository reportRepository;

	public CusJasperReportDef prescription(long id) {

		return null; // reportRepository.prescription(id);
	}

	public CusJasperReportDef prescription(long id, String pClient, String pLayout) {

		return reportRepository.prescription(id, pClient, pLayout);
	}

	public CusJasperReportDef printMedicalCertificate(String certificateId, Long doctorNo,String reportName) {		
		return reportRepository.printMedicalCertificate( certificateId,  doctorNo,reportName);
	}

}
