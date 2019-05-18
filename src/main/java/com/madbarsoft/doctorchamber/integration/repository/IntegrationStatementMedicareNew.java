package com.madbarsoft.doctorchamber.integration.repository;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class IntegrationStatementMedicareNew {

	public String readInvestigationDataByConsultationNo(Long consultationNo) {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT OPD_CONDTL_NO, APPOINTMENT_NO, ");
		sql.append(" OPD_CONSULTATION_NO, ITEM_NO, ITEMTYPE_NO, ITEM_QTY, ");
		sql.append(" DELIVERY_STATUS_NO, ITEM_NAME ");
		sql.append(" FROM OPD_CONSULTATION_DETAIL WHERE OPD_CONSULTATION_NO = ");
		sql.append(consultationNo);
		sql.append(" AND ITEMTYPE_NO BETWEEN 1 AND 2 ");

		return sql.toString();

	}

	public String creatInvestigationQuery() {

		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO OPD_CONSULTATION_DETAIL (OPD_CONDTL_NO, APPOINTMENT_NO, ");
		sql.append(" OPD_CONSULTATION_NO, ITEM_NO, ITEMTYPE_NO, ITEM_QTY, ");
		sql.append(" DELIVERY_STATUS_NO, ITEM_NAME, ");
		sql.append(" SS_CREATOR, SS_CREATED_ON, COMPANY_NO) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		return sql.toString();

	}

	public String updateInvestigationData() {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE OPD_CONSULTATION_DETAIL SET ");
		sql.append(" ITEMTYPE_NO = ?, ITEM_QTY = ?, ITEM_NAME = ?, ");
		sql.append(" SS_MODIFIER = ?, SS_MODIFIED_ON = ?, SS_IS_DELETED = ? ");
		sql.append(" WHERE OPD_CONSULTATION_NO = ? AND ITEM_NO = ?");

		return sql.toString();

	}

	public String deleteInvestigationDataFlag(Map<String, Object> deleteParams) {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE OPD_CONSULTATION_DETAIL SET ");
		sql.append(" SS_IS_DELETED = ?, SS_MODIFIER = ?, SS_MODIFIED_ON = ? ");
		sql.append(" WHERE OPD_CONSULTATION_NO = ? AND ITEM_NO = ? ");

		return sql.toString();

	}

	public String deleteInvestigationData() {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM OPD_CONSULTATION_DETAIL WHERE OPD_CONSULTATION_NO = ? AND ITEM_NO = ?");
		return sql.toString();
	}
	
	public String deleteAllInvestigationDataWithOutItemNo() {
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM OPD_CONSULTATION_DETAIL WHERE OPD_CONSULTATION_NO = ? AND itemtype_no BETWEEN 1 AND 2 AND item_no IS NULL OR item_no = 0");
		return sql.toString();
	}
	

	public String createMedicineData() {

		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO OPD_CONSULTATION_DETAIL (OPD_CONDTL_NO, APPOINTMENT_NO, ");
		sql.append(" OPD_CONSULTATION_NO, ITEM_NO, ITEMTYPE_NO, ITEM_QTY, ");
		sql.append(" DELIVERY_STATUS_NO, ITEM_NAME, ");
		sql.append(" SS_CREATOR, SS_CREATED_ON, COMPANY_NO, ");

		sql.append(" ITEM_GROUP, ");
		sql.append(" UOM_NO, GENERIC_NO, MED_DOSE, MED_ROUTE, MED_DURATION, MED_DURATION_MU, SUBITEMTYPE_NO )");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		return sql.toString();
	}

	public String readMedicineData(Long consultationNo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT OPD_CONDTL_NO, APPOINTMENT_NO, ");
		sql.append(" OPD_CONSULTATION_NO, ITEM_NO, ITEMTYPE_NO, ITEM_QTY, ");
		sql.append(" DELIVERY_STATUS_NO, UOM_NO, GENERIC_NO, MED_DOSE, MED_ROUTE, ");
		sql.append(" MED_DURATION, MED_DURATION_MU, ITEM_NAME ");
		sql.append(" FROM OPD_CONSULTATION_DETAIL WHERE OPD_CONSULTATION_NO= ");
		sql.append(consultationNo);
		sql.append(" AND ITEMTYPE_NO = 4");
		return sql.toString();
	}

	public String updateMedicineData() {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE OPD_CONSULTATION_DETAIL SET ");
		sql.append(" ITEMTYPE_NO = ?, ITEM_QTY = ?, ");
		sql.append(" UOM_NO = ?, GENERIC_NO = ?, MED_DOSE = ?, MED_ROUTE = ?, ");
		sql.append(" MED_DURATION = ?, MED_DURATION_MU = ?, ITEM_NAME = ?,");
		sql.append(" SS_MODIFIER = ?, SS_MODIFIED_ON = ?, SS_IS_DELETED = ? ");
		sql.append(" WHERE OPD_CONSULTATION_NO = ? AND ITEM_NO = ?");
		return sql.toString();
	}

	public String updateReverseAdmissionData() {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE OPD_CONSULTATION SET ");
		sql.append(" PRESCRIBED_ADMISSION_DATE = ?, SS_MODIFIER = ?, SS_MODIFIED_ON = ? ");
		sql.append(" WHERE OPD_CONSULTATION_NO = ?");
		return sql.toString();
	}

}
