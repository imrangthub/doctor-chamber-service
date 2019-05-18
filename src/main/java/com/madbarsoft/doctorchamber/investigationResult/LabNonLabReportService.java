package com.madbarsoft.doctorchamber.investigationResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class LabNonLabReportService {

	@Autowired
	LabNonLabReportRepository labNonLabReportRepository;

	public Response labReportList(String hnNumber) {
		return labNonLabReportRepository.labReportList(hnNumber);
	}

	public Response nonLabReportList(String hnNumber) {
		return labNonLabReportRepository.nonLabReportList(hnNumber);
	}

	public Response labInvestigationDetailList(long regNumber, long itemNo) {
		return labNonLabReportRepository.labInvestigationDetailList(regNumber, itemNo);
	}

	public Response nonLabInvestigationDetailList(long invoiceNo, long itemNo) {
		return labNonLabReportRepository.nonLabInvestigationDetailList(invoiceNo, itemNo);
	}

}
