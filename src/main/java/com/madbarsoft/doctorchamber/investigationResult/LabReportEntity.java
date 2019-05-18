package com.madbarsoft.doctorchamber.investigationResult;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class LabReportEntity {

	private String stampId;
	private String labId;
	private Date resultDate;
	private Long itemNo;
	private Long slNo;
	private String attr;
	private String machineAttrib;
	private String analyzerDesk;
	private String result;
	private String result1;
	private String result2;
	private String result3;
}
