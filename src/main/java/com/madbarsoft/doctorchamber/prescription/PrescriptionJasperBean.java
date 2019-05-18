package com.madbarsoft.doctorchamber.prescription;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.madbarsoft.doctorchamber.prescriptionAllNotes.PrescriptionAllNotesEntity;
import com.madbarsoft.doctorchamber.prescriptionDetails.PrescriptionDetailsEntity;
import com.madbarsoft.doctorchamber.prescriptionFinalize.PrescriptionFinalizeEntity;
import com.madbarsoft.doctorchamber.prescriptionHistory.PrescriptionHistoryEntity;
import com.madbarsoft.doctorchamber.prescriptionMedicine.PrescriptionMedicineEntity;
import com.madbarsoft.doctorchamber.prescriptionPhysicalExam.PrescriptionPhysicalExamEntity;
import com.madbarsoft.doctorchamber.prescriptionVital.PrescriptionVitalEntity;
import com.madbarsoft.doctorchamber.userPreferences.UserPreferencesEntity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PrescriptionJasperBean {

	private String hospitalId;
	private Long consultantNo;
	private String consultantId;
	private String patName;
	private String patAge;
	private Date   patDob;
	private String patGender;
	private String phoneNo;
	private String vitalListHorizontally;
	private String reasonForReferral;
	private String reasonForReferralInvestigation;
	private String medicationInvestigation;
	private String consultationHours;
	private Map<String, UserPreferencesEntity> userPreferenceMap;
	
	private List<PrescriptionAllNotesEntity> reasonForReferralList;
	private List<PrescriptionVitalEntity> vitalList;
	private List<PrescriptionFinalizeEntity> finalizationList;
	private List <PrescriptionPhysicalExamEntity> physicalExamList; 
	private List <PrescriptionHistoryEntity> historyList;
	private List<PrescriptionDetailsEntity> chiefComplainList;
	private List<PrescriptionDetailsEntity> diagnosisList;
	private List<PrescriptionDetailsEntity> pathologhList;
	private List<PrescriptionDetailsEntity> radiologyList;
	private List<PrescriptionDetailsEntity> adviceList;
	private List<PrescriptionDetailsEntity> clinicalHisotryList;
	private List<PrescriptionDetailsEntity> investigationList; // combined pathologyList and radiologyList
	private List<PrescriptionDetailsEntity> referralList; 
	private boolean printCombine = true;
	private boolean printFinalExam = false;
	
	private List<PrescriptionMedicineEntity> medicineList;
	private Map<String, Boolean> printPreferenceInfo;
	
	private Date visitDate;
	private String notes;
	private String generalNotes;
	
	private String doctorName;
	private String doctorSignature;

}
