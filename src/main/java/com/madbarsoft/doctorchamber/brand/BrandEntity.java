package com.madbarsoft.doctorchamber.brand;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.madbarsoft.doctorchamber.base.BaseEntity;
import com.madbarsoft.doctorchamber.generic.GenericEntity;
import com.madbarsoft.doctorchamber.manufacturer.ManufacturerEntity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "brand")
public class BrandEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NonNull private Long id;

	@NotNull
    @Column(name = "name")
    private String brandName;

    @Column(name = "form")
    private String form;
	
    @Column(name = "strength")
    private String strength;

    @Column(name = "unit")
    private String unit;

    @Column(name = "map_no")
    private Long map_no;
	
    @Column(name = "price")
    private Double price;

    @Column(name = "preferred")
    private String preferred;
	
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "generic_no", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private GenericEntity generic;    
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "manufacturer_no", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ManufacturerEntity manufacturer;    
	
	
    
    

}
