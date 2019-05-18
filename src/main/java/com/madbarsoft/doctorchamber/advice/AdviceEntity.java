package com.madbarsoft.doctorchamber.advice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "advice", uniqueConstraints = {@UniqueConstraint(columnNames = {"short_code", "doctor_no"})})
public class AdviceEntity extends BaseEntity implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@NotNull
    @Column(name = "short_code")
    private String shortCode;
	
	@NotNull
    @Column(name = "advice_eng")
    private String adviceEng;
	
	@NotNull
    @Column(name = "advice_local")
    private String adviceLocal;

    @Column(name = "doctor_no")
    private Long doctorNo;

}

