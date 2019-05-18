package com.madbarsoft.doctorchamber.prescriptionPhysicalExam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.note.NoteEntity;
import com.madbarsoft.doctorchamber.note.NoteRepository;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.prescriptionDetails.PrescriptionDetailsEntity;
import com.madbarsoft.doctorchamber.util.Response;


@Service
public class PrescriptionPhysicalExamService {

	@Autowired
	PrescriptionPhysicalExamRepository prescriptionVitalRepository;

	public Response list() {
		return prescriptionVitalRepository.list();
	}

	public Response save(PrescriptionPhysicalExamEntity prescriptionPhysicalExam) {
		return prescriptionVitalRepository.save(prescriptionPhysicalExam);
	}

	public Response update(PrescriptionPhysicalExamEntity prescriptionPhysicalExam) {
		return prescriptionVitalRepository.update(prescriptionPhysicalExam);
	}

	public Response remove(Long id) {
		return prescriptionVitalRepository.remove(id);
	}
	
	public Response delete(Long id) {
		return prescriptionVitalRepository.detele(id);
	}
	
	public List<PrescriptionPhysicalExamEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		return prescriptionVitalRepository.getListFindByPrescriptionId(id);
	}
}
