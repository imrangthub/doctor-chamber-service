package com.madbarsoft.doctorchamber.generic;

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
@RequestMapping("/api/generic")
public class GenericController {
	
	@Autowired
	private GenericService genericService;
	

	@PostMapping("/list")
    public Response listByGroupNo(@RequestBody(required = false) String  reqObj) {
        return genericService.list(reqObj);
    }
    
    @PostMapping("/create")
    public Response create(@RequestBody String reqObj) {
    	return genericService.save(reqObj);
    }
    
    @DeleteMapping("/delete")
    public Response delete(@RequestParam("genericId") long reqId) {
    	return genericService.delete(reqId);  
        
    }
    
    @PutMapping("/update")
    public Response update(@RequestBody String reqObj) {
    	return genericService.update(reqObj);
    }
}
