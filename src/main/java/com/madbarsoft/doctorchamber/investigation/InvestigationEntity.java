package com.madbarsoft.doctorchamber.investigation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.Setter;
import lombok.Getter;
@Setter
@Getter
@Entity
@Table(name = "investigation")
public class InvestigationEntity extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "integrate_no")
    private Long integrateNo;

    @Column(name = "integrate_id")
    private String integrateId;

	@NotNull
    @Column(name = "integrate_name")
    private String invesName;

	@NotNull
    @Column(name = "custome_name")
    private String InvesCustomeName;


    @Column(name = "map_code")
    private String invesMapCode;
	
	@NotNull
    @Column(name = "doctor_no")
    private Long doctorNo;

	
	
	

}
