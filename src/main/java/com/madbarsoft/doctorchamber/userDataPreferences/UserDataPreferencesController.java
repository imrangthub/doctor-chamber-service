package com.madbarsoft.doctorchamber.userDataPreferences;

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

import com.madbarsoft.doctorchamber.investigation.InvestigationEntity;
import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user-data-preferences")
public class UserDataPreferencesController {

	@Autowired
	private UserDataPreferencesService userDataPreferencesService;

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return userDataPreferencesService.gridList(request);
	}

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestParam("id") long reqId) {
		return userDataPreferencesService.listByDoctorNo(reqId);
	}

	@PostMapping("/create")
	public Response create(@RequestBody  UserDataPreferencesEntity reqObj) {
		return userDataPreferencesService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody UserDataPreferencesEntity reqObj) {

		return userDataPreferencesService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("id") long reqId) {

		return userDataPreferencesService.delete(reqId);

	}

	@DeleteMapping("/remove")
	public Response remove(@RequestParam("id") long reqId) {
		return userDataPreferencesService.delete(reqId);

	}
}
