package com.madbarsoft.doctorchamber.autoComplete;

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
@RequestMapping("/api/autoComplete")
public class AutoCompleteController {

	@Autowired
	private AutoCompleteService autoCompleteService;

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return autoCompleteService.gridList(request);
	}

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestBody(required = false) AutoCompleteEntity reqObj) {
		return autoCompleteService.listByDoctorNo(reqObj);
	}

	@PostMapping("/create")
	public Response create(@RequestBody AutoCompleteEntity reqObj) {
		return autoCompleteService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody AutoCompleteEntity reqObj) {
		return autoCompleteService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("reqId") long reqId) {
		return autoCompleteService.delete(reqId);

	}

}
