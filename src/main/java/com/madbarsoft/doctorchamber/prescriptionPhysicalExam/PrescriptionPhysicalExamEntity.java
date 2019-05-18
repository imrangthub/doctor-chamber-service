package com.madbarsoft.doctorchamber.prescriptionPhysicalExam;

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
import com.madbarsoft.doctorchamber.physicalExamGroup.PhysicalExamGroupEntity;
import com.madbarsoft.doctorchamber.physicalExamination.PhysicalExaminationEntity;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prescription_physical_exam")
public class PrescriptionPhysicalExamEntity  extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "exam_name")
    private String examName;

    @Column(name = "exam_unit")
    private String examUnit;
	
    @Column(name = "exam_result", length = 4000)
    private String examResult;

    @Column(name = "exam_data_type")
	private int examDataType; // 1 for vital, 2 for general exam, 3 for examination 4 for systemic Examination    
	
    @Transient
	private Integer isDeleted;  
    
	@Column(nullable = false, name = "is_bold", length = 1)
	private Integer isBold = 0;

	@Column(nullable = false, name = "in_report_serial")
	private Integer inReportSerial = 0;

    @ManyToOne(optional = true)
	@JoinColumn(name = "physical_exam_id")
	private PhysicalExaminationEntity physicalExam;

    @ManyToOne(optional = false)
	@JoinColumn(name = "exam_group_id")
	private PhysicalExamGroupEntity examGroup;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prescription_no", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PrescriptionEntity prescription;

}
