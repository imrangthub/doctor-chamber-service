package com.madbarsoft.doctorchamber.ipdPrescription;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;




/**
 * @author Mohammad lockman
 *
 */
@Component
public class IpdPrescriptionStatement {
	public static String ipd_nurse_station_list_medicare_live(Long userNo) {			
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT '<<All Nurse Station>>' NS_NAME, NULL NS_NO FROM DUAL UNION  ");
		sqlQuery.append(" SELECT DISTINCT R.FLOOR_NAME||'>'||R.ROOM_NAME||' ('||R.ROOM_ID||')' NS_NAME, TO_CHAR(R.ROOM_NO) NS_NO  ");
		sqlQuery.append(" FROM HPMS_ROOM_V R, SA_GRANTNS NS  ");
		sqlQuery.append(" WHERE R.ROOM_NO = NS.NSROOM_NO  ");
		sqlQuery.append(" AND R.NURSE_STATION_FLAG = 1  ");
		sqlQuery.append(" AND NS.USER_NO = ");
		sqlQuery.append(userNo);
		sqlQuery.append(" ORDER BY NS_NO NULLS FIRST");		
		return sqlQuery.toString();
		
	}
	
//	public static String ipd_room_medicare_live(Long roomNo) {			
//		StringBuilder sqlQuery = new StringBuilder();
//		sqlQuery.append("select ward_no from HPMS_ORGROOM_TYPE_MAP where room_no = ");
//		sqlQuery.append(roomNo);		
//		return sqlQuery.toString();		
//	}
	
	public static String ipd_room_medicare_live(List<String> roomNoList) {	
		String rooms=null;
		if(roomNoList!=null && roomNoList.size()>0) {			
			rooms = roomNoList.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(","));
		}
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("select ward_no from HPMS_ORGROOM_TYPE_MAP where room_no in ( ");
		sqlQuery.append(rooms);
		sqlQuery.append(")");
		return sqlQuery.toString();		
	}
	
	public static String ipd_ns_room_no_medicare_live(String userNo) {			
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("select a.NSROOM_NO from SA_GRANTNS a where a.USER_NO = ");
		sqlQuery.append(userNo);
	    sqlQuery.append("and a.ALL_NSROOM_NO = 1");
		return sqlQuery.toString();		
	}
	
	public static String ipd_patient_list_medicare_live(List<String> wordNoList) {	
		String words=null;
		if(wordNoList!=null && wordNoList.size()>0) {			
			words = wordNoList.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(","));
		}
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("select * from IPD_PATLIST_NS_V_WEB where cabin_ward_no in ( ");
		sqlQuery.append(words);
	    sqlQuery.append(")");
		return sqlQuery.toString();		
	}
	
	
}
