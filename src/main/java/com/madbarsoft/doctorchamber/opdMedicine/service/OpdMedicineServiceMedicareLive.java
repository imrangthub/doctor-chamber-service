package com.madbarsoft.doctorchamber.opdMedicine.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.madbarsoft.doctorchamber.opdMedicine.repository.OpdMedicineRepositoryMedicareLive;
import com.madbarsoft.doctorchamber.util.Response;

public class OpdMedicineServiceMedicareLive implements OpdMedicineService{

	@Autowired
	OpdMedicineRepositoryMedicareLive opdMedicineRepository;

	@Override
	public Response list(String reqObj) {
		return opdMedicineRepository.list(reqObj);
	}

	@Override
	public Response listOpdMedicine(String reqObj) {
		return opdMedicineRepository.listOpd(reqObj);
	}

	@Override
	public Response listIpdMedicine(String reqObj) {
		return opdMedicineRepository.listIpd(reqObj);
	}

}
