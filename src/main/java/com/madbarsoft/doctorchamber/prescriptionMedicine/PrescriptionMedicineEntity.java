package com.madbarsoft.doctorchamber.prescriptionMedicine;

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
@Table(name = "prescription_medicine")
public class PrescriptionMedicineEntity  extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "item_no")
    private String itemNo;
	
    @Column(name = "item_qty")
    private String itemQty = "";
	
    @Column(name = "brand_name")
    private String brandName;
	
    @Column(name = "form")
    private String form;
	
    @Column(name = "strength")
    private String strength;
    
    @Column(name = "dosage")
    private String dosage;
    
    @Column(name = "duration")
    private String duration;
    
    @Column(name = "relation_with_meal")
    private String relationWithMeal;
    
    @Column(name = "route")
    private String route;
    
    @Column(name = "medicine_comment")
    private String medicineComment;
    
    @Column(name = "prescrition_data_type")
    private int prescritionDataType=4;
    
    @Column(name = "reference_id")
	private Long referenceId;
    
    @Column(name = "generic_name")
    private String genericName;
	
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
