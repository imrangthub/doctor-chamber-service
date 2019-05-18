package com.madbarsoft.doctorchamber.doctorWisePscrip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DoctorWisePscripDto {
	
    private Long doctorNo;
	
	private String doctorId;
	
	private String doctorName;
	
	private String dpecialization;
	
	private Long totalRecord;
	

}
