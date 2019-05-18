package com.madbarsoft.doctorchamber.integration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.madbarsoft.doctorchamber.integration.IntegrationEntity;
import com.madbarsoft.doctorchamber.integration.repository.IntegrationRepositoryMedicareNew;
import com.madbarsoft.doctorchamber.util.Response;

public class IntegrationServiceMedicareNew implements IntegrationService {

	@Autowired
	IntegrationRepositoryMedicareNew integrationRepository;

	public Response findByConsultationId(Long consultationNo) {
		return integrationRepository.findByConsultationId(consultationNo);
	}

	public Response medicinefindByConsultationId(Long consultationNo) {
		return integrationRepository.medicinefindByConsultationId(consultationNo);
	}

	public Response create(IntegrationEntity integration, Long consDtlNo, String consDtlId) {
		return integrationRepository.create(integration);
	}

	public Response delete(IntegrationEntity integration) {
		return integrationRepository.delete(integration);
	}
	
	public Response deleteAllWithoutItemNo(Long consultationNo) {
		return integrationRepository.deleteAllWithoutItemNo(consultationNo);
	}

	public Response createOrUpdate(IntegrationEntity integration, List<IntegrationEntity> integrationEntityList) {
		return integrationRepository.createOrUpdate(integration, integrationEntityList);
	}

	public Response createOrUpdateMedicine(IntegrationEntity integration,
			List<IntegrationEntity> integrationEntityList) {
		return integrationRepository.createOrUpdateMedicine(integration, integrationEntityList);
	}

	public Response createMedicine(IntegrationEntity integration, Long consDtlNo, String consDtlId) {
		return integrationRepository.createMedicine(integration);
	}

	public Response update(IntegrationEntity integration) {
		return integrationRepository.update(integration);
	}

	public Long getStampNo() {
		return integrationRepository.getStampNo();
	}

	public String getStampId() {
		return integrationRepository.getStampId();
	}
}
