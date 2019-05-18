package com.madbarsoft.doctorchamber.signatureSetup;

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
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "signature_setup")
public class SignatureSetupEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "signature_title")
	private String signatureTitle;

	@NotNull
	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "doctor_degree")
	private String doctorDegree;

	@Column(name = "doctor_no")
	private Long doctorNo;

}
