package com.madbarsoft.doctorchamber.prescriptionMedicine;

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
@RequestMapping("/api/prescription-medicine")
public class PrescriptionMedicineController {

	   @Autowired
	   PrescriptionMedicineService prescriptionMedicineService;
	   

		@PostMapping("/list")
	    public Response getAll() {
	        return  prescriptionMedicineService.list();
	    }
	    
	   @PostMapping("/create")
	    public Response create(@RequestBody PrescriptionMedicineEntity reqObj) {
	    	return prescriptionMedicineService.save(reqObj);
	    }
	    
	    @PutMapping("/update")
	    public Response update(@RequestBody PrescriptionMedicineEntity reqObj) {
	    	
	    	return prescriptionMedicineService.update(reqObj);
	    }
	    
	    @DeleteMapping("/delete")
	    public Response delete(@RequestParam("id") long reqId) {
	    	
	    	return prescriptionMedicineService.delete(reqId);  
	        
	    }
		
	    @DeleteMapping("/remove")
	    public Response remove(@RequestParam("id") long reqId) {
	    	
	    	return prescriptionMedicineService.delete(reqId);  
	        
	    }
}
