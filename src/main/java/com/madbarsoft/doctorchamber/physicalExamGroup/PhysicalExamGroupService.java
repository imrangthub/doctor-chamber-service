package com.madbarsoft.doctorchamber.physicalExamGroup;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;

@Service
public class PhysicalExamGroupService {

	@Autowired
	private PhysicalExamGroupRepository physicalExamGroupRepository;

	public Response gridList(HttpServletRequest request) {
		return physicalExamGroupRepository.gridList(request);
	}

	public Response list(PhysicalExamGroupEntity obj) {
		return physicalExamGroupRepository.list(obj);
	}

	public Response save(PhysicalExamGroupEntity obj) {
		return physicalExamGroupRepository.save(obj);
	}

	public Response update(PhysicalExamGroupEntity obj) {
		return physicalExamGroupRepository.update(obj);
	}

	public Response delete(Long id) {
		return physicalExamGroupRepository.detele(id);
	}
}
