package com.madbarsoft.doctorchamber.consultation.statement;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.madbarsoft.doctorchamber.consultation.ConsultationEntity;
import com.madbarsoft.doctorchamber.util.CommonFunctions;

@Component
public class ConsultationStatementMedicareNew implements CommonFunctions{
	
	public static String opd_consultation_web_v(Map<String, String> queryMap) {	
		boolean andFlag = false;
		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append("SELECT opd_consultation_no, opd_consultation_id, consultation_dt, SHIFTDTL_NO, ");
		sqlQuery.append(" TO_CHAR (consultation_time, 'DD/MM/YYYY hh:mm:ss') AS appoint_date, ");
		sqlQuery.append(" DOCTOR_NO AS doctor_no,CONSULT_IN AS consult_in, CONSULT_OUT AS consult_out, ");
		sqlQuery.append(" patient_name AS full_name, ");
		sqlQuery.append(" phone_mobile AS mobile, age, gender AS sex, m_status, ");
		sqlQuery.append(" blood_group AS bloodgroup, pe_addr1 AS address, consult_type_no,");
		sqlQuery.append(" consultation_type_desc, doctor_no, doctor_name, doc_degree, ");
		sqlQuery.append(" shiftdtl_no, TO_CHAR (start_time, 'DD/MM/YYYY hh:mm:ss') AS start_time, ");
		sqlQuery.append(" TO_CHAR (end_time, 'DD/MM/YYYY hh:mm:ss') AS end_time, slot_sl, reg_no, ");
		sqlQuery.append(" hospital_number, consultation_dt  ");
		sqlQuery.append(" FROM opd_consultation_web_v ");
		
		sqlQuery.append(" WHERE ");
		
		if(queryMap.containsKey("doctorNo")) {
			sqlQuery.append(" DOCTOR_NO = ");
			sqlQuery.append(" '"+queryMap.get("doctorNo")+"' ");
			andFlag = true;

		}
		
		 if(queryMap.containsKey("shiftdtlNo") ) {
			 if(andFlag) {sqlQuery.append(" AND ");}
				sqlQuery.append(" SHIFTDTL_NO = ");
				sqlQuery.append(" '"+queryMap.get("shiftdtlNo")+"' ");
				andFlag = true;
			
		 }
		

	 if(queryMap.containsKey("fromDate") && queryMap.containsKey("toDate")) {
		 if(andFlag) {sqlQuery.append(" AND ");}
			sqlQuery.append("  consultation_dt BETWEEN TO_DATE ");
			sqlQuery.append(" ('"+queryMap.get("fromDate")+"', 'dd/mm/yyyy') ");
			sqlQuery.append(" AND ");
			sqlQuery.append(" TO_DATE ('"+queryMap.get("toDate")+"', 'dd/mm/yyyy') ");
			andFlag = true;
	 }
	 
	 if(queryMap.containsKey("opdConsultationId") ) {
		 if(andFlag) {sqlQuery.append(" AND ");}
			sqlQuery.append(" OPD_CONSULTATION_ID like ");
			sqlQuery.append("'%"+queryMap.get("opdConsultationId")+"%'");
		
	 }
	 
		return sqlQuery.toString();
		
	}

	public static String opd_consultation_web_v_app(Map<String, String> queryMap) {	
		boolean andFlag = false;
		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append("select opd_consultation_no, opd_consultation_id, consultation_time, consultation_dt, shiftdtl_no, appoint_date, ");
		sqlQuery.append("doctor_name, doctor_no as doctor_no,consult_in as consult_in, consult_out as consult_out, ");
		sqlQuery.append("patient_name as full_name, ");
		sqlQuery.append("phone_mobile as mobile, age, gender as sex, m_status, ");
		sqlQuery.append("blood_group as bloodgroup, pe_addr1 as address, consult_type_no, ");
		sqlQuery.append("consultation_type_desc, doctor_no, doctor_name, doc_degree, ");
		sqlQuery.append("shiftdtl_no, to_char (start_time, 'HH:MI AM') as start_time, ");
		sqlQuery.append("to_char (end_time, 'HH:MI AM') as end_time, slot_sl, reg_no, ");
		sqlQuery.append("hospital_number ");
		sqlQuery.append("FROM opd_consultation_web_v_app ");
		
		sqlQuery.append(" WHERE ");
		
		if(queryMap.containsKey("doctorNo")) {
			sqlQuery.append(" DOCTOR_NO = ");
			sqlQuery.append(" '"+queryMap.get("doctorNo")+"' ");
			andFlag = true;

		}
		
		 if(queryMap.containsKey("shiftdtlNo") ) {
			 if(andFlag) {sqlQuery.append(" AND ");}
				sqlQuery.append(" SHIFTDTL_NO = ");
				sqlQuery.append(" '"+queryMap.get("shiftdtlNo")+"' ");
				andFlag = true;
			
		 }
		

	 if(queryMap.containsKey("fromDate") && queryMap.containsKey("toDate")) {
		 if(andFlag) {sqlQuery.append(" AND ");}
			sqlQuery.append("  appoint_date BETWEEN TO_DATE ");
			sqlQuery.append(" ('"+queryMap.get("fromDate")+"', 'dd/mm/yyyy') ");
			sqlQuery.append(" AND ");
			sqlQuery.append(" TO_DATE ('"+queryMap.get("toDate")+"', 'dd/mm/yyyy') ");
			andFlag = true;
	 }
	 
	 if(queryMap.containsKey("opdConsultationId") ) {
		 if(andFlag) {sqlQuery.append(" AND ");}
			sqlQuery.append(" OPD_CONSULTATION_ID like ");
			sqlQuery.append("'%"+queryMap.get("opdConsultationId")+"%'");
		
	 }
	 
		return sqlQuery.toString();
		
	}
	
	public static String opd_registration(Map<String, String> queryMap) {	
		boolean andFlag = false;
		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append("SELECT o.reg_no, o.hospital_number, o.salutation, o.fname, o.lname, ");
		sqlQuery.append(" o.patient_name AS full_name, o.gender AS sex, o.gender_data, o.m_status, o.m_status_data, ");
		sqlQuery.append(" o.age_dd, o.age_mm, o.age_yy, o.age, o.dob, o.blood_group AS bloodgroup, o.religion, ");
		sqlQuery.append(" o.phone_mobile AS mobile, o.email, o.address ");
		sqlQuery.append(" FROM opd_registration o ");
		sqlQuery.append(" WHERE ");
		
		if(queryMap.containsKey("hospitalNo")) {
			sqlQuery.append(" o.hospital_number like ");
			sqlQuery.append("'%"+queryMap.get("hospitalNo")+"%'");
		}
	 
		return sqlQuery.toString();
		
	}

	public static String opd_consultation_find_by_consultation_Id(ConsultationEntity reqObj) {			
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT opd_consultation_no, opd_consultation_id, appoint_no as appointment_no, SHIFTDTL_NO, appoint_date, ");
		sqlQuery.append(" DOCTOR_NAME as doctor_name, DOCTOR_NO AS doctor_no,CONSULT_IN AS consult_in, CONSULT_OUT AS consult_out, ");
		sqlQuery.append(" patient_name AS full_name, ");
		sqlQuery.append(" phone_mobile AS mobile, age, gender AS sex, m_status, ");
		sqlQuery.append(" blood_group AS bloodgroup, pe_addr1 AS address, consult_type_no,");
		sqlQuery.append(" consultation_type_desc, doctor_no, doctor_name, doc_degree, ");
		sqlQuery.append(" shiftdtl_no, TO_CHAR (start_time, 'DD/MM/YYYY hh:mm:ss') AS start_time, ");
		sqlQuery.append(" TO_CHAR (end_time, 'DD/MM/YYYY hh:mm:ss') AS end_time, slot_sl, reg_no, ");
		sqlQuery.append(" hospital_number, consultation_dt  ");
		sqlQuery.append(" FROM opd_consultation_web_v_app ");
		sqlQuery.append(" WHERE ");
		
		if(reqObj.getDoctor_no() !=null) {
			
			sqlQuery.append(" DOCTOR_NO = ");
			sqlQuery.append(" '" + reqObj.getDoctor_no() + "' ");
			sqlQuery.append(" AND ");
		}
	
		sqlQuery.append(" opd_consultation_id =  ");
		sqlQuery.append(" '" + reqObj.getConsultationId() + "' ");
		
		return sqlQuery.toString();
		
	}
	
	public static String opd_consultation_find_by_hospital_number(String hnNumber) {			
		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append("SELECT opd_consultation_no, opd_consultation_id, SHIFTDTL_NO, appoint_no as appointment_no,  appoint_date, ");
		sqlQuery.append(" DOCTOR_NO AS doctor_no,CONSULT_IN AS consult_in, CONSULT_OUT AS consult_out, ");
		sqlQuery.append(" patient_name AS full_name, ");
		sqlQuery.append(" phone_mobile AS mobile, age,dob, gender AS sex, m_status, ");
		sqlQuery.append(" blood_group AS bloodgroup, pe_addr1 AS address, consult_type_no,");
		sqlQuery.append(" consultation_type_desc, doctor_no, doctor_name, doc_degree, ");
		sqlQuery.append(" shiftdtl_no, TO_CHAR (start_time, 'DD/MM/YYYY hh:mm:ss') AS start_time, ");
		sqlQuery.append(" TO_CHAR (end_time, 'DD/MM/YYYY hh:mm:ss') AS end_time, slot_sl, reg_no, ");
		sqlQuery.append(" hospital_number, consultation_dt  ");
		sqlQuery.append(" FROM opd_consultation_web_v_app ");
		sqlQuery.append(" WHERE ");

		sqlQuery.append(" hospital_number =  ");
		sqlQuery.append(" '" + hnNumber + "' ");
		
		return sqlQuery.toString();
		
	}
	
	
	public static String opd_consultation_web_v() {
		
		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append(" SELECT opd_consultation_no, opd_consultation_id, ");
		sqlQuery.append(" TO_CHAR (consultation_time, 'DD/MM/YYYY hh:mm:ss') AS appoint_date, ");
		sqlQuery.append(" DOCTOR_NO AS doctor_no,CONSULT_IN AS consult_in, CONSULT_OUT AS consult_out, ");
		sqlQuery.append(" patient_name AS full_name, ");
		sqlQuery.append(" phone_mobile AS mobile, age, gender AS sex, m_status, ");
		sqlQuery.append(" blood_group AS bloodgroup, pe_addr1 AS address, consult_type_no,");
		sqlQuery.append(" consultation_type_desc, doctor_no, doctor_name, doc_degree, ");
		sqlQuery.append(" shiftdtl_no, TO_CHAR (start_time, 'DD/MM/YYYY hh:mm:ss') AS start_time, ");
		sqlQuery.append(" TO_CHAR (end_time, 'DD/MM/YYYY hh:mm:ss') AS end_time, slot_sl, reg_no, ");
		sqlQuery.append(" hospital_number ");
		sqlQuery.append(" FROM opd_consultation_web_v ");
		
		return sqlQuery.toString();
		
	}

	public static String opd_consultation_web_v_grid() {
		
		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append(" SELECT ");
		sqlQuery.append(" rownum srlno, ");
		sqlQuery.append(" (SELECT COUNT(1) FROM opd_consultation_web_v) AS total_records ,");
		sqlQuery.append(" opd_consultation_no, opd_consultation_id, ");
		sqlQuery.append(" TO_CHAR (consultation_time, 'DD/MM/YYYY hh:mm:ss') AS appoint_date, ");
		sqlQuery.append(" DOCTOR_NO AS doctor_no,CONSULT_IN AS consult_in, CONSULT_OUT AS consult_out, ");
		sqlQuery.append(" patient_name AS full_name, ");
		sqlQuery.append(" phone_mobile AS mobile, age, gender AS sex, m_status, ");
		sqlQuery.append(" blood_group AS bloodgroup, pe_addr1 AS address, consult_type_no,");
		sqlQuery.append(" consultation_type_desc, doctor_name, doc_degree, ");
		sqlQuery.append(" shiftdtl_no, TO_CHAR (start_time, 'DD/MM/YYYY hh:mm:ss') AS start_time, ");
		sqlQuery.append(" TO_CHAR (end_time, 'DD/MM/YYYY hh:mm:ss') AS end_time, slot_sl, reg_no, ");
		sqlQuery.append(" hospital_number ");
		sqlQuery.append(" FROM opd_consultation_web_v ");
		sqlQuery.append("  ORDER BY SRLNO ");
		
		
		
		return sqlQuery.toString();
		
	}

	
	public static String hpms_emp_doctor_v_find_by_doctor_number(Long doctorNo) {			
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(" select doctor_no, doctor_name,doctor_signature from  hpms_emp_doctor_v where doctor_no = ");
		sqlQuery.append(doctorNo);
		
		return sqlQuery.toString();
		
	}
	
	public static String hpms_emp_doctor_v_find_by_doctor_number_new(Long doctorNo) {			
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(" select doctor_no, doctor_name,doctor_signature from hpms_doctor_v where doctor_no = ");
		sqlQuery.append(doctorNo);
		
		return sqlQuery.toString();
		
	}
	
	public static String updateOpdAppointment() {			
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(" Update opd_appointment set CONSULT_OUT = 1  where APPOINT_NO = ? ");
		return sqlQuery.toString();
		
	}
	
	public static String updateOpdtConsIn() {			
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(" Update opd_appointment set CONSULT_IN = 1  where APPOINT_NO = ? ");
		return sqlQuery.toString();
		
	}
	
}
