package com.madbarsoft.doctorchamber.finalization;

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
@RequestMapping("/api/finalization")
public class FinalizationController {

	@Autowired
	private FinalizationService finalizationService;
	
	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return finalizationService.gridList(request);
	}
	
	@PostMapping("/list")
	public Response getAll(@RequestBody(required=false) FinalizationEntity reqObj) {
		return finalizationService.list(reqObj);
	}
	
	@PostMapping("/create")
	public Response create(@RequestBody FinalizationEntity reqObj) {
		return finalizationService.save(reqObj);
	}
	
	@PutMapping("/update")
	@ResponseBody
	public Response update(@RequestBody FinalizationEntity reqObj) {
		return finalizationService.update(reqObj);
	}
	
	@DeleteMapping("/delete")
	public Response delete(@RequestParam("finalizId") long reqId) {
		return finalizationService.delete(reqId);

	}

}
