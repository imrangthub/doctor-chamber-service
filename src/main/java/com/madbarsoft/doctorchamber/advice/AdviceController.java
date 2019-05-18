package com.madbarsoft.doctorchamber.advice;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/advice")
public class AdviceController {

	@Autowired
	private AdviceService adviceService;

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return adviceService.gridList(request);
	}

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestBody(required = false) AdviceEntity reqObj) {
		return adviceService.listByDoctorNo(reqObj);
	}

	@PostMapping("/create")
	public Response create(@RequestBody AdviceEntity reqObj) {
		return adviceService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody AdviceEntity reqObj) {
		return adviceService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("reqId") long reqId) {
		return adviceService.delete(reqId);

	}

}

