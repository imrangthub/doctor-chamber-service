package com.madbarsoft.doctorchamber.referalDoctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Mohammad lockman
 *
 */

@Service
public class ReferalDoctorService {
	@Autowired
	ReferalDoctorRepository certificateSetupRepository;

	public Response save(String referal) {
		return certificateSetupRepository.save(referal);
	}

	public Response list(String reqObj) {
		return certificateSetupRepository.list(reqObj);
	}

	public Response updateDefultTemplate(String reqObj) {

		return certificateSetupRepository.updateDefultTemplate(reqObj);
	}

	public Response delete(Long id) {
		return certificateSetupRepository.delete(id);
	}

}
