package com.madbarsoft.doctorchamber.diagnosis;

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
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/diagnosis")
public class DiagnosisController {

	
	@Autowired
	DiagnosisService diagnosisService;
	
	
	@PostMapping("/gridList")
    public Response gridList(HttpServletRequest request) {
        return  diagnosisService.gridList(request);
    }
	
	@PostMapping("/list")
    public Response listByDoctorNo(@RequestBody DiagnosisEntity reqObj, Pageable pageable) {
        return diagnosisService.listByDoctorNo(reqObj);
    }
	    
    @PostMapping("/create")
    public Response create(@RequestBody DiagnosisEntity reqObj) {
    	return diagnosisService.save(reqObj);
    }

    
    @PutMapping("/update")
    public Response update(@RequestBody DiagnosisEntity reqObj) {
    	return diagnosisService.update(reqObj);
    }
    
    @DeleteMapping("/delete")
    public Response delete(@RequestParam("diagnosisId") long reqId) {
      	return diagnosisService.delete(reqId);
       
    }

}
