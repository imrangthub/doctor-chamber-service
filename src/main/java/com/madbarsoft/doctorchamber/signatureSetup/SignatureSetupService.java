package com.madbarsoft.doctorchamber.signatureSetup;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class SignatureSetupService {

	@Autowired
	private SignatureSetupRepository signatureSetupRepository;

	public Response gridList(HttpServletRequest request) {
		return signatureSetupRepository.gridList(request);
	}

	public Response listByDoctorNo(SignatureSetupEntity obj) {
		return signatureSetupRepository.listByDoctorNo(obj);
	}

	public Response save(SignatureSetupEntity obj) {
		return signatureSetupRepository.save(obj);
	}

	public Response update(SignatureSetupEntity diagnosis) {
		return signatureSetupRepository.update(diagnosis);
	}

	public Response delete(Long id) {
		return signatureSetupRepository.detele(id);
	}

}
