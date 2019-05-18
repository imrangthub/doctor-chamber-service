package com.madbarsoft.doctorchamber.userDataPreferences;

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

@Getter
@Setter
@Entity
@Table(name = "user_preferences_data")
public class UserDataPreferencesEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "data_no")
	private Long userPrefDataNo;

	@Column(name = "data_value")
	private String userPrefDataValue;

	@NotNull
	@Column(name = "data_type")
	private int userPrefDataType;

    @Column(name = "brand_name")
    private String userPrefDataBrandName;
	
    @Column(name = "form")
    private String userPrefDataForm;
	
    @Column(name = "strength")
    private String userPrefDataStrength;
    
    @Column(name = "dosage")
    private String userPrefDataDosage;
    
    @Column(name = "duration")
    private String userPrefDataDuration;
    
    @Column(name = "route")
    private String route;
    
    @Column(name = "medicine_comment")
    private String medicineComment;
    
    @Column(name = "relation_with_meal")
    private String userPrefDataRelationWithMeal;
    
    @Column(name = "generic_name")
    private String genericName;    

	@NotNull
	@Column(name = "user_no")
	private Long userNo; // doctorNo

}
