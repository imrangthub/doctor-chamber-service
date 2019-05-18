package com.madbarsoft.doctorchamber.opdMedicine;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpdMedicineEntity implements Serializable {

	private static final long serialVersionUID = 1L;

    private Long itemNo;    
    private String itemId;
    private String brandName;
    private String dosage;
    private String duration;
    private String form;
    private int prescritionDataType=4;        
    private String relationWithMeal;
    private String strength;
    private String route;
    
	private Long referenceId;
    private String manufacturer;
    private String genericName;
    private Long stock;

}
