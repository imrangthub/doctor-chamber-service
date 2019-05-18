package com.madbarsoft.doctorchamber.prescriptionDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.util.Response;


@Service
public class PrescriptionDetailsService {

	@Autowired
	PrescriptionDetailsRepository prescriptionRepository;

	public Response list() {

		return prescriptionRepository.list();
	}

	public Response save(PrescriptionDetailsEntity prescriptionDetails) {

		return prescriptionRepository.save(prescriptionDetails);
	}

	public Response update(PrescriptionDetailsEntity prescriptionDetails) {

		return prescriptionRepository.update(prescriptionDetails);
	}

	public Response remove(Long id) {

		return prescriptionRepository.remove(id);
	}
	
	public Response delete(Long id) {

		return prescriptionRepository.detele(id);
	}
	
	
	public List<PrescriptionDetailsEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		
		return prescriptionRepository.getListFindByPrescriptionId(id);
	}
	
	public List<PrescriptionDetailsEntity> getDetailsListByDataType(List<PrescriptionDetailsEntity> pdList ,int prescritionDataType) {
		
		return prescriptionRepository.getDetailsListByDataType(pdList,prescritionDataType);
	}
	
	public PrescriptionDetailsEntity getDetailsByDataType(List<PrescriptionDetailsEntity> pdList ,int prescritionDataType) {
		
		return prescriptionRepository.getDetailsByDataType(pdList,prescritionDataType);
	}
	

	
}
