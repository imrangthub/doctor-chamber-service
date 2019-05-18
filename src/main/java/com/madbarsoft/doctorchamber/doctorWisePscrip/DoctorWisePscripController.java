package com.madbarsoft.doctorchamber.doctorWisePscrip;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/doctorWisePscrip")
public class DoctorWisePscripController {

	@Autowired
	private DoctorWisePscripService doctorWisePscripService;

	@PostMapping("/list")
	public Response list(@RequestBody(required = false) DoctorWisePscripEntity reqObj) {
		return doctorWisePscripService.list(reqObj);
	}

	@PostMapping("/doctorList")
	public Response doctorList(@RequestBody(required = false) String params) {
		return doctorWisePscripService.doctorList(params);
	}

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return doctorWisePscripService.gridList(request);
	}

	@PutMapping("/update")
	public Response update(@RequestBody String reqObj) {
		return doctorWisePscripService.update(reqObj);
	}

	@GetMapping("/find")
	public DoctorWisePscripEntity findByDoctorId(@RequestParam("doctorId") String doctorId) {
		return doctorWisePscripService.findbyDoctorId(doctorId);
	}

	@GetMapping("/findByDoctorNo")
	public DoctorWisePscripEntity findByDoctorId(@RequestParam("doctorNo") long doctorNo) {
		return doctorWisePscripService.findbyDoctorNo(doctorNo);
	}

	@GetMapping("/doctorById")
	public Response doctorById(@RequestParam("doctorId") String doctorId) {
		return doctorWisePscripService.doctorById(doctorId);
	}

}
