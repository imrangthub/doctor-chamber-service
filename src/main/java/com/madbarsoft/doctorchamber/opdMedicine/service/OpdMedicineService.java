package com.madbarsoft.doctorchamber.opdMedicine.service;

import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;


@Service
public interface OpdMedicineService {

	public Response list(String  reqObj);
	public Response listOpdMedicine(String  reqObj);
	public Response listIpdMedicine(String  reqObj);
	
}
