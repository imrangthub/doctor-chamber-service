package com.madbarsoft.doctorchamber.setup.head;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "setup_head")
public class HeadEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "head_name")
	private String headName;

	@NotNull
	@Column(name = "head_name_print")
	private String headNamePrint;

	@NotNull
	@Column(name = "data_type")
	private Integer dataType;
	
	@Column(name = "is_printable")
	private Boolean isPrintable = true;
	
	@Transient
	private Integer isDeleted = 0;
	
	@Column(name = "doctor_no")
	private Long doctorNo;
	
	
}
