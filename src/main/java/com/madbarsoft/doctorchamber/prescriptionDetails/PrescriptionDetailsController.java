package com.madbarsoft.doctorchamber.prescriptionDetails;

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
@RequestMapping("/api/prescription-details")
public class PrescriptionDetailsController {

	   @Autowired
	   PrescriptionDetailsService prescriptionService;
	   

		@PostMapping("/list")
	    public Response getAll() {
	        return  prescriptionService.list();
	    }
	    
	   @PostMapping("/create")
	    public Response create(@RequestBody PrescriptionDetailsEntity reqObj) {
	    	return prescriptionService.save(reqObj);
	    }
	    
	    @PutMapping("/update")
	    public Response update(@RequestBody PrescriptionDetailsEntity reqObj) {
	    	
	    	return prescriptionService.update(reqObj);
	    }
	    
	    @DeleteMapping("/delete")
	    public Response delete(@RequestParam("id") long reqId) {
	    	
	    	return prescriptionService.delete(reqId);  
	        
	    }
		
	    @DeleteMapping("/remove")
	    public Response remove(@RequestParam("id") long reqId) {
	    	
	    	return prescriptionService.delete(reqId);  
	        
	    }
}
