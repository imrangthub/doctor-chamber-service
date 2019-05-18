package com.madbarsoft.doctorchamber.ipdPrescription;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mohammad lockman
 *
 */

@Getter
@Setter
@Component
public class IpdPatientEntity {
	Long admission_no;
	String admission_id;
	String hospital_number;
	Long reg_no;
	Long init_bed_no;
	String init_bed_id;
	Long bed_no;
	String bed_id;
	String bed_name;
	Integer primary_flag;
	String active_beds;
	Long mother_bed_no;
	String patient_name;
	String gender;
	Date dob;
	String age;
	String marital_status;
	Date admission_date;
	String created_by;
	String contact_phone;
	String religion;
	Integer dis_req_flag;
	Integer dis_req_by;
	Date dis_req_timestamp;
	Integer dk_clear_flag;
	Date dk_clear_timestamp;
	String dis_reason;
	Integer dis_flag;
	Date dis_timestamp;
	String dis_advice;
	Integer dis_confirm_flag;
	Integer dis_confirm_by;
	Date dis_followup_dt;
	Integer pat_receive_flag;
	Integer pat_received_by;
	String pat_received_name;
	Date pat_received_timestamp;
	Integer ipd_trans_req_flag;
	Date ipd_trans_req_timestamp;
	Long ipd_transfer_suggested_bed;
	Long ref_doctor_no;
	String ref_doc_name;
	Long adm_under_doc_id;
	String adm_under_doc_name;
	Long primary_doctor_no;
	String primary_doctor_name;
	Integer selected_flag;
	String admission_type;
	Integer emp_no;
	String emp_id;
	Long cor_client_no;
	String cor_client_empid;
	Long cor_relation_no;
	String mailing_address;
	Long cabin_ward_no;
	String ward_id;
	String ward_name;
	Long room_no;
	String room_id;
	String room_name;
	String patient_status;
	String patient_type;
	String phone_mobile;
}
