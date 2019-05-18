package com.madbarsoft.doctorchamber.ipdPrescription;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class PatientRequestParamEntity {
	String roomNo;
	String userNo;
}
