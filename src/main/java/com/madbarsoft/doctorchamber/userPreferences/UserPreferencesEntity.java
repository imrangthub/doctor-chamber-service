package com.madbarsoft.doctorchamber.userPreferences;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prescription_user_preferences")
public class UserPreferencesEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	@NotNull
	@Column(name = "preferences_type")
	private String userPreferencesType;

	@NotNull
	@Column(name = "preferences_data_type")
	private int preferencesDataType; // 1 for check, 2 for radio 3 text 4 for textarea

	@NotNull
	@Column(name = "preferences_serial")
	private int preferencesSerial;

	@NotNull
	@Column(name = "user_preferences_key", unique = true)
	private String userPreferencesKey;
	
	@Column(name = "user_preferences_value")
	private String userPreferencesValue;
	
	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "show_in_report")
	private int preferencesShowInReport = 1;
	
	@NotNull
	@Column(name = "show_in_tab")
	private int preferencesShowInTab = 1; // 0 for not -- 1 for Yes --- To show in home tab. 
	
	@NotNull
	@Column(name = "user_no")
	private Long userNo;                // doctorNo

}

