package com.madbarsoft.doctorchamber.consultation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "consultation")
public class ConsultationEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String hospitalNo;

	private Long appointmentNo;

	private Long consultationNo;

	private Date consultationDt;

	private Date consultationTime;

	private Date appointmentDt;

	private String consultationDtStr;

	private String consultationId;

	private String doctorName;

	private Long doctor_no;

	private Long consult_in;

	private Long consult_out;

	private String patientName;

	private String gender;

	private String age;

	private Date dob;

	private String maritalStatus;

	private String bloodGroup;

	private String phoneNo;

	private String consultationType; // 4 for Report Check/ 1 for New Patient/ 2 for 1st Follow Up/ 3 for 2nd Follow
										// Up/ 8 for SPECIALIST/ 8 for Dialysis Patient Fee/6 for Transplant Patient
										// Fee/ 7 for CAPD Patient Fee

	private Long shiftdtlNo;

	private Long slotSerial;

	private String startTime;

	private String endTime;

	private Long totalRecord;
	
	
	 @Transient	
	 private Date fromDate;
	 
	 @Transient
	 private Date toDate;

}
