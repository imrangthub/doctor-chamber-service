package com.madbarsoft.doctorchamber.presForm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pres_form")
public class PresFormEntity extends BaseEntity implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
    @Column(name = "id")
    private Long id;

	@NotNull
    @Column(name = "form_name")
    private String formName;
	
	@NotNull
    @Column(name = "form_link")
    private String formLink;
	
}

