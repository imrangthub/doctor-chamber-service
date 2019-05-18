package com.madbarsoft.doctorchamber.prescriptionMedicine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.note.NoteEntity;
import com.madbarsoft.doctorchamber.note.NoteRepository;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.prescriptionDetails.PrescriptionDetailsEntity;
import com.madbarsoft.doctorchamber.util.Response;


@Service
public class PrescriptionMedicineService {

	@Autowired
	PrescriptionMedicineRepository prescriptionRepository;

	public Response list() {

		return prescriptionRepository.list();
	}

	public Response save(PrescriptionMedicineEntity prescriptionDetails) {

		return prescriptionRepository.save(prescriptionDetails);
	}

	public Response update(PrescriptionMedicineEntity prescriptionDetails) {

		return prescriptionRepository.update(prescriptionDetails);
	}

	public Response remove(Long id) {

		return prescriptionRepository.remove(id);
	}
	public Response delete(Long id) {

		return prescriptionRepository.detele(id);
	}
	
	
	public List<PrescriptionMedicineEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		
		return prescriptionRepository.getListFindByPrescriptionId(id);
	}
}
