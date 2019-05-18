package com.madbarsoft.doctorchamber.prescriptionHistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.util.Response;

@Service
public class PrescriptionHistoryService {

	@Autowired
	private PrescriptionHistoryRepository historyPrescriptionDataRepository;

	public Response list() {
		return historyPrescriptionDataRepository.list();
	}

	public Response save(PrescriptionHistoryEntity historyPrescriptionDataEntity) {
		return historyPrescriptionDataRepository.save(historyPrescriptionDataEntity);
	}

	public Response update(PrescriptionHistoryEntity historyPrescriptionDataEntity) {
		return historyPrescriptionDataRepository.update(historyPrescriptionDataEntity);
	}

	public Response remove(Long id) {
		return historyPrescriptionDataRepository.remove(id);
	}

	public Response delete(Long id) {
		return historyPrescriptionDataRepository.detele(id);
	}

	public List<PrescriptionHistoryEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		return historyPrescriptionDataRepository.getListFindByPrescriptionId(id);
	}
}
