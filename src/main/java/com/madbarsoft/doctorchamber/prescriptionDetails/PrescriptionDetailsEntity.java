package com.madbarsoft.doctorchamber.prescriptionDetails;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.madbarsoft.doctorchamber.base.BaseEntity;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prescription_details")
public class PrescriptionDetailsEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "prescrition_data_type")
	private int prescritionDataType;                 // 1 for Investigation

	@Column(nullable = false, name = "prescrition_data", length = 4000)
	private String prescritionData;

	@Column(name = "reference_id")
	private Long referenceId;

	@Column(name = "head_no")
	private Long headNo;

	@Transient
	private Integer isPrintable;

	@Transient
	private Integer isDeleted;

	@Column(nullable = false, name = "is_bold", length = 1)
	private Integer isBold = 0;   // 1 for bold 2 for Italic

	@Column(nullable = false, name = "in_report_serial")
	private Integer inReportSerial = 0;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "prescription_no", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private PrescriptionEntity prescription;

}
