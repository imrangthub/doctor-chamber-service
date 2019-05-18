package com.madbarsoft.doctorchamber.prescriptionFinalize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

@RestController
@RequestMapping("/api/prescription-finalize")
public class prescriptionFinalizeController {

	@Autowired
	private PrescriptionFinalizeService prescriptionFinalizeService;

	@PostMapping("/list")
	public Response getAll() {
		return prescriptionFinalizeService.list();
	}

	@PostMapping("/create")
	public Response create(@RequestBody PrescriptionFinalizeEntity reqObj) {
		return prescriptionFinalizeService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody PrescriptionFinalizeEntity reqObj) {
		return prescriptionFinalizeService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("id") long reqId) {
		return prescriptionFinalizeService.delete(reqId);
	}

	@DeleteMapping("/remove")
	public Response remove(@RequestParam("id") long reqId) {
		return prescriptionFinalizeService.delete(reqId);

	}
}