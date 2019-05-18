package com.madbarsoft.doctorchamber.integration;



import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class IntegrationEntity {

	private Long opdCondtlNo;
	private String opdCondtlId;
	private Long appointmentNo;
	private Long opdConsultationNo;
	private Long itemNo; 
	private Long itemtypeNo;
	private int itemQty;
	private int deliveryStatusNo;
	private String itemName;
	
	private Long ssModifier;
	private Date ssModifiedOn;
	private int ssIsDeleted;
	
	private Long itemGroup;
	private Long uomNo;
	private Long genericNo;
	private String medDose;
	private String medRoute; 
	private Long medDuration;
	private String medDurationMu;
	private Long subitemtypeNo;
	
	
	private Long ssCreator;    
	private Date ssCreatedOn;
	private Long companyNo;  

    
    
}
