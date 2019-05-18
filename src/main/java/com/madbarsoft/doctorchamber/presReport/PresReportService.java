package com.madbarsoft.doctorchamber.presReport;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class PresReportService {

	@Autowired
	private PresReportRepository presTemplateRepository;

	public Response gridList(HttpServletRequest request) {
		return presTemplateRepository.gridList(request);
	}

	public Response listByDoctorNo(PresReportEntity obj) {
		return presTemplateRepository.listByDoctorNo(obj);
	}

	public Response save(PresReportEntity obj) {
		return presTemplateRepository.save(obj);
	}

	public Response update(PresReportEntity diagnosis) {
		return presTemplateRepository.update(diagnosis);
	}

	public Response delete(Long id) {
		return presTemplateRepository.detele(id);
	}

}

