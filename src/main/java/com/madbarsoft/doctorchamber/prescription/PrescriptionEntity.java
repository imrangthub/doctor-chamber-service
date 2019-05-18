package com.madbarsoft.doctorchamber.prescription;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prescription")
public class PrescriptionEntity  extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "hospital_id")
	private String hospitalId;

	@Column(name = "consultant_no")
	private Long consultationNo;

	@Column(name = "consultant_id")
	private String consultationId;
    
	@Column(name = "doctor_no")
    private Long doctorNo;
    
    @Column(name = "appointment_no")
    private Long appointmentNo;
    
    @Column(name = "is_patient_in", columnDefinition = "int default 0")
	private int isPatientIn;

    @Column(name = "is_patient_out", columnDefinition = "int default 0")
	private int isPatientOut;

}
