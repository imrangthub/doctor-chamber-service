package com.madbarsoft.doctorchamber.preferences;

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
@Table(name = "prescription_preferences")
public class PreferencesEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@NotNull
	@Column(name = "title")
	private String title;
	
	@NotNull
	@Column(name = "preferences_type")
	private String preferencesType;
	
	@NotNull
	@Column(name = "preferences_data_type")
	private int preferencesDataType = 1; // 1 for check, 2 for radio 3 input text 4 for textarea
	
	@NotNull
	@Column(name = "preferences_serial")
	private int preferencesSerial;
	
	@NotNull
	@Column(name = "preferences_key", unique = true)
	private String preferencesKey;

	@Column(name = "preferences_value")
	private String preferencesValue = "0";

	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "show_in_report")
	private int preferencesShowInReport = 1; // 0 for not -- 1 for Yes --- 2 for not relevant with Report 
	
	@NotNull
	@Column(name = "show_in_tab")
	private int preferencesShowInTab = 1; // 0 for not -- 1 for Yes --- To show in home tab. 
	
	
	
}
