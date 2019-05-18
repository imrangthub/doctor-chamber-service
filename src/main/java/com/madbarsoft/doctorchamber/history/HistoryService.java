package com.madbarsoft.doctorchamber.history;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class HistoryService {

	@Autowired
	private HistoryRepository historyRepository;

	public Response gridList(HttpServletRequest request) {
		return historyRepository.gridList(request);
	}

	public Response list(HistoryEntity reqObj) {
		return historyRepository.list(reqObj);
	}

	public Response save(HistoryEntity reqObj) {
		return historyRepository.save(reqObj);
	}
	
	public Response update(HistoryEntity reqObj) {
		return historyRepository.update(reqObj);
	}

	public Response delete(Long id) {
		return historyRepository.detele(id);
	}
	
	
	public HistoryEntity findByNameAndDoctorNo(HistoryEntity reqObj) {
		return historyRepository.findByNameAndDoctorNo(reqObj);
	}
}
