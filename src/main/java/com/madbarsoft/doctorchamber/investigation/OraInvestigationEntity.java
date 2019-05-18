package com.madbarsoft.doctorchamber.investigation;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Component
public class OraInvestigationEntity{


	private Long itemNo;
	private String itemId;
	private String itemCustomName;
	private String itemName;
	private Integer itemTypeNo;
	private Long departmentNo;
	private String departmentName;

}
