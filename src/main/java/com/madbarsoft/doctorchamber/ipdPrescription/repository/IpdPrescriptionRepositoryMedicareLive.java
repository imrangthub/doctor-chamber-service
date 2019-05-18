package com.madbarsoft.doctorchamber.ipdPrescription.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.consultation.statement.ConsultationStatementMedicareNew;
import com.madbarsoft.doctorchamber.ipdPrescription.IpdNurseStationEntity;
import com.madbarsoft.doctorchamber.ipdPrescription.IpdPatientEntity;
import com.madbarsoft.doctorchamber.ipdPrescription.IpdPrescriptionStatement;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class IpdPrescriptionRepositoryMedicareLive extends BaseRepository {
	private static final Logger logger = LoggerFactory.getLogger(IpdPrescriptionRepositoryMedicareLive.class);

	@Autowired
	ConsultationStatementMedicareNew consulationStatement;

	public Response getNurseStationList(Long userNo) {
		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		con = getOraConnection();
		IpdNurseStationEntity ipdNurseStationEntity =null;
		List<IpdNurseStationEntity> list = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(IpdPrescriptionStatement.ipd_nurse_station_list_medicare_live(userNo));

			while (rs.next()) {
				ipdNurseStationEntity= new IpdNurseStationEntity();
				ipdNurseStationEntity.setStationName(rs.getString("NS_NAME"));
				ipdNurseStationEntity.setStationNo(rs.getString("NS_NO"));	
				list.add(ipdNurseStationEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finalyConStmRs(con, stm, rs);
		}
		response.setItems(list);
		return getSuccessResponse("Nurse Station List found", response);	
	}
	
	
	public List<String> getWordNoList(List<String> roomNoList){
		List<String> wordNoList =   new ArrayList<String>();
	
		
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		con = getOraConnection();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(IpdPrescriptionStatement.ipd_room_medicare_live(roomNoList));
			while (rs.next()) {				
				wordNoList.add(rs.getString("ward_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finalyConStmRs(con, stm, rs);
		}
		
		return wordNoList;
	}
	
	public List<String> getNsRoomNoList(String userNo){
		List<String> roomNoList =   new ArrayList<String>();		
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		con = getOraConnection();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(IpdPrescriptionStatement.ipd_ns_room_no_medicare_live(userNo));
			while (rs.next()) {				
				roomNoList.add(rs.getString("NSROOM_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finalyConStmRs(con, stm, rs);
		}
		
		return roomNoList;
	}

	public Response getpatientList(String roomNo,String userNo) {
		
		List<String> roomNoList =   new ArrayList<String>();
		List<String> wordList =   new ArrayList<String>();
        if(!roomNo.equals("0")) {
        	roomNoList.add(roomNo);
        	wordList = getWordNoList(roomNoList);
        }else {
        	wordList = getWordNoList(getNsRoomNoList(userNo));
        }
                                        
		Response response = new Response();
		Connection con = null;
		ResultSet rs = null;
		Statement stm = null;
		con = getOraConnection();
		IpdPatientEntity ipdPatientEntity =null;
		List<IpdPatientEntity> patientList = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(IpdPrescriptionStatement.ipd_patient_list_medicare_live(wordList));

			while (rs.next()) {
				ipdPatientEntity= new IpdPatientEntity();
				ipdPatientEntity.setAdmission_no(rs.getLong("admission_no"));
				ipdPatientEntity.setAdmission_id(rs.getString("admission_id"));
				ipdPatientEntity.setHospital_number(rs.getString("hospital_number"));
				ipdPatientEntity.setReg_no(rs.getLong("reg_no"));
				ipdPatientEntity.setInit_bed_no(rs.getLong("init_bed_no"));
				ipdPatientEntity.setInit_bed_id(rs.getString("init_bed_id"));
				ipdPatientEntity.setBed_no(rs.getLong("bed_no"));
				ipdPatientEntity.setBed_id(rs.getString("bed_id"));
				ipdPatientEntity.setBed_name(rs.getString("bed_name"));
				ipdPatientEntity.setPrimary_flag(rs.findColumn("primary_flag"));
				ipdPatientEntity.setActive_beds(rs.getString("active_beds"));
				ipdPatientEntity.setMother_bed_no(rs.getLong("mother_bed_no"));
				ipdPatientEntity.setPatient_name(rs.getString("patient_name"));
				ipdPatientEntity.setGender(rs.getString("gender"));
				ipdPatientEntity.setDob(rs.getDate("dob"));
				ipdPatientEntity.setAge(rs.getString("age"));
				ipdPatientEntity.setMarital_status(rs.getString("marital_status"));
				ipdPatientEntity.setAdmission_date(rs.getDate("admission_date"));
				ipdPatientEntity.setCreated_by(rs.getString("created_by"));
				ipdPatientEntity.setContact_phone(rs.getString("contact_phone"));
				ipdPatientEntity.setReligion(rs.getString("religion"));
				ipdPatientEntity.setDis_req_flag(rs.getInt("dis_req_flag"));
				ipdPatientEntity.setDis_req_by(rs.getInt("dis_req_by"));
				ipdPatientEntity.setDis_req_timestamp(rs.getDate("dis_req_timestamp"));
				ipdPatientEntity.setDk_clear_flag(rs.getInt("dk_clear_flag"));
				ipdPatientEntity.setDk_clear_timestamp(rs.getDate("dk_clear_timestamp"));
				ipdPatientEntity.setDis_reason(rs.getString("dis_reason"));
				ipdPatientEntity.setDis_flag(rs.getInt("dis_flag"));
				ipdPatientEntity.setDis_timestamp(rs.getDate("dis_timestamp"));
				ipdPatientEntity.setDis_advice(rs.getString("dis_advice"));
				ipdPatientEntity.setDis_confirm_flag(rs.getInt("dis_confirm_flag"));
				ipdPatientEntity.setDis_confirm_by(rs.getInt("dis_confirm_by"));
				ipdPatientEntity.setDis_followup_dt(rs.getDate("dis_followup_dt"));
				ipdPatientEntity.setPat_receive_flag(rs.getInt("pat_receive_flag"));
				ipdPatientEntity.setPat_received_by(rs.getInt("pat_received_by"));
				ipdPatientEntity.setPat_received_name(rs.getString("pat_received_name"));
				ipdPatientEntity.setPat_received_timestamp(rs.getDate("pat_received_timestamp"));
				ipdPatientEntity.setIpd_trans_req_flag(rs.getInt("ipd_trans_req_flag"));
				ipdPatientEntity.setIpd_trans_req_timestamp(rs.getDate("ipd_trans_req_timestamp"));
				ipdPatientEntity.setIpd_transfer_suggested_bed(rs.getLong("ipd_transfer_suggested_bed"));
				ipdPatientEntity.setRef_doctor_no(rs.getLong("ref_doctor_no"));
				ipdPatientEntity.setRef_doc_name(rs.getString("ref_doc_name"));
				ipdPatientEntity.setAdm_under_doc_id(rs.getLong("adm_under_doc_id"));
				ipdPatientEntity.setAdm_under_doc_name(rs.getString("adm_under_doc_name"));
				ipdPatientEntity.setPrimary_doctor_no(rs.getLong("primary_doctor_no"));
				ipdPatientEntity.setPrimary_doctor_name(rs.getString("primary_doctor_name"));
				ipdPatientEntity.setSelected_flag(rs.getInt("selected_flag"));
				ipdPatientEntity.setAdmission_type(rs.getString("admission_type"));
				ipdPatientEntity.setEmp_no(rs.getInt("emp_no"));
				ipdPatientEntity.setEmp_id(rs.getString("emp_id"));
				ipdPatientEntity.setCor_client_no(rs.getLong("cor_client_no"));
				ipdPatientEntity.setCor_client_empid(rs.getString("cor_client_empid"));
				ipdPatientEntity.setCor_relation_no(rs.getLong("cor_relation_no"));
				ipdPatientEntity.setMailing_address(rs.getString("mailing_address"));
				ipdPatientEntity.setCabin_ward_no(rs.getLong("cabin_ward_no"));
				ipdPatientEntity.setWard_id(rs.getString("ward_id"));
				ipdPatientEntity.setWard_name(rs.getString("ward_name"));
				ipdPatientEntity.setRoom_no(rs.getLong("room_no"));
				ipdPatientEntity.setRoom_id(rs.getString("room_id"));
				ipdPatientEntity.setRoom_name(rs.getString("room_name"));
				ipdPatientEntity.setPatient_status(rs.getString("patient_status"));
				ipdPatientEntity.setPatient_type(rs.getString("patient_type"));
				ipdPatientEntity.setPhone_mobile(rs.getString("phone_mobile"));				
				patientList.add(ipdPatientEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finalyConStmRs(con, stm, rs);
		}
		response.setItems(patientList);
		return getSuccessResponse("Nurse Station List found", response);	
                      		
	}

}
