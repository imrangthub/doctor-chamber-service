package com.madbarsoft.doctorchamber.autoComplete;

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
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "auto_complete")
public class AutoCompleteEntity extends BaseEntity implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@NotNull
    @Column(name = "auto_key")
    private String autoKey;
	
	@NotNull
    @Column(name = "auto_com_type")
    private Integer autoComType;
	
    @Column(name = "auto_com_val_eng")
    private String autoComValEng;
	
    @Column(name = "auto_com_val_local")
    private String autoComValLocal;

    @Column(name = "doctor_no")
    private Long doctorNo;

}

