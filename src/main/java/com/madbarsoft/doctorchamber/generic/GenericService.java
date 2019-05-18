package com.madbarsoft.doctorchamber.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.brand.BrandEntity;
import com.madbarsoft.doctorchamber.group.GroupEntity;
import com.madbarsoft.doctorchamber.util.Response;


@Service
public class GenericService {
	
	@Autowired
	private GenericRepository genericRepository;
	
	public Response list(String obj) {
		  return genericRepository.list(obj);
	}

	public Response save(String strObj) {
			return genericRepository.save(strObj);
	}
	
     public Response update(String obj)  {
		return genericRepository.update(obj);
	}

	
	public Response delete(Long id) {
		return genericRepository.detele(id);
	}
	
	public GenericEntity findById(Long id) {
		return genericRepository.findById(id);
	}
}
