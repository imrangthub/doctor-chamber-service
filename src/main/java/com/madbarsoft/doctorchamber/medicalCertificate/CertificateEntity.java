package com.madbarsoft.doctorchamber.medicalCertificate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Mohammad lockman
 *
 */
@Getter
@Setter
@Entity
@Table(name = "pat_medical_certificate")
public class CertificateEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	//@NonNull
	private Long id;

	@NotNull
	@Column(name = "hospital_no")
	private String hospitalNo;
	
	@Column(name = "consultation_no")
	private String consultationNo;
	
	@Column(name = "doctor_no")
	private Long doctorNo;

	@NotNull
	@Column(nullable = false, length = 4000)
	private String certificateText;
	
	@NotNull
	@Column(nullable = false)
	private Integer type;
	
}
