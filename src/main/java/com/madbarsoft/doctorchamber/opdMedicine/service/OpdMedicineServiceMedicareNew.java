package com.madbarsoft.doctorchamber.opdMedicine.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.madbarsoft.doctorchamber.opdMedicine.repository.OpdMedicineRepositoryMedicareNew;
import com.madbarsoft.doctorchamber.util.Response;

public class OpdMedicineServiceMedicareNew implements OpdMedicineService {

	@Autowired
	OpdMedicineRepositoryMedicareNew opdMedicineRepository;

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
