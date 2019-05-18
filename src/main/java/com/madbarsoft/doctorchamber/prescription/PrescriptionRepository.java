package com.madbarsoft.doctorchamber.prescription;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.collections.ListUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.consultation.service.ConsultationService;
import com.madbarsoft.doctorchamber.doctorWisePscrip.DoctorWisePscripDto;
import com.madbarsoft.doctorchamber.doctorWisePscrip.DoctorWisePscripService;
import com.madbarsoft.doctorchamber.integration.IntegrationEntity;
import com.madbarsoft.doctorchamber.integration.service.IntegrationService;
import com.madbarsoft.doctorchamber.prescriptionAllNotes.PrescriptionAllNotesEntity;
import com.madbarsoft.doctorchamber.prescriptionAllNotes.PrescriptionAllNotesService;
import com.madbarsoft.doctorchamber.prescriptionDetails.PrescriptionDetailsEntity;
import com.madbarsoft.doctorchamber.prescriptionDetails.PrescriptionDetailsService;
import com.madbarsoft.doctorchamber.prescriptionFinalize.PrescriptionFinalizeEntity;
import com.madbarsoft.doctorchamber.prescriptionFinalize.PrescriptionFinalizeService;
import com.madbarsoft.doctorchamber.prescriptionHistory.PrescriptionHistoryEntity;
import com.madbarsoft.doctorchamber.prescriptionHistory.PrescriptionHistoryService;
import com.madbarsoft.doctorchamber.prescriptionMedicine.PrescriptionMedicineEntity;
import com.madbarsoft.doctorchamber.prescriptionMedicine.PrescriptionMedicineService;
import com.madbarsoft.doctorchamber.prescriptionPhysicalExam.PrescriptionPhysicalExamEntity;
import com.madbarsoft.doctorchamber.prescriptionPhysicalExam.PrescriptionPhysicalExamService;
import com.madbarsoft.doctorchamber.prescriptionVital.PrescriptionVitalEntity;
import com.madbarsoft.doctorchamber.prescriptionVital.PrescriptionVitalService;
import com.madbarsoft.doctorchamber.util.Def;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class PrescriptionRepository extends BaseRepository {

	@Autowired
	private Environment env;
	@Autowired
	PrescriptionDetailsService prescriptionDetailsService;
	@Autowired
	PrescriptionVitalService prescriptionVitalService;
	@Autowired
	PrescriptionMedicineService prescriptionMedicineService;
	@Autowired
	ConsultationService consulationService;
	@Autowired
	IntegrationService integrationService;
	@Autowired
	PrescriptionFinalizeService prescriptionFinalizeService;
	@Autowired
	DoctorWisePscripService doctorWisePscripService;
	@Autowired
	private PrescriptionPhysicalExamService prescriptionPhysicalExamService;
	@Autowired
	PrescriptionAllNotesService prescriptionAllNotesService;
	@Autowired
	private PrescriptionHistoryService historyPrescriptionDataService;


	public Response save(PrescriptionEntity prescriptionEntity) {
		return baseOnlySave(prescriptionEntity);
	}

	public Response save(String prescriptionJson) {
		String integrateInvestigationFlag = env.getProperty("service.integrate.investigation");
		String integrateMedicationFlag = env.getProperty("service.integrate.medication");
		
		boolean flag = true;
		Map<String, Object> data = prescriptiogData(prescriptionJson);

		PrescriptionEntity prescriptionEntity = (PrescriptionEntity) data.get("prescriptionEntity");

		List<PrescriptionDetailsEntity> diagnosisList = getListFromObject(data.get("diagnosisList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> radiologyList = getListFromObject(data.get("radiologyList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> phatologyList = getListFromObject(data.get("phatologyList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionMedicineEntity> medicineList = getListFromObject(data.get("medicineList"),
				PrescriptionMedicineEntity.class);
		List<PrescriptionVitalEntity> vitalList = getListFromObject(data.get("vitalList"),
				PrescriptionVitalEntity.class);
		List<PrescriptionFinalizeEntity> finalizationList = getListFromObject(data.get("finalizationList"),
				PrescriptionFinalizeEntity.class);
		List<PrescriptionPhysicalExamEntity> physicalExamList = getListFromObject(data.get("physicalExamList"),
				PrescriptionPhysicalExamEntity.class);
		List<PrescriptionHistoryEntity> historyList = getListFromObject(data.get("historyList"),
				PrescriptionHistoryEntity.class);
		List<PrescriptionDetailsEntity> noteList = getListFromObject(data.get("noteList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> investigationList = getListFromObject(data.get("investigationList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> chiefComplainList = getListFromObject(data.get("chiefComplainList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> adviceList = getListFromObject(data.get("adviceList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> clinicalHistory2List = getListFromObject(data.get("clinicalHistory2List"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionAllNotesEntity> allNotesList = getListFromObject(data.get("allNotesList"),
				PrescriptionAllNotesEntity.class);
		List<PrescriptionDetailsEntity> refDoctorList = getListFromObject(data.get("refDoctorList"),
				PrescriptionDetailsEntity.class);

		if (prescriptionEntity != null) {

			Response response = baseSaveOrUpdate(prescriptionEntity);

			if (response.isSuccess()) {

				prescriptionEntity = (PrescriptionEntity) response.getObj();
				if (noteList != null) {
					flag = prescriptionDetailsSave(noteList, prescriptionEntity);
				}
				if (vitalList != null && flag) {
					flag = prescriptionVitalSave(vitalList, prescriptionEntity);
				}
				if (finalizationList != null && flag) {
					flag = prescriptionFinalizeSave(finalizationList, prescriptionEntity);
				}
				if (diagnosisList != null && flag) {
					flag = prescriptionDetailsSave(diagnosisList, prescriptionEntity);
				}
				if (physicalExamList != null && flag) {
					flag = prescriptionPhysicalExamSave(physicalExamList, prescriptionEntity);
				}
				if (historyList != null && flag) {
					flag = prescriptionHistorySave(historyList, prescriptionEntity);
				}
				if (radiologyList != null && flag) {
					flag = prescriptionDetailsSave(radiologyList, prescriptionEntity);
				}
				if (phatologyList != null && flag) {
					flag = prescriptionDetailsSave(phatologyList, prescriptionEntity);
				}
				if (medicineList != null && flag) {
					flag = prescriptionMedicineSave(medicineList, prescriptionEntity);
				}
				if (investigationList != null && flag) {
					flag = prescriptionDetailsSave(investigationList, prescriptionEntity);
				}
				if (chiefComplainList != null && flag) {
					flag = prescriptionDetailsSave(chiefComplainList, prescriptionEntity);
				}
				if (adviceList != null && flag) {
					flag = prescriptionDetailsSave(adviceList, prescriptionEntity);
				}
				if (clinicalHistory2List != null && flag) {
					flag = prescriptionDetailsSave(clinicalHistory2List, prescriptionEntity);
				}
				if (allNotesList != null && flag) {
					flag = prescriptionAllNotesSave(allNotesList, prescriptionEntity);
				}
				if (refDoctorList != null && flag) {
					flag = prescriptionDetailsSave(refDoctorList, prescriptionEntity);
				}

			}

			// integration
			if (flag) {

//				if(prescriptionEntity.getIsPatientIn() == 1) {
//					consulationService.updateByAppointmentNoConsIn(prescriptionEntity.getAppointmentNo());
//					System.out.println("Patient In Done.");
//				} else if (prescriptionEntity.getIsPatientOut() == 1) {
//					consulationService.updateByAppointmentNo(prescriptionEntity.getAppointmentNo());
//					System.out.println("Patient Out Done.");					
//				}
				
				
				Long consDtlNo = null;
				String consDtlId = null;
			
				
				if(integrateInvestigationFlag.equals("1") || integrateMedicationFlag.equals("1")) {
					 consDtlNo = integrationService.getStampNo();
					 consDtlId = integrationService.getStampId();
				}
 			 
				 if(integrateInvestigationFlag.equals("1")) {	
						if (radiologyList != null) {
							addOpdConsultationDetail(radiologyList, prescriptionEntity, consDtlNo, consDtlId);
						}
						if (phatologyList != null) {
							addOpdConsultationDetail(phatologyList, prescriptionEntity, consDtlNo, consDtlId);
						}
						if (investigationList != null) {
							addOpdConsultationDetail(investigationList, prescriptionEntity, consDtlNo, consDtlId);
						}
				 }
				 
				 if(integrateMedicationFlag.equals("1")) {

					 if (medicineList != null) {
							addOpdConsultationDetailforMedicine(medicineList, prescriptionEntity, consDtlNo, consDtlId);

						} 
				 }
		
			}
			if(response.isSuccess()) {
				
				Response finalResponse = new Response();
				String getObj =  objectToJson(response.getObj());
				finalResponse = findByCriteria(getObj);
				
				return finalResponse;
			}
			
			return getErrorResponse("save fail");
		}

		return getErrorResponse("save fail");

	}

	@SuppressWarnings("unchecked")
	public Response update(String prescriptionJson) {
	
		String integrateInvestigationFlag = env.getProperty("service.integrate.investigation");
		String integrateMedicationFlag = env.getProperty("service.integrate.medication");
	
		boolean flag = true;
		Map<String, Object> data = prescriptiogData(prescriptionJson);

		PrescriptionEntity prescriptionEntity = getValueFromObject(data.get("prescriptionEntity"),
				PrescriptionEntity.class);
		List<PrescriptionDetailsEntity> diagnosisList = getListFromObject(data.get("diagnosisList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> radiologyList = getListFromObject(data.get("radiologyList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> phatologyList = getListFromObject(data.get("phatologyList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionMedicineEntity> medicineList = getListFromObject(data.get("medicineList"),
				PrescriptionMedicineEntity.class);
		List<PrescriptionVitalEntity> vitalList = getListFromObject(data.get("vitalList"),
				PrescriptionVitalEntity.class);
		List<PrescriptionFinalizeEntity> finalizationList = getListFromObject(data.get("finalizationList"),
				PrescriptionFinalizeEntity.class);
		List<PrescriptionPhysicalExamEntity> physicalExamList = getListFromObject(data.get("physicalExamList"),
				PrescriptionPhysicalExamEntity.class);
		List<PrescriptionHistoryEntity> historyList = getListFromObject(data.get("historyList"),
				PrescriptionHistoryEntity.class);
		List<PrescriptionDetailsEntity> noteList = getListFromObject(data.get("noteList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> investigationList = getListFromObject(data.get("investigationList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> chiefComplainList = getListFromObject(data.get("chiefComplainList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> adviceList = getListFromObject(data.get("adviceList"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionDetailsEntity> clinicalHistory2List = getListFromObject(data.get("clinicalHistory2List"),
				PrescriptionDetailsEntity.class);
		List<PrescriptionAllNotesEntity> allNotesList = getListFromObject(data.get("allNotesList"),
				PrescriptionAllNotesEntity.class);
		List<PrescriptionDetailsEntity> refDoctorList = getListFromObject(data.get("refDoctorList"),
				PrescriptionDetailsEntity.class);

		if (prescriptionEntity != null) {
			
			PrescriptionEntity existenPrescrption =	findById(prescriptionEntity.getId());
			prescriptionEntity.setCreatedDate(existenPrescrption.getCreatedDate());
			
			prescriptionEntity.setModifiedDate(new Date());
			Response response = baseSaveOrUpdate(prescriptionEntity);
			if (response.isSuccess()) {
				prescriptionEntity = (PrescriptionEntity) response.getObj();
				if (noteList != null) {
					prescriptionDetailsUpdateOrDelete(noteList, prescriptionEntity);
				}

				if (noteList != null) {
					flag = prescriptionDetailsUpdateOrDelete(noteList, prescriptionEntity);
				}
				if (vitalList != null && flag) {
					flag = prescriptionVitalOrDelete(vitalList, prescriptionEntity);
				}
				if (finalizationList != null && flag) {
					flag = prescriptionFinalizeUpdateOrDelete(finalizationList, prescriptionEntity);
				}
				if (physicalExamList != null && flag) {
					flag = prescriptionPhysicalExamUpdateOrDelete(physicalExamList, prescriptionEntity);
				}
				if (historyList != null && flag) {
					flag = prescriptionHistoryUpdateOrDelete(historyList, prescriptionEntity);
				}
				if (diagnosisList != null && flag) {
					flag = prescriptionDetailsUpdateOrDelete(diagnosisList, prescriptionEntity);
				}
				if (radiologyList != null && flag) {
					flag = prescriptionDetailsUpdateOrDelete(radiologyList, prescriptionEntity);
				}
				if (phatologyList != null && flag) {
					flag = prescriptionDetailsUpdateOrDelete(phatologyList, prescriptionEntity);
				}
				if (medicineList != null && flag) {
					flag = prescriptionMedicineOrDelete(medicineList, prescriptionEntity);
				}
				if (investigationList != null && flag) {
					flag = prescriptionDetailsUpdateOrDelete(investigationList, prescriptionEntity);
				}
				if (chiefComplainList != null && flag) {
					flag = prescriptionDetailsUpdateOrDelete(chiefComplainList, prescriptionEntity);
				}
				if (adviceList != null && flag) {
					flag = prescriptionDetailsUpdateOrDelete(adviceList, prescriptionEntity);
				}
				if (clinicalHistory2List != null && flag) {
					flag = prescriptionDetailsUpdateOrDelete(clinicalHistory2List, prescriptionEntity);
				}
				if (allNotesList != null && flag) {
					flag = prescriptionAllNotesUpdateOrDelete(allNotesList, prescriptionEntity);
				}
				if (refDoctorList != null && flag) {
					flag = prescriptionDetailsUpdateOrDelete(refDoctorList, prescriptionEntity);
				}
			}

			// integration
			if (flag) {
				
//				if(prescriptionEntity.getIsPatientIn() == 1) {
//					consulationService.updateByAppointmentNoConsIn(prescriptionEntity.getAppointmentNo());
//					System.out.println("Patient In Done.");
//				} else if (prescriptionEntity.getIsPatientOut() == 1) {
//					consulationService.updateByAppointmentNo(prescriptionEntity.getAppointmentNo());
//					System.out.println("Patient Out Done.");					
//				}
				
				integrationService.deleteAllWithoutItemNo(prescriptionEntity.getConsultationNo());
				
				Response integrationResponse = integrationService.findByConsultationId(prescriptionEntity.getConsultationNo());
				List<IntegrationEntity> integrationEntityList = null;
				if (integrationResponse.isSuccess()) {
					integrationEntityList = integrationResponse.getItems();
				}
				
				if (radiologyList != null && integrateInvestigationFlag.equals("1")) {
					editDeleteOpdConsultationDetail(radiologyList, prescriptionEntity, integrationEntityList);

				}

				if (phatologyList != null && integrateInvestigationFlag.equals("1")) {
					editDeleteOpdConsultationDetail(phatologyList, prescriptionEntity, integrationEntityList);

				}

				if (medicineList != null && integrateMedicationFlag.equals("1")) {
					Response integrationMedicineResponse = integrationService.medicinefindByConsultationId(prescriptionEntity.getConsultationNo());
					List<IntegrationEntity> integrationEntityMedicineList = null;
					
					if (integrationResponse.isSuccess()) {
						integrationEntityMedicineList = integrationMedicineResponse.getItems();
					}

					editDeleteOpdConsultationDetailforMedicine(medicineList, prescriptionEntity,integrationEntityMedicineList);

				}
			}
			
			if(response.isSuccess()) {
		
				Response finalResponse = new Response();
				String getObj =  objectToJson(response.getObj());
				finalResponse = findByCriteria(getObj);
				
				return finalResponse;
			}
			
			return getErrorResponse("edit fail");
		}

		return getErrorResponse("edit fail");
	}

	private Map<String, Object> prescriptiogData(String prescriptionJson) {

		JSONObject json = new JSONObject(prescriptionJson);

		PrescriptionEntity prescriptionEntity = null;
		List<PrescriptionDetailsEntity> diagnosisList = null;
		List<PrescriptionDetailsEntity> radiologyList = null;
		List<PrescriptionDetailsEntity> phatologyList = null;
		List<PrescriptionMedicineEntity> medicineList = null;
		List<PrescriptionVitalEntity> vitalList = null;
		List<PrescriptionFinalizeEntity> finalizationList = null;
		List<PrescriptionPhysicalExamEntity> physicalExamList = null;
		List<PrescriptionHistoryEntity> historyList = null;
		List<PrescriptionDetailsEntity> noteList = null;
		List<PrescriptionDetailsEntity> investigationList = null;
		List<PrescriptionDetailsEntity> chiefComplainList = null;
		List<PrescriptionDetailsEntity> adviceList = null;
		List<PrescriptionDetailsEntity> clinicalHistory2List = null;
		List<PrescriptionAllNotesEntity> allNotesList = null;
		List<PrescriptionDetailsEntity> refDoctorList = null;
		String prescriptionStr = Def.getString(json, "prescription");
		String notesStr = Def.getString(json, "note");
		String vitalStr = Def.getArrayString(json, "vitalList");
		String finalizationStr = Def.getArrayString(json, "finalizationList");
		String physicalExamStr = Def.getArrayString(json, "physicalExamList");
		String historyStr = Def.getArrayString(json, "historyList");
		String diagnosisStr = Def.getArrayString(json, "diagnosisList");
		String radiologyStr = Def.getArrayString(json, "radiologyList");
		String phatologyStr = Def.getArrayString(json, "phatologyList");
		String medicineStr = Def.getArrayString(json, "medicineList");
		String investigationStr = Def.getArrayString(json, "investigationList");
		String chiefComplainStr = Def.getArrayString(json, "chiefComplainList");
		String adviceStr = Def.getArrayString(json, "adviceList");
		String clinicalHistory2Str = Def.getArrayString(json, "clinicalHistory2List");
		String allNotesStr = Def.getArrayString(json, "allNotesList");
		String refDoctorListStr = Def.getArrayString(json, "refDoctorList");
		Map<String, Object> prescriptionData = new HashMap<String, Object>();

		if (prescriptionStr != null && !prescriptionStr.equals("{}")) {
			prescriptionEntity = objectMapperReadValue(prescriptionStr, PrescriptionEntity.class);
			if (prescriptionEntity != null) {
				prescriptionData.put("prescriptionEntity", prescriptionEntity);
			}

		}
		if (notesStr != null && !notesStr.equals("{}")) {

			PrescriptionDetailsEntity prescriptionDetailsEntity = objectMapperReadValue(notesStr.toString(),
					PrescriptionDetailsEntity.class);

			if (prescriptionDetailsEntity != null) {
				noteList = new ArrayList<>();
				noteList.add(prescriptionDetailsEntity);
				prescriptionData.put("noteList", noteList);
			}

		}

		if (vitalStr != null && !vitalStr.equals("[]")) {
			vitalList = objectMapperReadArrayValue(vitalStr, PrescriptionVitalEntity.class);
			if (vitalList != null) {
				prescriptionData.put("vitalList", vitalList);
			}
		}
		if (finalizationStr != null && !finalizationStr.equals("[]")) {
			finalizationList = objectMapperReadArrayValue(finalizationStr, PrescriptionFinalizeEntity.class);
			if (finalizationList != null) {
				prescriptionData.put("finalizationList", finalizationList);
			}
		}
		if (physicalExamStr != null && !physicalExamStr.equals("[]")) {
			physicalExamList = objectMapperReadArrayValue(physicalExamStr, PrescriptionPhysicalExamEntity.class);
			if (physicalExamList != null) {
				prescriptionData.put("physicalExamList", physicalExamList);
			}
		}
		if (historyStr != null && !historyStr.equals("[]")) {
			historyList = objectMapperReadArrayValue(historyStr, PrescriptionHistoryEntity.class);
			if (historyList != null) {
				prescriptionData.put("historyList", historyList);
			}
		}
		if (diagnosisStr != null && !diagnosisStr.equals("[]")) {
			diagnosisList = objectMapperReadArrayValue(diagnosisStr, PrescriptionDetailsEntity.class);
			if (diagnosisList != null) {
				prescriptionData.put("diagnosisList", diagnosisList);
			}
		}
		if (radiologyStr != null && !radiologyStr.equals("[]")) {
			radiologyList = objectMapperReadArrayValue(radiologyStr, PrescriptionDetailsEntity.class);
			if (radiologyList != null) {
				prescriptionData.put("radiologyList", radiologyList);
			}

		}
		if (phatologyStr != null && !phatologyStr.equals("[]")) {
			phatologyList = objectMapperReadArrayValue(phatologyStr, PrescriptionDetailsEntity.class);
			if (phatologyList != null) {
				prescriptionData.put("phatologyList", phatologyList);
			}

		}
		if (medicineStr != null && !medicineStr.equals("[]")) {
			medicineList = objectMapperReadArrayValue(medicineStr, PrescriptionMedicineEntity.class);
			if (medicineList != null) {
				prescriptionData.put("medicineList", medicineList);
			}
		}
		if (investigationStr != null && !investigationStr.equals("[]")) {
			investigationList = objectMapperReadArrayValue(investigationStr, PrescriptionDetailsEntity.class);
			if (investigationList != null) {
				prescriptionData.put("investigationList", investigationList);
			}
		}
		if (chiefComplainStr != null && !chiefComplainStr.equals("[]")) {
			chiefComplainList = objectMapperReadArrayValue(chiefComplainStr, PrescriptionDetailsEntity.class);
			if (chiefComplainList != null) {
				prescriptionData.put("chiefComplainList", chiefComplainList);
			}
		}
		if (adviceStr != null && !adviceStr.equals("[]")) {
			adviceList = objectMapperReadArrayValue(adviceStr, PrescriptionDetailsEntity.class);
			if (adviceList != null) {
				prescriptionData.put("adviceList", adviceList);
			}
		}
		if (clinicalHistory2Str != null && !clinicalHistory2Str.equals("[]")) {
			clinicalHistory2List = objectMapperReadArrayValue(clinicalHistory2Str, PrescriptionDetailsEntity.class);
			if (clinicalHistory2List != null) {
				prescriptionData.put("clinicalHistory2List", clinicalHistory2List);
			}
		}
		if (allNotesStr != null && !allNotesStr.equals("[]")) {
			allNotesList = objectMapperReadArrayValue(allNotesStr, PrescriptionAllNotesEntity.class);
			if (allNotesList != null) {
				prescriptionData.put("allNotesList", allNotesList);
			}
		}
		if (refDoctorListStr != null && !refDoctorListStr.equals("[]")) {
			refDoctorList = objectMapperReadArrayValue(refDoctorListStr, PrescriptionDetailsEntity.class);
			if (refDoctorList != null) {
				prescriptionData.put("refDoctorList", refDoctorList);
			}
		}

		return prescriptionData;
	}

	private Response addOpdConsultationDetail(List<PrescriptionDetailsEntity> batch, PrescriptionEntity pres,
			Long consDtlNo, String consDtlId) {
		Response response = null;

		for (PrescriptionDetailsEntity pd : batch) {

			IntegrationEntity integration = new IntegrationEntity();

			integration.setAppointmentNo(pres.getAppointmentNo());
			integration.setItemName(pd.getPrescritionData());
			integration.setItemNo(pd.getReferenceId());
			integration.setItemtypeNo(new Long(pd.getPrescritionDataType()));
			integration.setSubitemtypeNo(new Long(pd.getPrescritionDataType()));
			integration.setItemQty(1);
			integration.setDeliveryStatusNo(0);
			integration.setOpdConsultationNo(pres.getConsultationNo());

			integrationService.create(integration, consDtlNo, consDtlId);
		}

		return response;

	}

	private Response addOpdConsultationDetailforMedicine(List<PrescriptionMedicineEntity> batch,
			PrescriptionEntity pres, Long consDtlNo, String consDtlId) {
		Response response = null;

		for (PrescriptionMedicineEntity pd : batch) {

			IntegrationEntity integration = new IntegrationEntity();

			integration.setAppointmentNo(pres.getAppointmentNo());
			integration.setItemName(pd.getBrandName());
			integration.setItemNo(pd.getItemNo() != null ? new Long(pd.getItemNo()) : null);
			integration.setItemtypeNo(new Long(pd.getPrescritionDataType()));
			integration.setSubitemtypeNo(new Long(pd.getPrescritionDataType()));
			integration.setItemQty(1);
			integration.setMedDuration(pd.getItemQty().isEmpty() || pd.getItemQty() == null|| pd.getItemQty() == "" ? null : new Long(pd.getItemQty()));
			integration.setDeliveryStatusNo(0);
			integration.setOpdConsultationNo(pres.getConsultationNo());
			integration.setMedDose(pd.getDosage());

			integrationService.createMedicine(integration, consDtlNo, consDtlId);	
		}

		return response;

	}

	private Response editDeleteOpdConsultationDetail(List<PrescriptionDetailsEntity> batch, PrescriptionEntity pres,
			List<IntegrationEntity> integrationList) {
		Response response = null;

		for (PrescriptionDetailsEntity pd : batch) {

			IntegrationEntity integration = new IntegrationEntity();

			integration.setAppointmentNo(pres.getAppointmentNo());
			integration.setItemName(pd.getPrescritionData());		
			integration.setItemNo(pd.getReferenceId());
			integration.setItemtypeNo(new Long(pd.getPrescritionDataType()));
			integration.setSubitemtypeNo(new Long(pd.getPrescritionDataType()));
			//integration.setItemQty(null);
			integration.setDeliveryStatusNo(0);
			integration.setOpdConsultationNo(pres.getConsultationNo());

			if (pd.getIsDeleted() != null) {
				integrationService.delete(integration);
			}

			integrationService.createOrUpdate(integration, integrationList);
		}

		return response;

	}

	private Response editDeleteOpdConsultationDetailforMedicine(List<PrescriptionMedicineEntity> batch,
			PrescriptionEntity pres, List<IntegrationEntity> integrationList) {
		Response response = null;

		for (PrescriptionMedicineEntity pd : batch) {
			IntegrationEntity integration = new IntegrationEntity();		
			integration.setAppointmentNo(null);
			integration.setItemName(pd.getBrandName());
			integration.setItemNo(pd.getReferenceId());
			//integration.setItemQty(null);
			integration.setDeliveryStatusNo(0);
			integration.setOpdConsultationNo(pres.getConsultationNo());
			integration.setMedDose(pd.getDosage());

			if (pd.getIsDeleted() != null) {
				integrationService.delete(integration);
			}

			integrationService.createOrUpdateMedicine(integration, integrationList);
		}

		return response;

	}

	private Boolean prescriptionDetailsSave(List<PrescriptionDetailsEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		boolean flag = true;

		for (PrescriptionDetailsEntity pd : batch) {
			pd.setPrescription(pres);
			response = prescriptionDetailsService.save(pd);

			if (!response.isSuccess()) {
				flag = false;
				break;

			}

		}

		return flag;
	}

	private Boolean prescriptionAllNotesSave(List<PrescriptionAllNotesEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		boolean flag = true;

		for (PrescriptionAllNotesEntity pd : batch) {
			pd.setPrescription(pres);
			response = prescriptionAllNotesService.save(pd);

			if (!response.isSuccess()) {
				flag = false;
				break;

			}

		}

		return flag;
	}

	public Response detele(Long id) {

		PrescriptionEntity prescriptionEntity = findById(id);
		return baseDelete(prescriptionEntity);

	}

	public Response remove(Long id) {
		PrescriptionEntity prescriptionEntity = findById(id);
		prescriptionEntity.setActiveStatus(3);
		return baseRemove(prescriptionEntity);
	}

	public Response list() {

		return baseList(criteriaQuery(new PrescriptionEntity()));
	}

	public PrescriptionEntity findById(Long id) {
		PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
		prescriptionEntity.setId(id);
		Response response = baseFindById(criteriaQuery(prescriptionEntity));

		if (response.isSuccess()) {
			return (PrescriptionEntity) response.getObj();
		}
		return null;
	}

	public Response findByCriteria(String searchCriteria) {
		JSONObject searchCriteriaObj = new JSONObject(searchCriteria);

		Long id = Def.getLong(searchCriteriaObj, "id");
		String hospitalId = Def.getString(searchCriteriaObj, "hospitalId");
		String consultationId = Def.getString(searchCriteriaObj, "consultationId");

		PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
		prescriptionEntity.setId(id);
		prescriptionEntity.setHospitalId(hospitalId);
		prescriptionEntity.setConsultationId(consultationId);

		Response response = baseFindById(criteriaQuery(prescriptionEntity));

		if (response.isSuccess()) {
			prescriptionEntity = (PrescriptionEntity) response.getObj();
			return findByCriteriaData(prescriptionEntity);
		}
		return getErrorResponse("Data Not Found.");
	}
   
	private Response findByCriteriaData(PrescriptionEntity prescriptionEntity) {
		
		Map<String, Object> searchFoundData = new HashMap<String, Object>();
		List<PrescriptionDetailsEntity> pdList = new ArrayList<PrescriptionDetailsEntity>();
		List<PrescriptionAllNotesEntity> panList = new ArrayList<PrescriptionAllNotesEntity>();
		
		pdList = prescriptionDetailsService.getListFindByPrescriptionId(prescriptionEntity);
		panList = prescriptionAllNotesService.getListFindByPrescriptionId(prescriptionEntity);
		
		searchFoundData.put("prescription", prescriptionEntity);
		searchFoundData.put("note", getDatil(pdList, 5));
		searchFoundData.put("vitalList", prescriptionVitalService.getListFindByPrescriptionId(prescriptionEntity));
		searchFoundData.put("finalizationList",
				prescriptionFinalizeService.getListFindByPrescriptionId(prescriptionEntity));
		searchFoundData.put("physicalExamList",prescriptionPhysicalExamService.getListFindByPrescriptionId(prescriptionEntity));
		searchFoundData.put("allNotesList",prescriptionAllNotesService.getListFindByPrescriptionId(prescriptionEntity));
		searchFoundData.put("historyList",historyPrescriptionDataService.getListFindByPrescriptionId(prescriptionEntity));
		searchFoundData.put("diagnosisList", getDetailList(pdList, 6));
		searchFoundData.put("radiologyList", getDetailList(pdList, 2));
		searchFoundData.put("radiologyNote", getGenearalNote(panList, 2));
		searchFoundData.put("phatologyList", getDetailList(pdList, 1));
		searchFoundData.put("phatologyNote", getGenearalNote(panList, 1));
		searchFoundData.put("refDoctorList", getDetailList(pdList, 14));
		searchFoundData.put("medicineList",
				prescriptionMedicineService.getListFindByPrescriptionId(prescriptionEntity));
		searchFoundData.put("medicationNote", getGenearalNote(panList, 4));
		searchFoundData.put("investigationList",
				ListUtils.union(getListFromObject(searchFoundData.get("phatologyList"), List.class),

						getListFromObject(searchFoundData.get("radiologyList"), List.class)));
		searchFoundData.put("investigationNote", getGenearalNote(panList, 3));
		searchFoundData.put("chiefComplainList", getDetailList(pdList, 7));
		searchFoundData.put("adviceList", getDetailList(pdList, 8));
		searchFoundData.put("clinicalHistory2List", getDetailList(pdList, 9));

		Response responseFinal = new Response();
		responseFinal.setModel(searchFoundData);

		return getSuccessResponse("edit data found", responseFinal);
			
	}

	public Response findPreviousConsulation(String searchCriteria) {
		Response response = null;
		
		JSONObject searchCriteriaObj = new JSONObject(searchCriteria);
		String consultationId = Def.getString(searchCriteriaObj, "consultationId");
		String hospitalId = Def.getString(searchCriteriaObj, "hospitalId");
		
		if(consultationId == null &&  hospitalId == null) {
			return getErrorResponse(" Consultation Id or  HospitalId Required");
		}
		
		PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
		prescriptionEntity.setHospitalId(hospitalId);
		prescriptionEntity.setConsultationId(consultationId);
		
		
		
		if(consultationId != null && !consultationId.isEmpty()) {
			 response = getMaxSecondRecord(prescriptionEntity);
			
		}else {
			 response = getMaxRecord(prescriptionEntity);
			
		}
		

		if (response.isSuccess() && response.getObj() !=null) {
		PrescriptionEntity prescription = getValueFromObject(response.getObj(), PrescriptionEntity.class);
		return findByCriteriaData(prescription);
		}
		
		return getErrorResponse("Data not found !!");
	
		
	}
	

	@SuppressWarnings("rawtypes")
	public Response findOpdConsHistory(String searchCriteria) {

		JSONObject searchCriteriaObj = new JSONObject(searchCriteria);
		String hospitalId = Def.getString(searchCriteriaObj, "hospitalId");
		PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
		prescriptionEntity.setHospitalId(hospitalId);
		Response response = baseList(criteriaQuery(prescriptionEntity));
		
		if (response.isSuccess() && response.getItems() !=null && response.getItems().size() > 0) {
			Map<String, Object> consultationHistoryData = null;
		
			List<Map> consultationHistoryDataList = new ArrayList<Map>();
		  
			List <PrescriptionEntity> prescriptionList = getListFromObject(response.getItems(), PrescriptionEntity.class);
			for(PrescriptionEntity pres : prescriptionList) {
				
				 consultationHistoryData = new HashMap<String, Object>();
				 consultationHistoryData.put("prescriptionId", pres.getId());
				 consultationHistoryData.put("consultationId", pres.getConsultationId());
				 consultationHistoryData.put("consultationNo", pres.getConsultationNo());
				 consultationHistoryData.put("createdDate", pres.getCreatedDate());
				 consultationHistoryData.put("doctorNo", pres.getDoctorNo());
				 consultationHistoryData.put("doctorName", "");
			
//				if(pres.getDoctorNo() !=null) {
//				 
//					Response doctorResponse = doctorWisePscripService.doctorByNo(pres.getDoctorNo());
//				 
//				 if(doctorResponse.isSuccess()) {
//	
//					 DoctorWisePscripDto doctorWisePscripDto = getValueFromObject(doctorResponse.getObj(), DoctorWisePscripDto.class);
//					 consultationHistoryData.put("doctorName", doctorWisePscripDto.getDoctorName());
//				 }
//				 
//				 }
				
				consultationHistoryDataList.add(consultationHistoryData);
	
			}

			Response response2 = new Response();
			response2.setItems(consultationHistoryDataList);
			return getSuccessResponse("edit data found", response2);

		}
		
		return response;
	}
	
	private Response getMaxRecord(PrescriptionEntity filter) {

		return getMaxRecord(criteriaQuery(filter));

	}

	private Response getMaxSecondRecord(PrescriptionEntity filter) {

		return getMaxSecodRecord(criteriaQuery(filter));

	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PrescriptionEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(PrescriptionEntity.class);

		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;

		List<Predicate> p = new ArrayList<Predicate>();

		if (filter != null) {
			if (filter.getActiveStatus() > 0) {
				Predicate condition = builder.equal(root.get("activeStatus"), filter.getActiveStatus());
				p.add(condition);
			}

			if (filter.getId() != null && filter.getId() > 0) {
				Predicate condition = builder.equal(root.get("id"), filter.getId());
				p.add(condition);
			}

		}

		if (filter.getHospitalId() != null && !filter.getHospitalId().isEmpty()) {
			Predicate condition = builder.equal(root.get("hospitalId"), filter.getHospitalId());
			p.add(condition);
		}

		if (filter.getConsultationId() != null && !filter.getConsultationId().isEmpty()) {
			Predicate condition = builder.equal(root.get("consultationId"), filter.getConsultationId());
			p.add(condition);
		}

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}
		
		criteria.orderBy(builder.desc(root.get("id")));

		return criteria;

	}

	private Boolean prescriptionDetailsUpdateOrDelete(List<PrescriptionDetailsEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;

		for (PrescriptionDetailsEntity pd : batch) {
			if (pd.getIsDeleted() != null && pd.getIsDeleted() == 1) {
				response = prescriptionDetailsService.delete(pd.getId());
				if (!response.isSuccess()) {
					flag = false;
					break;
				}
			} else {
				pd.setPrescription(pres);
				if (pd.getId() != null) {
					response = prescriptionDetailsService.update(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				}

				else {
					response = prescriptionDetailsService.save(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				}
			}

		}

		return flag;
	}

	private Boolean prescriptionAllNotesUpdateOrDelete(List<PrescriptionAllNotesEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;

		for (PrescriptionAllNotesEntity pd : batch) {
			if (pd.getIsDeleted() != null && pd.getIsDeleted() == 1) {
				response = prescriptionAllNotesService.delete(pd.getId());
				if (!response.isSuccess()) {
					flag = false;
					break;
				}
			} else {
				pd.setPrescription(pres);
				if (pd.getId() != null) {
					response = prescriptionAllNotesService.update(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				}

				else {
					response = prescriptionAllNotesService.save(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				}
			}

		}

		return flag;
	}

	private Boolean prescriptionVitalSave(List<PrescriptionVitalEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;
		for (PrescriptionVitalEntity pd : batch) {
			pd.setPrescription(pres);
			response = prescriptionVitalService.save(pd);

			if (!response.isSuccess()) {
				flag = false;
				break;
			}

		}

		return flag;
	}

	private Boolean prescriptionFinalizeSave(List<PrescriptionFinalizeEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;
		for (PrescriptionFinalizeEntity pd : batch) {
			pd.setPrescription(pres);
			response = prescriptionFinalizeService.save(pd);

			if (!response.isSuccess()) {
				flag = false;
				break;
			}

		}

		return flag;
	}
	
	private Boolean prescriptionPhysicalExamSave(List<PrescriptionPhysicalExamEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;
		for (PrescriptionPhysicalExamEntity pd : batch) {
			pd.setPrescription(pres);
			response = prescriptionPhysicalExamService.save(pd);

			if (!response.isSuccess()) {
				flag = false;
				break;
			}

		}

		return flag;
	}
	
	private Boolean prescriptionHistorySave(List<PrescriptionHistoryEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;
		for (PrescriptionHistoryEntity pd : batch) {
			pd.setPrescription(pres);
			response = historyPrescriptionDataService.save(pd);

			if (!response.isSuccess()) {
				flag = false;
				break;
			}

		}

		return flag;
	}

	private Boolean prescriptionMedicineSave(List<PrescriptionMedicineEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;
		for (PrescriptionMedicineEntity pd : batch) {
			pd.setPrescription(pres);
			response = prescriptionMedicineService.save(pd);

			if (!response.isSuccess()) {
				flag = false;
				break;
			}

		}

		return flag;
	}

	private Boolean prescriptionVitalOrDelete(List<PrescriptionVitalEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;
		for (PrescriptionVitalEntity pd : batch) {
			if (pd.getIsDeleted() != null && pd.getIsDeleted() == 1) {
				response = prescriptionVitalService.delete(pd.getId());
				if (!response.isSuccess()) {
					flag = false;
					break;
				}
			} else {
				pd.setPrescription(pres);
				if (pd.getId() != null) {
					response = prescriptionVitalService.update(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				} else {
					response = prescriptionVitalService.save(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				}
			}

			if (!response.isSuccess()) {
				break;
			}

		}

		return flag;
	}

	private Boolean prescriptionFinalizeUpdateOrDelete(List<PrescriptionFinalizeEntity> batch,
			PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;
		for (PrescriptionFinalizeEntity pd : batch) {
			if (pd.getIsDeleted() != null && pd.getIsDeleted() == 1) {
				response = prescriptionFinalizeService.delete(pd.getId());
				if (!response.isSuccess()) {
					flag = false;
					break;
				}
			} else {
				pd.setPrescription(pres);
				if (pd.getId() != null) {
					response = prescriptionFinalizeService.update(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				} else {
					response = prescriptionFinalizeService.save(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				}
			}

			if (!response.isSuccess()) {
				break;
			}

		}

		return flag;
	}
	private Boolean prescriptionPhysicalExamUpdateOrDelete(List<PrescriptionPhysicalExamEntity> batch,
			PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;
		for (PrescriptionPhysicalExamEntity pd : batch) {
			if (pd.getIsDeleted() != null && pd.getIsDeleted() == 1) {
				response = prescriptionPhysicalExamService.delete(pd.getId());
				if (!response.isSuccess()) {
					flag = false;
					break;
				}
			} else {
				pd.setPrescription(pres);
				if (pd.getId() != null) {
					response = prescriptionPhysicalExamService.update(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				} else {
					response = prescriptionPhysicalExamService.save(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				}
			}

			if (!response.isSuccess()) {
				break;
			}

		}

		return flag;
	}
	
	private Boolean prescriptionHistoryUpdateOrDelete(List<PrescriptionHistoryEntity> batch,
			PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;
		for (PrescriptionHistoryEntity pd : batch) {
			if (pd.getIsDeleted() != null && pd.getIsDeleted() == 1) {
				response = historyPrescriptionDataService.delete(pd.getId());
				if (!response.isSuccess()) {
					flag = false;
					break;
				}
			} else {
				pd.setPrescription(pres);
				if (pd.getId() != null) {
					response = historyPrescriptionDataService.update(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				} else {
					response = historyPrescriptionDataService.save(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				}
			}
			if (!response.isSuccess()) {
				break;
			}
		}
		return flag;
	}

	private Boolean prescriptionMedicineOrDelete(List<PrescriptionMedicineEntity> batch, PrescriptionEntity pres) {
		Response response = null;
		Boolean flag = true;
		for (PrescriptionMedicineEntity pd : batch) {
			if (pd.getIsDeleted() != null && pd.getIsDeleted() == 1) {
				response = prescriptionMedicineService.delete(pd.getId());
				if (!response.isSuccess()) {
					flag = false;
					break;
				}
			} else {
				pd.setPrescription(pres);
				if (pd.getId() != null) {
					response = prescriptionMedicineService.update(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				} else {
					response = prescriptionMedicineService.save(pd);
					if (!response.isSuccess()) {
						flag = false;
						break;
					}
				}
			}

			if (!response.isSuccess()) {
				break;
			}

		}

		return flag;
	}
}
