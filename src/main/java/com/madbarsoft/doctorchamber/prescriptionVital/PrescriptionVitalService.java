package com.madbarsoft.doctorchamber.prescriptionVital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.note.NoteEntity;
import com.madbarsoft.doctorchamber.note.NoteRepository;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.prescriptionDetails.PrescriptionDetailsEntity;
import com.madbarsoft.doctorchamber.util.Response;


@Service
public class PrescriptionVitalService {

	@Autowired
	PrescriptionVitalRepository prescriptionVitalRepository;

	public Response list() {
		return prescriptionVitalRepository.list();
	}

	public Response save(PrescriptionVitalEntity prescriptionVital) {
		return prescriptionVitalRepository.save(prescriptionVital);
	}

	public Response update(PrescriptionVitalEntity prescriptionVital) {
		return prescriptionVitalRepository.update(prescriptionVital);
	}

	public Response remove(Long id) {
		return prescriptionVitalRepository.remove(id);
	}
	
	public Response delete(Long id) {
		return prescriptionVitalRepository.detele(id);
	}
	
	public List<PrescriptionVitalEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		return prescriptionVitalRepository.getListFindByPrescriptionId(id);
	}
	
	public List<PrescriptionVitalEntity> getListFindByPrescriptionIdAndDocorId(PrescriptionEntity id,Long doctorNo) {
		return prescriptionVitalRepository.presVitalEntityListWithDoctorPreferenceOder(id,doctorNo);
	}
}
