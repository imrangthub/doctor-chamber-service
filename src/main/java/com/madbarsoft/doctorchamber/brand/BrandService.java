package com.madbarsoft.doctorchamber.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;


@Service
public class BrandService {

	@Autowired
	BrandRepository brandRepository;

	public Response list(String reqStr) {

		return brandRepository.list(reqStr);
	}

	public Response save(String brand) {

		return brandRepository.save(brand);
	}

	public Response update(BrandEntity brand) {

		return brandRepository.update(brand);
	}

	public Response remove(Long id) {

		return brandRepository.remove(id);
	}
	public Response delete(Long id) {

		return brandRepository.detele(id);
	}
	
}
