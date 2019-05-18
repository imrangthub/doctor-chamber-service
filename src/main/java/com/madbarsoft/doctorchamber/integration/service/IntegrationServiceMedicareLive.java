/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madbarsoft.doctorchamber.integration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.madbarsoft.doctorchamber.integration.IntegrationEntity;
import com.madbarsoft.doctorchamber.integration.repository.IntegrationRepositoryMedicareLive;
import com.madbarsoft.doctorchamber.util.Response;

/**
 *
 * @author User
 */
public class IntegrationServiceMedicareLive implements IntegrationService {

	@Autowired
	IntegrationRepositoryMedicareLive integrationRepository;

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
