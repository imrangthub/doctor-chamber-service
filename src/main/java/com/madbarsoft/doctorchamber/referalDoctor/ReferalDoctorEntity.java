package com.madbarsoft.doctorchamber.referalDoctor;

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
@Table(name = "referal_doctor")
public class ReferalDoctorEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NonNull
	private Long id;
	
	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "address")
	private String doctorAddress;
	
	@Column(name = "doctor_signature")
	private String doctorSignature;
}
