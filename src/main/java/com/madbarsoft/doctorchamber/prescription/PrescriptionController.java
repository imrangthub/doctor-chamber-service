package com.madbarsoft.doctorchamber.prescription;

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
@RequestMapping("/api/prescription")
public class PrescriptionController {

	   @Autowired
	   PrescriptionService prescriptionService;
	   

		@PostMapping("/list")
	    public Response getAll() {
	        return  prescriptionService.list();
	    }
	    
	    @PostMapping("/create")
	    public Response create(@RequestBody String reqObj) {
	    	return prescriptionService.save(reqObj);
	    }
	    
	    @PutMapping("/update")
	    public Response update(@RequestBody String reqObj) {
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
	    
	    @PostMapping("/find")
	    public PrescriptionEntity findById(Long id) {
			return prescriptionService.findById(id);
		}
	    
	    @PostMapping("/search")
		public Response findByCriteria(@RequestBody String searchCriteria) {
			return prescriptionService.findByCriteria(searchCriteria);
		}
	    
	    @PostMapping("/findOpdConsHistory")
		public Response findOpdConsHistory(@RequestBody String searchCriteria) {
			return prescriptionService.findOpdConsHistory(searchCriteria);
		}
	    
	    @PostMapping("/findPreviousConsulation")
  		public Response findPreviousConsulation(@RequestBody String searchCriteria) {
  			return prescriptionService.findPreviousConsulation(searchCriteria);
  		}
}
