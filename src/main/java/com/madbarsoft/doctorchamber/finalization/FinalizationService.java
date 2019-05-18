package com.madbarsoft.doctorchamber.finalization;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class FinalizationService {

	@Autowired
	private FinalizationRepository finalizationRepository;

	public Response gridList(HttpServletRequest request) {
		return finalizationRepository.gridList(request);
	}
	public Response list(FinalizationEntity finalization) {
		return finalizationRepository.list(finalization);
	}
	
	public Response save(FinalizationEntity finalizationEntity) {
		return finalizationRepository.save(finalizationEntity);
	}
	
	public Response update(FinalizationEntity finalizationEntity) {
		return finalizationRepository.update(finalizationEntity);
	}
	
	public Response delete(Long id) {
		return finalizationRepository.detele(id);
	}
}
