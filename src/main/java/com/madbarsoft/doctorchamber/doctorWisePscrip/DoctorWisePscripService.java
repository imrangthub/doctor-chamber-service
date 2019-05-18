package com.madbarsoft.doctorchamber.doctorWisePscrip;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class DoctorWisePscripService {

	@Autowired
	private DoctorWisePscripRepository doctorWisePscripRepository;

	public Response list(DoctorWisePscripEntity obj) {
		return doctorWisePscripRepository.list(obj);
	}
	
	public Response doctorList(String params) {
		return doctorWisePscripRepository.doctorList(params);
	}
	
	public Response gridList(HttpServletRequest request) {
		return doctorWisePscripRepository.gridList(request);
	}
	
	public DoctorWisePscripEntity findbyDoctorNo(Long doctorNo) {
		return doctorWisePscripRepository.findbyDoctorNo(doctorNo);
	}
	
	public DoctorWisePscripEntity findbyDoctorId(String doctorId) {
		return doctorWisePscripRepository.findByDoctorId(doctorId);
	}

	public Response save(DoctorWisePscripEntity obj) {
		return doctorWisePscripRepository.save(obj);
	}

	public Response update(String reqObj) {
		return doctorWisePscripRepository.update(reqObj);
	}

	public Response delete(Long id) {
		return doctorWisePscripRepository.detele(id);
	}
	
	public Response doctorById(String doctorId) {
		return doctorWisePscripRepository.docotorById(doctorId);
	}
	

	public Response doctorByNo(Long doctorNo) {
		return doctorWisePscripRepository.docotorByNo(doctorNo);
	}
}
