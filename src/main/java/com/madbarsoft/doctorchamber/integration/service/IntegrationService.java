package com.madbarsoft.doctorchamber.integration.service;

import java.util.List;

import com.madbarsoft.doctorchamber.integration.IntegrationEntity;
import com.madbarsoft.doctorchamber.util.Response;

public interface IntegrationService {
	public Response findByConsultationId(Long consultationNo);

	public Response medicinefindByConsultationId(Long consultationNo);

	public Response create(IntegrationEntity integration, Long consDtlNo, String consDtlId);

	public Response delete(IntegrationEntity integration);
	
	public Response deleteAllWithoutItemNo(Long consultationNo);

	public Response createOrUpdate(IntegrationEntity integration, List<IntegrationEntity> integrationEntityList);

	public Response createOrUpdateMedicine(IntegrationEntity integration,
			List<IntegrationEntity> integrationEntityList);

	public Response createMedicine(IntegrationEntity integration, Long consDtlNo, String consDtlId);

	public Response update(IntegrationEntity integration);

	public Long getStampNo();

	public String getStampId();

}
