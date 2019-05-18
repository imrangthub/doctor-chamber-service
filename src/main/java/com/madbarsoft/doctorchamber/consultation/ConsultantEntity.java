package com.madbarsoft.doctorchamber.consultation;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ConsultantEntity  {

    private long doctorNo;
    private String doctorName;
    private String doctorSignature;

	
    

}
