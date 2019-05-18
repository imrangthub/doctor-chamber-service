package com.madbarsoft.doctorchamber.clinicalHistory;

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
@RequestMapping("/api/clinical-history")
public class ClinicalHistoryController {

	@Autowired
	private ClinicalHistoryService chiefComService;
	
	
	@PostMapping("/gridList")
    public Response gridList(HttpServletRequest request) {
        return  chiefComService.gridList(request);
    }
		

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestBody(required = false) ClinicalHistoryEntity reqObj) {
		return chiefComService.listByDoctorNo(reqObj);
	}
	


	@PostMapping("/create")
	public Response create(@RequestBody ClinicalHistoryEntity reqObj) {
		return chiefComService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody ClinicalHistoryEntity reqObj) {
		return chiefComService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("id") long reqId) {
		return chiefComService.delete(reqId);

	}

}