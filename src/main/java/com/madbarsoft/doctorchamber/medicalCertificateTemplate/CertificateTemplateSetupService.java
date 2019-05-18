package com.madbarsoft.doctorchamber.medicalCertificateTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Mohammad lockman
 *
 */

@Service
public class CertificateTemplateSetupService {
	@Autowired
	CertificateSetupRepository certificateSetupRepository;

	public Response save(String certificate) {
		return certificateSetupRepository.save(certificate);
	}

	public Response list(String reqObj) {
		return certificateSetupRepository.list(reqObj);
	}

	public Response updateDefultTemplate(String reqObj) {

		return certificateSetupRepository.updateDefultTemplate(reqObj);
	}

	public Response getAllTag() {
		return certificateSetupRepository.getAllTag();
	}

	public Response delete(Long id) {
		return certificateSetupRepository.delete(id);
	}

}
