package com.madbarsoft.doctorchamber.physicalExamGroup;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/physical-exam-group")
public class PhysicalExamGroupController {
	

	@Autowired
	private PhysicalExamGroupService physicalExamGroupService;

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return physicalExamGroupService.gridList(request);
	}

	@PostMapping("/list")
	public Response getAll(@RequestBody(required = false) PhysicalExamGroupEntity reqObj) {
		return physicalExamGroupService.list(reqObj);
	}
/*	
	@PostMapping("/list")
	public Response getAll(Pageable pageable) {
		return physicalExamGroupService.list();
	}*/

	@PostMapping("/create")
	public Response create(@RequestBody PhysicalExamGroupEntity reqObj) {
		return physicalExamGroupService.save(reqObj);
	}

	@PutMapping("/update")
	@ResponseBody
	public Response update(@RequestBody PhysicalExamGroupEntity reqObj) {
		return physicalExamGroupService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("examgroupId") long reqId) {
		return physicalExamGroupService.delete(reqId);

	}

}
