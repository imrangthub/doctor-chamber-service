/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madbarsoft.doctorchamber.report;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.madbarsoft.core.report.CoreJasperService;
import com.madbarsoft.core.report.CusJasperReportDef;
import com.madbarsoft.doctorchamber.consultation.ConsultantEntity;
import com.madbarsoft.doctorchamber.consultation.ConsultationEntity;
import com.madbarsoft.doctorchamber.consultation.service.ConsultationService;
import com.madbarsoft.doctorchamber.medicalCertificate.CertificateEntity;
import com.madbarsoft.doctorchamber.medicalCertificate.CertificateJasperDto;
import com.madbarsoft.doctorchamber.medicalCertificate.CertificateService;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.prescription.PrescriptionJasperBean;
import com.madbarsoft.doctorchamber.prescription.PrescriptionService;
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
import com.madbarsoft.doctorchamber.setup.head.HeadEntity;
import com.madbarsoft.doctorchamber.setup.head.HeadService;
import com.madbarsoft.doctorchamber.userPreferences.UserPreferencesEntity;
import com.madbarsoft.doctorchamber.userPreferences.UserPreferencesService;
import com.madbarsoft.doctorchamber.util.CommonFunction;
import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Md. Jahurul Islam
 *
 */
@Repository
@Transactional
public class ReportRepository extends CommonFunction {

	/*
	 * @Autowired JasperService jasperService;
	 */
	@Autowired
	CoreJasperService jasperService;
	@Autowired
	PrescriptionService prescriptionService;

	@Autowired
	PrescriptionDetailsService prescriptionDetailsService;
	@Autowired
	PrescriptionMedicineService prescriptionMedicineService;
	@Autowired
	PrescriptionVitalService prescriptionVitalService;

	@Autowired
	ConsultationService consulationService;

	@Autowired
	private PrescriptionFinalizeService prescriptionFinalizeService;
	@Autowired
	PrescriptionAllNotesService prescriptionAllNotesService;

	@Autowired
	private PrescriptionPhysicalExamService prescriptionPhysicalExamService;

	@Autowired
	HeadService headService;
	@Autowired
	UserPreferencesService userPreferencesService;

	@Autowired
	private PrescriptionHistoryService historyPrescriptionDataService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CusJasperReportDef prescription(long id, String pClient, String pLayout) {

		List<PrescriptionVitalEntity> prescriptionVitalEntityList = null;
		List<UserPreferencesEntity> userPreferenceList = null;
		UserPreferencesEntity userPreferencesEntity = null;
		PrescriptionJasperBean prescriptionReport = new PrescriptionJasperBean();
		List<PrescriptionJasperBean> prescriptionReportList = new ArrayList<PrescriptionJasperBean>();
		PrescriptionEntity prescriptionEntity = prescriptionService.findById(id);
		List<PrescriptionDetailsEntity> prescriptionDetailsList = prescriptionDetailsService
				.getListFindByPrescriptionId(prescriptionEntity);
		List<PrescriptionMedicineEntity> prescriptionMedicineList = prescriptionMedicineService
				.getListFindByPrescriptionId(prescriptionEntity);

		if (prescriptionEntity.getDoctorNo() != null) {
			prescriptionVitalEntityList = prescriptionVitalService
					.getListFindByPrescriptionIdAndDocorId(prescriptionEntity, prescriptionEntity.getDoctorNo());
			userPreferenceList = userPreferencesService.getPreferenceByDoctorNo(prescriptionEntity.getDoctorNo());

		} else {
			prescriptionVitalEntityList = prescriptionVitalService.getListFindByPrescriptionId(prescriptionEntity);
		}

		// Map<String, List<UserPreferencesEntity>> userPreferenceMap = null;
		Map<String, UserPreferencesEntity> userPreferenceMap = null;

		if (userPreferenceList != null) {

			userPreferenceMap = new HashMap<String, UserPreferencesEntity>();

			for (UserPreferencesEntity up : userPreferenceList) {
				if (up.getUserPreferencesKey().equals("finalization_1")
						|| up.getUserPreferencesKey().equals("finalization_2")) {
					if (up.getUserPreferencesValue().equals("1")) {
						userPreferenceMap.put("finalization_1", up);
					}

				} else {
					userPreferenceMap.put(up.getUserPreferencesKey(), up);
				}

			}
			// userPreferenceMap =
			// userPreferenceList.stream().collect(Collectors.groupingBy(UserPreferencesEntity::getUserPreferencesKey));
			prescriptionReport.setUserPreferenceMap(userPreferenceMap);

			userPreferencesEntity = userPreferencesService.getPreferenceByKey(userPreferenceList,
					"report_footer_consultation_time");
			if (userPreferencesEntity != null) {
				prescriptionReport.setConsultationHours(userPreferencesEntity.getUserPreferencesValue());
			}
		}

		List<PrescriptionFinalizeEntity> prescriptionFinalizeEntityList = prescriptionFinalizeService
				.getListFindByPrescriptionId(prescriptionEntity);
		List<PrescriptionAllNotesEntity> prescriptionAllNotesList = prescriptionAllNotesService
				.getListFindByPrescriptionId(prescriptionEntity);
		List<PrescriptionPhysicalExamEntity> physicalExamList = prescriptionPhysicalExamService
				.getListFindByPrescriptionId(prescriptionEntity);
		List<PrescriptionHistoryEntity> historyList = historyPrescriptionDataService
				.getListFindByPrescriptionId(prescriptionEntity);
		List<HeadEntity> headList = null;
		Map<String, Boolean> printPreferenceInfo = null;

		if (prescriptionEntity != null && prescriptionEntity.getDoctorNo() != null) {
			Response responseHead = headService.listByDoctorNo(prescriptionEntity.getDoctorNo());
			if (responseHead.isSuccess() && responseHead.getItems() != null) {
				headList = getListFromObject(responseHead.getItems(), HeadEntity.class);
				printPreferenceInfo = headList.stream()
						.collect(Collectors.toMap(HeadEntity::getHeadName, HeadEntity::getIsPrintable));
				prescriptionReport.setPrintPreferenceInfo(printPreferenceInfo);
			}
		}

		CusJasperReportDef report = new CusJasperReportDef();

/*		Response response = consulationService.findByHospitalNumber(prescriptionEntity.getHospitalId());
		Response response2 = consulationService.findByDocotorNo(prescriptionEntity.getDoctorNo());*/
		
		Response response = null;
		Response response2 = null;

		prescriptionReport.setReasonForReferralList(prescriptionAllNotesList);

		PrescriptionAllNotesEntity pnRadiology = prescriptionAllNotesService
				.getListFindByNotesDataType(prescriptionAllNotesList, 2);
		PrescriptionAllNotesEntity investigation = prescriptionAllNotesService
				.getListFindByNotesDataType(prescriptionAllNotesList, 1);
		PrescriptionAllNotesEntity medicationInvestigation = prescriptionAllNotesService
				.getListFindByNotesDataType(prescriptionAllNotesList, 4);
		PrescriptionAllNotesEntity generalNotes = prescriptionAllNotesService
				.getListFindByNotesDataType(prescriptionAllNotesList, 5);

		if (pnRadiology != null) {
			prescriptionReport.setReasonForReferral(pnRadiology.getNotesData());
		}
		if (investigation != null) {
			prescriptionReport.setReasonForReferralInvestigation(investigation.getNotesData());
		}
		if (medicationInvestigation != null) {
			prescriptionReport.setMedicationInvestigation(medicationInvestigation.getNotesData());
		}
		if (generalNotes != null) {
			prescriptionReport.setGeneralNotes(generalNotes.getNotesData());
		}

		if (response.isSuccess()) {

			ConsultationEntity consulatation = (ConsultationEntity) response.getObj();

			prescriptionReport.setPatName(consulatation.getPatientName());
			prescriptionReport.setPatAge(consulatation.getAge());
			prescriptionReport.setPatGender(consulatation.getGender());
			prescriptionReport.setPatDob(consulatation.getDob());
			prescriptionReport.setPhoneNo(consulatation.getPhoneNo());
		}
		if (response2.isSuccess() && response2.getObj() != null) {
			ConsultantEntity consultantEntity = (ConsultantEntity) response2.getObj();
			prescriptionReport.setDoctorName(consultantEntity.getDoctorName());
			prescriptionReport.setDoctorSignature(consultantEntity.getDoctorSignature());
		}

		prescriptionReport.setVisitDate(prescriptionEntity.getCreatedDate());
		prescriptionReport.setConsultantId(prescriptionEntity.getConsultationId());
		prescriptionReport.setHospitalId(prescriptionEntity.getHospitalId());
		prescriptionReport.setConsultantNo(prescriptionEntity.getConsultationNo());
		PrescriptionDetailsEntity notes = prescriptionDetailsService.getDetailsByDataType(prescriptionDetailsList, 5);

		if (notes != null) {
			prescriptionReport.setNotes(notes.getPrescritionData());
		}

		List<PrescriptionDetailsEntity> clinicalHisotryList = prescriptionDetailsService
				.getDetailsListByDataType(prescriptionDetailsList, 9);

		if (clinicalHisotryList != null) {
			prescriptionReport.setClinicalHisotryList(clinicalHisotryList);
		}

		List<PrescriptionDetailsEntity> referralList = prescriptionDetailsService
				.getDetailsListByDataType(prescriptionDetailsList, 14);

		if (referralList != null && referralList.size() > 0) {

			prescriptionReport.setReferralList(referralList);
		}

		if (prescriptionFinalizeEntityList != null && prescriptionFinalizeEntityList.size() > 0) {

			List<PrescriptionFinalizeEntity> prescriptionFinalizeEntityFilterList = prescriptionFinalizeEntityList
					.stream()
					.filter(pfinal -> (pfinal.getFinalizeResult() != null && !pfinal.getFinalizeResult().isEmpty()))
					.collect(Collectors.toList());

			prescriptionReport.setFinalizationList(prescriptionFinalizeEntityFilterList);

		}

		if (physicalExamList != null && physicalExamList.size() > 0) {
			List<PrescriptionPhysicalExamEntity> physicalFilterExamList = physicalExamList.stream()
					.filter(ped -> ped.getExamResult() != null && !ped.getExamResult().isEmpty())
					.collect(Collectors.toList());
			prescriptionReport.setPhysicalExamList(physicalFilterExamList);
		}

		if (historyList != null && historyList.size() > 0) {
			List<PrescriptionHistoryEntity> historyFilterList = historyList.stream()
					.filter(phd -> phd.getHistoryResult() != null && !phd.getHistoryResult().isEmpty())
					.collect(Collectors.toList());
			prescriptionReport.setHistoryList(historyFilterList);
		}

		if (prescriptionVitalEntityList != null && prescriptionVitalEntityList.size() > 0) {

			List<PrescriptionVitalEntity> prescriptionVitalFilterList = prescriptionVitalEntityList.stream()
					.filter(pv -> pv.getVitalResult() != null && !pv.getVitalResult().isEmpty())
					.collect(Collectors.toList());
			if (prescriptionVitalFilterList != null && prescriptionVitalFilterList.size() > 0) {
				prescriptionReport.setVitalList(prescriptionVitalEntityList);
			}
		}

		prescriptionReport
				.setDiagnosisList(prescriptionDetailsService.getDetailsListByDataType(prescriptionDetailsList, 6));
		prescriptionReport
				.setRadiologyList(prescriptionDetailsService.getDetailsListByDataType(prescriptionDetailsList, 2));
		prescriptionReport
				.setPathologhList(prescriptionDetailsService.getDetailsListByDataType(prescriptionDetailsList, 1));
		prescriptionReport
				.setChiefComplainList(prescriptionDetailsService.getDetailsListByDataType(prescriptionDetailsList, 7));
		prescriptionReport
				.setAdviceList(prescriptionDetailsService.getDetailsListByDataType(prescriptionDetailsList, 8));

		if (prescriptionReport.getVitalList() != null && prescriptionReport.getVitalList().size() > 0) {
			prescriptionReport.setVitalListHorizontally(prescriptionReport.getVitalList().stream()
					.map(vital -> String.valueOf(" " + vital.getVitalName() + " : " + vital.getVitalResult() + " "
							+ (vital.getVitalUnit() == null ? "" : vital.getVitalUnit())))
					.collect(Collectors.joining(",")));

		}

		List addAllList = new ArrayList<>();

		if (prescriptionReport.getPathologhList() != null && prescriptionReport.getPathologhList().size() > 0) {

			// prescriptionReport.setInvestigationList(prescriptionReport.getPathologhList());
			addAllList.addAll(prescriptionReport.getPathologhList());
		}

		if (prescriptionReport.getRadiologyList() != null && prescriptionReport.getRadiologyList().size() > 0) {
			addAllList.addAll(prescriptionReport.getRadiologyList());
		}

		if (addAllList.size() > 0) {
			prescriptionReport.setInvestigationList(addAllList);
		}

		prescriptionReport.setMedicineList(prescriptionMedicineList);

		prescriptionReportList.add(prescriptionReport);

		ReportPathAndName reportPathAndName = CommonFunction.reportPathName(pClient, pLayout);

		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("SUBREPORT_DIR", CommonFunction.getResoucePath("/report/prescription/" + pClient));

		report.setOutputFilename("prescription");
		report.setReportName(reportPathAndName.getrName());
		report.setReportDir(CommonFunction.getResoucePath(reportPathAndName.getrPath()) + "/");
		report.setReportFormat(com.madbarsoft.core.util.CommonFunction.printFormat("PDF"));
		report.setParameters(parameterMap);
		report.setReportData(prescriptionReportList);
		ByteArrayOutputStream baos = null;
		try {
			baos = jasperService.generateReport(report);
		} catch (Exception e) {
			e.printStackTrace();
		}

		report.setContent(baos.toByteArray());
		return report;
	}

	@Autowired
	CertificateService certificateService;

	public CusJasperReportDef printMedicalCertificate(String certificateId, Long doctorNo, String reportName) {

		CertificateJasperDto certificateDto = new CertificateJasperDto();
		CertificateEntity certificateEntity = (CertificateEntity) certificateService
				.findByCriteria("{id:" + certificateId + "}").getObj();
//		ConsultantEntity consultantEntity = (ConsultantEntity) consulationService.findByDocotorNo(doctorNo).getObj();
		
		ConsultantEntity consultantEntity = new ConsultantEntity();
		
		String finialContent = certificateService.getFinialCertificateContent(certificateEntity);
		certificateDto.setDoctorName(consultantEntity.getDoctorName());
		certificateDto.setDoctorSignature(consultantEntity.getDoctorSignature());
		certificateDto.setCertificateContent(finialContent);
		List<CertificateJasperDto> certificateDtoList = new ArrayList<CertificateJasperDto>();
		certificateDtoList.add(certificateDto);

		CusJasperReportDef report = new CusJasperReportDef();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		report.setOutputFilename(reportName);
		report.setReportName("/" + reportName);
		report.setReportDir(CommonFunction.getResoucePath("/report/prescription/wahab"));
		report.setReportFormat(com.madbarsoft.core.util.CommonFunction.printFormat("PDF"));
		report.setParameters(null);
		report.setReportData(certificateDtoList);
		ByteArrayOutputStream baos = null;
		try {
			baos = jasperService.generateReport(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		report.setContent(baos.toByteArray());
		return report;

	}

}
