package com.madbarsoft.doctorchamber.investigationResult;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class LabNonLabReportEntity {

	private Long regNo;
	private Long itemNo;
	private String itemId;
	private String itemName;
	private Long buNo;
	private String buName;
	private Long totalTest;
	private String billInvoiceDateStr;
	private Date billInvoiceDate;

}
