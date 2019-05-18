package com.madbarsoft.doctorchamber.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.madbarsoft.doctorchamber.authentication.service.AuthService;
import com.madbarsoft.doctorchamber.authentication.service.AuthServiceMedicareLive;
import com.madbarsoft.doctorchamber.authentication.service.AuthServiceMedicareNew;
import com.madbarsoft.doctorchamber.consultation.service.ConsultationService;
import com.madbarsoft.doctorchamber.consultation.service.ConsultationServiceMedicareLive;
import com.madbarsoft.doctorchamber.consultation.service.ConsultationServiceMedicareNew;
import com.madbarsoft.doctorchamber.integration.service.IntegrationService;
import com.madbarsoft.doctorchamber.integration.service.IntegrationServiceMedicareLive;
import com.madbarsoft.doctorchamber.integration.service.IntegrationServiceMedicareNew;
import com.madbarsoft.doctorchamber.ipdPrescription.service.IpdPrescriptinService;
import com.madbarsoft.doctorchamber.ipdPrescription.service.IpdPrescriptionServiceMedicareLive;
import com.madbarsoft.doctorchamber.ipdPrescription.service.IpdPrescriptionServiceMedicareNew;
import com.madbarsoft.doctorchamber.opdMedicine.service.OpdMedicineService;
import com.madbarsoft.doctorchamber.opdMedicine.service.OpdMedicineServiceMedicareLive;
import com.madbarsoft.doctorchamber.opdMedicine.service.OpdMedicineServiceMedicareNew;


@Configuration
public class AppConfig {

	@Autowired
	private Environment env;
		
	@Bean
	AuthService authService() {
		if(env.getProperty("service.servicename").equals("MedicareNew")) {
			return new AuthServiceMedicareNew();			
		} else if(env.getProperty("service.servicename").equals("MedicareLive")) {
			return new AuthServiceMedicareLive();
		} else return null;
	}	

	@Bean
	ConsultationService consultationService() {
		if(env.getProperty("service.servicename").equals("MedicareNew")) {
			return new ConsultationServiceMedicareNew();			
		} else if(env.getProperty("service.servicename").equals("MedicareLive")) {
			return new ConsultationServiceMedicareLive();
		} else return null;
	}

	@Bean
	IntegrationService IntegrationService() {
		if(env.getProperty("service.servicename").equals("MedicareNew")) {
			return new IntegrationServiceMedicareNew();			
		} else if(env.getProperty("service.servicename").equals("MedicareLive")) {
			return new IntegrationServiceMedicareLive();
		} else return null;
	}
	
	@Bean
	IpdPrescriptinService IpdPrescriptinService() {
		if(env.getProperty("service.servicename").equals("MedicareNew")) {
			return new IpdPrescriptionServiceMedicareNew();			
		} else if(env.getProperty("service.servicename").equals("MedicareLive")) {
			return new IpdPrescriptionServiceMedicareLive();
		} else return null;
	}

	@Bean
	OpdMedicineService opdMedicineService() {
		if(env.getProperty("service.servicename").equals("MedicareNew")) {
			return new OpdMedicineServiceMedicareNew();
		} else if(env.getProperty("service.servicename").equals("MedicareLive")) {
			return new OpdMedicineServiceMedicareLive();
		} else return null;
	}


	
}

