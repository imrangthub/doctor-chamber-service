package com.madbarsoft.doctorchamber.userPreferences;

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
@RequestMapping("/api/user-preferences")
public class UserPreferencesController {

	@Autowired
	private UserPreferencesService userPreferencesService;

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return userPreferencesService.gridList(request);
	}

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestParam("id") long reqId) {
		return userPreferencesService.listByDoctorNo(reqId);
	}

	@PostMapping("/create")
	public Response create(@RequestBody String userPrefList) {
		return userPreferencesService.save(userPrefList);
	}

	@PutMapping("/update")
	public Response update(@RequestBody UserPreferencesEntity reqObj) {

		return userPreferencesService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("id") long reqId) {

		return userPreferencesService.delete(reqId);

	}

	@DeleteMapping("/remove")
	public Response remove(@RequestParam("id") long reqId) {
		return userPreferencesService.delete(reqId);

	}
}
