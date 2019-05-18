package com.madbarsoft.doctorchamber.manufacturer;

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
@Setter
@Getter
@Entity
@Table(name = "manufacturer")
public class ManufacturerEntity extends BaseEntity implements Serializable {

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
    private String manufactName;

	@NotNull
    @Column(name = "description")
    private String description;
	
	
	public ManufacturerEntity() {}
	
	public ManufacturerEntity(Long id) {
		this.id = id;
	}

	
	
	
}
