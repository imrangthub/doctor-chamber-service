package com.madbarsoft.doctorchamber.prescriptionFinalize;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.util.Response;

@Service
public class PrescriptionFinalizeService {

	@Autowired
	private PrescriptionFinalizeRepository prescriptionFinalizeRepository;

	public Response list() {
		return prescriptionFinalizeRepository.list();
	}

	public Response save(PrescriptionFinalizeEntity prescriptionFinalizeEntity) {
		return prescriptionFinalizeRepository.save(prescriptionFinalizeEntity);
	}

	public Response update(PrescriptionFinalizeEntity prescriptionFinalizeEntity) {
		return prescriptionFinalizeRepository.update(prescriptionFinalizeEntity);
	}

	public Response remove(Long id) {
		return prescriptionFinalizeRepository.remove(id);
	}

	public Response delete(Long id) {
		return prescriptionFinalizeRepository.detele(id);
	}

	public List<PrescriptionFinalizeEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		return prescriptionFinalizeRepository.getListFindByPrescriptionId(id);
	}
	
	
}
