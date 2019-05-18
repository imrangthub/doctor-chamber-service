package com.madbarsoft.doctorchamber.manufacturer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;


@Service
public class ManufacturerService {
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	

	public Response gridList(HttpServletRequest request) {
		return manufacturerRepository.gridList(request);

	}
	public Response list(ManufacturerEntity obj) {
		return manufacturerRepository.list(obj);
	}
	
	public Response save(ManufacturerEntity obj) {
		return manufacturerRepository.save(obj);
	}
	
	public Response update(ManufacturerEntity diagnosis) {
		return manufacturerRepository.update(diagnosis);
	}
	
	public Response delete(Long id) {
		return manufacturerRepository.detele(id);
	}


	
}
