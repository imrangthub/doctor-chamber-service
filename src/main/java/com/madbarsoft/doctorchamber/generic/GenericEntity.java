package com.madbarsoft.doctorchamber.generic;

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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.madbarsoft.doctorchamber.base.BaseEntity;
import com.madbarsoft.doctorchamber.group.GroupEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "generic")
public class GenericEntity extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@NotNull
    @Column(name = "name")
    private String genericName;

    @Column(name = "description")
    private String description;
	
    @Column(name = "indications")
    private String indications;
	
    @Column(name = "side_efects")
    private String sideEfects;
	
    @Column(name = "doses")
    private String doses;

    @Column(name = "doses_info")
    private String dosesInfo;
	
    @Column(name = "default_dose_bn")
    private String defaultDoseBn;

    @Column(name = "default_dose_en")
    private String defaultDoseEn;
	
    @Column(name = "pregnancy_info")
    private String pregnancyInfo;
	
    @Column(name = "lactation_info")
    private String lactationInfo;
	
    @Column(name = "liver_disease_info")
    private String liverDiseaseInfo;

    @Column(name = "renal_disease_info")
    private String renalDiseaseInfo;
	
    @Column(name = "other_precautions")
    private String otherPrecautions;
	
    @Column(name = "contraindication")
    private String contraindication;
	
    @Column(name = "min_age")
    private Long minAge;

    @Column(name = "max_age")
    private Long maxAge;
	
    @Column(name = "age_message")
    private String age_message;
		
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_no", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private GroupEntity group;  
    
    
    public GenericEntity() {}
    
    public GenericEntity(Long id) {
    	this.id=id;
    }
	
	
	
	    
}
