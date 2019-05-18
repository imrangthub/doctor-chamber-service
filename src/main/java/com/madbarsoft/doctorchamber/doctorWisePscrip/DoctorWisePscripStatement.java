package com.madbarsoft.doctorchamber.doctorWisePscrip;

import org.springframework.stereotype.Component;

import com.madbarsoft.doctorchamber.util.CommonFunctions;

@Component
public class DoctorWisePscripStatement implements CommonFunctions {
	
	public static String doctorList() {

		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append(" SELECT ");
		
		sqlQuery.append(" DOCTOR_NO AS doctorNo, ");
		sqlQuery.append(" DOCTOR_ID AS doctorId, ");
		sqlQuery.append(" DOCTOR_NAME AS doctorName, ");
		sqlQuery.append(" SPECIALIZATION_NAME AS dpecialization ");
		sqlQuery.append(" FROM HPMS_CONSULTING_DOC_V ");

		return sqlQuery.toString();

	}
	
	public static String findByDocotId(String doctorId) {

		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append(" SELECT ");
		
		sqlQuery.append(" DOCTOR_NO AS doctorNo, ");
		sqlQuery.append(" DOCTOR_ID AS doctorId, ");
		sqlQuery.append(" DOCTOR_NAME AS doctorName, ");
		sqlQuery.append(" SPECIALIZATION_NAME AS dpecialization ");
		sqlQuery.append(" FROM HPMS_CONSULTING_DOC_V ");
		sqlQuery.append(" where DOCTOR_ID =  ");
		sqlQuery.append("'");
		sqlQuery.append(doctorId);
		sqlQuery.append("'");
	
		return sqlQuery.toString();

	}
	
	public static String findByDocotNo(Long doctorNo) {

		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append(" SELECT ");
		
		sqlQuery.append(" DOCTOR_NO AS doctorNo, ");
		sqlQuery.append(" DOCTOR_ID AS doctorId, ");
		sqlQuery.append(" DOCTOR_NAME AS doctorName, ");
		sqlQuery.append(" SPECIALIZATION_NAME AS dpecialization ");
		sqlQuery.append(" FROM HPMS_CONSULTING_DOC_V ");
		sqlQuery.append(" where DOCTOR_NO =  ");
		sqlQuery.append("'");
		sqlQuery.append(doctorNo);
		sqlQuery.append("'");
	
		return sqlQuery.toString();

	}

	public static String doctor_wise_pscrip_web_v_grid() {

		StringBuilder sqlQuery = new StringBuilder();

		sqlQuery.append(" SELECT ");
		sqlQuery.append(" (SELECT COUNT(1) FROM HPMS_CONSULTING_DOC_V) AS total_records ,");
		sqlQuery.append(" DOCTOR_NO AS doctorNo, ");
		sqlQuery.append(" DOCTOR_ID AS doctorId, ");
		sqlQuery.append(" DOCTOR_NAME AS doctorName, ");
		sqlQuery.append(" SPECIALIZATION_NAME AS dpecialization ");
		sqlQuery.append(" FROM HPMS_CONSULTING_DOC_V ");
		sqlQuery.append(" ORDER BY DOCTOR_NO ");

		//System.out.println("Oracal Execuited Query for DoctorWisePscrip:" + sqlQuery.toString());
		return sqlQuery.toString();

	}

}
