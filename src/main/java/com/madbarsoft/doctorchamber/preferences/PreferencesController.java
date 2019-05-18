package com.madbarsoft.doctorchamber.preferences;

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
@RequestMapping("/api/preferences")
public class PreferencesController {

	@Autowired
	private PreferencesService preferencesService;

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return preferencesService.gridList(request);
	}
		

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestBody(required = false) String userNo) {
		return preferencesService.listByDoctorNo(userNo);
	}

	@PostMapping("/create")
	public Response create(@RequestBody PreferencesEntity reqObj) {
		return preferencesService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody PreferencesEntity reqObj) {

		return preferencesService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("id") long reqId) {

		return preferencesService.delete(reqId);

	}

	@DeleteMapping("/remove")
	public Response remove(@RequestParam("id") long reqId) {

		return preferencesService.delete(reqId);

	}
}
