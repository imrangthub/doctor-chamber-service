package com.madbarsoft.doctorchamber.historyGroup;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class HistoryGroupService {

	@Autowired
	private HistoryGroupRepository historyGroupRepository;

	public Response gridList(HttpServletRequest request) {
		return historyGroupRepository.gridList(request);
	}

	public Response list(HistoryGroupEntity obj) {
		return historyGroupRepository.list(obj);
	}

	public Response save(HistoryGroupEntity obj) {
		return historyGroupRepository.save(obj);
	}

	public Response update(HistoryGroupEntity obj) {
		return historyGroupRepository.update(obj);
	}

	public Response delete(Long id) {
		return historyGroupRepository.detele(id);
	}
}
