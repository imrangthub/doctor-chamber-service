package com.madbarsoft.doctorchamber.medicalCertificateTemplate;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum CertificateTemplateTag {

	MaritalStatus("@MaritalStatus"), MobileNumber("@Mobile"), Gender("@Gender"), Age("@Age"), FullName("@FullName"),
	CurrentDate("@CurrentDate"),PatientId("@PatientId"), ConsultationId("@ConsultationId"), BloodGroup("@BloodGroup"), DateOfBirth("@DateOfBirth");

	private String value;

	private CertificateTemplateTag(String value) {
		this.value = value;
	}

	public static Map getAllTag() {
		Map<String, String> tagMap = new HashMap<String, String>();
		for (CertificateTemplateTag r : CertificateTemplateTag.values()) {
			tagMap.put(r.name(), r.getValue());
		}
		return tagMap;
	}

}