package com.madbarsoft.doctorchamber.manufacturer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.diagnosis.DiagnosisEntity;
import com.madbarsoft.doctorchamber.entity.ResourceNotFoundException;
import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/manufacturer")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manufacturerService;
			
	@PostMapping("/gridList")
    public Response gridList(HttpServletRequest request) {
        return  manufacturerService.gridList(request);
    }
		
	
	@PostMapping("/list")
    public Response list(@RequestBody ManufacturerEntity reqObj, Pageable pageable) {
        return manufacturerService.list(reqObj);
    }
	    
    @PostMapping("/create")
    public Response create(@RequestBody ManufacturerEntity reqObj) {
    	return manufacturerService.save(reqObj);
    }

    
    @PutMapping("/update")
    public Response update(@RequestBody ManufacturerEntity reqObj) {
    	return manufacturerService.update(reqObj);
    }
    
    @DeleteMapping("/delete")
    public Response delete(@RequestParam("manufacturerId") long reqId) {
      	return manufacturerService.delete(reqId);
       
    }
	

}
