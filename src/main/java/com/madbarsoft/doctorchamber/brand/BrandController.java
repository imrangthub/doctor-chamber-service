package com.madbarsoft.doctorchamber.brand;

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


/**
 * @author Md. Jahurul Islam
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/medicine")
public class BrandController {

   @Autowired
   BrandService brandService;
   
   
   
	@PostMapping("/list")
    public Response getAll(@RequestBody(required = false) String  reqObj) {
        return brandService.list(reqObj);
    }
    
    @PostMapping("/create")
    public Response create(@RequestBody String reqObj) {
    	return brandService.save(reqObj);
    }

    
    @PutMapping("/update")
    public Response update(@RequestBody String reqObj) {
    	return brandService.save(reqObj);
    }
    
    @DeleteMapping("/delete")
    public Response delete(@RequestParam("medicationId") long reqId) {
    	
    	return brandService.delete(reqId);  
        
    }
	
    @DeleteMapping("/remove")
    public Response remove(@RequestParam("medicationId") long reqId) {
    	
    	return brandService.delete(reqId);  
        
    }
}
