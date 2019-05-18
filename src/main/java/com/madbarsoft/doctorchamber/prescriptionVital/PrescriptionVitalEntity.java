package com.madbarsoft.doctorchamber.prescriptionVital;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.madbarsoft.doctorchamber.base.BaseEntity;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.vital.VitalEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prescription_vital")
public class PrescriptionVitalEntity  extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "vital_name")
    private String vitalName;

    @Column(name = "vital_unit")
    private String vitalUnit;
	
    @Column(name = "vital_result")
    private String vitalResult;
    
    @OneToOne
	@JoinColumn(name = "vital_id")
	private VitalEntity vitalEntity;
	
    @Transient
	private Integer isDeleted;   	
	
	@Column(nullable = false, name = "is_bold", length = 1)
	private Integer isBold = 0;

	@Column(nullable = false, name = "in_report_serial")
	private Integer inReportSerial = 0;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prescription_no", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PrescriptionEntity prescription;

}
