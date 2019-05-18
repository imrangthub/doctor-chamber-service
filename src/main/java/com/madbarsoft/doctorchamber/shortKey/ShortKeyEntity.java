package com.madbarsoft.doctorchamber.shortKey;

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
@Table(name = "short_key")
public class ShortKeyEntity extends BaseEntity implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@NotNull
    @Column(name = "short_code")
    private String shortCode;
	
	@NotNull
    @Column(name = "short_val_eng")
    private String shortValEng;
	
    @Column(name = "short_val_local")
    private String shortValLocal;

    @Column(name = "doctor_no")
    private Long doctorNo;

}
