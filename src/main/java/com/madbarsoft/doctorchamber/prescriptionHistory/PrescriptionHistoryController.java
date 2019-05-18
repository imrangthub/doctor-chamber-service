package com.madbarsoft.doctorchamber.prescriptionHistory;

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
@RequestMapping("/api/history-prescription")
public class PrescriptionHistoryController {

	@Autowired
	private PrescriptionHistoryService historyPrescriptionDataService;

	@PostMapping("/list")
	public Response getAll() {
		return historyPrescriptionDataService.list();
	}

	@PostMapping("/create")
	public Response create(@RequestBody PrescriptionHistoryEntity reqObj) {
		return historyPrescriptionDataService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody PrescriptionHistoryEntity reqObj) {
		return historyPrescriptionDataService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("id") long reqId) {
		return historyPrescriptionDataService.delete(reqId);

	}

	@DeleteMapping("/remove")
	public Response remove(@RequestParam("id") long reqId) {
		return historyPrescriptionDataService.delete(reqId);

	}
}
