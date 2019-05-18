package com.madbarsoft.doctorchamber.prescriptionAllNotes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.util.Response;

@Service
public class PrescriptionAllNotesService {

	@Autowired
	PrescriptionAllNotesRepository prescriptionAllNotesRepository;

	public Response list() {

		return prescriptionAllNotesRepository.list();
	}

	public Response save(PrescriptionAllNotesEntity prescriptionDetails) {

		return prescriptionAllNotesRepository.save(prescriptionDetails);
	}

	public Response update(PrescriptionAllNotesEntity prescriptionDetails) {

		return prescriptionAllNotesRepository.update(prescriptionDetails);
	}

	public Response remove(Long id) {

		return prescriptionAllNotesRepository.remove(id);
	}
	
	public Response delete(Long id) {

		return prescriptionAllNotesRepository.detele(id);
	}	
	
	public List<PrescriptionAllNotesEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		
		return prescriptionAllNotesRepository.getListFindByPrescriptionId(id);
	}
	
    public PrescriptionAllNotesEntity getListFindByNotesDataType(List<PrescriptionAllNotesEntity> noteList,int notesDataType) {
		
		return prescriptionAllNotesRepository.getListFindByNotesDataType(noteList,notesDataType);
	}
    
    public PrescriptionAllNotesEntity getListFindByNotesDataType(PrescriptionEntity id,int notesDataType) {
		
  		return prescriptionAllNotesRepository.getListFindByNotesDataType(id,notesDataType);
  	}
}
