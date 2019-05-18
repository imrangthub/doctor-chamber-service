package com.madbarsoft.doctorchamber.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;


@Service
public class PrescriptionService {

	@Autowired
	PrescriptionRepository prescriptionRepository;

	public Response list() {

		return prescriptionRepository.list();
	}

	public Response save(PrescriptionEntity prescription) {

		return prescriptionRepository.save(prescription);
	}
	
	public Response save(String prescription) {

		return prescriptionRepository.save(prescription);
	}

	public Response update(String prescription) {

		return prescriptionRepository.update(prescription);
	}

	public Response remove(Long id) {

		return prescriptionRepository.remove(id);
	}
	public Response delete(Long id) {

		return prescriptionRepository.detele(id);
	}
	
	
	public PrescriptionEntity findById(Long id) {

		return prescriptionRepository.findById(id);
	}
	
	
	public Response findByCriteria(String searchCriteria) {
		
		return prescriptionRepository.findByCriteria(searchCriteria);
	}
	
	
	public Response findOpdConsHistory(String searchCriteria) {
		
		return prescriptionRepository.findOpdConsHistory(searchCriteria);
	}
	
	public Response findPreviousConsulation(String searchCriteria) {
		
		return prescriptionRepository.findPreviousConsulation(searchCriteria);
	}
}
