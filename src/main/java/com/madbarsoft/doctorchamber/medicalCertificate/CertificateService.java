package com.madbarsoft.doctorchamber.medicalCertificate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Mohammad lockman
 *
 */

@Service
public class CertificateService {

	@Autowired
	CertificateRepository certificateRepository;

	public Response getCertificate(String reqObj) {
		return certificateRepository.list(reqObj);
	}

	public Response generateCertificate(String reqObj) {
		return certificateRepository.save(reqObj);
	}

	public Response findByCriteria(String searchCriteria) {
		return certificateRepository.findByCriteria(searchCriteria);
	}
	
	public String getFinialCertificateContent(CertificateEntity certificateEntity) {
		return certificateRepository.getFinialCertificateText(certificateEntity);
	}

}
