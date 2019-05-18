package com.madbarsoft.doctorchamber.prescriptionVital;

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
@RequestMapping("/api/prescription-vital")
public class PrescriptionVitalController {

	   @Autowired
	   PrescriptionVitalService prescriptionVitalService;
	   

		@PostMapping("/list")
	    public Response getAll() {
	        return  prescriptionVitalService.list();
	    }
	    
	   @PostMapping("/create")
	    public Response create(@RequestBody PrescriptionVitalEntity reqObj) {
	    	return prescriptionVitalService.save(reqObj);
	    }
	    
	    @PutMapping("/update")
	    public Response update(@RequestBody PrescriptionVitalEntity reqObj) {
	    	
	    	return prescriptionVitalService.update(reqObj);
	    }
	    
	    @DeleteMapping("/delete")
	    public Response delete(@RequestParam("id") long reqId) {
	    	
	    	return prescriptionVitalService.delete(reqId);  
	        
	    }
		
	    @DeleteMapping("/remove")
	    public Response remove(@RequestParam("id") long reqId) {
	    	
	    	return prescriptionVitalService.delete(reqId);  
	        
	    }
}
