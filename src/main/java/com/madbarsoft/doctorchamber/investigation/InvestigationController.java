package com.madbarsoft.doctorchamber.investigation;

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
@RequestMapping("/api/investigation")
public class InvestigationController {

	@Autowired
	InvestigationService investigationService;
	
	@PostMapping("/gridList")
    public Response gridList(HttpServletRequest request) {
        return  investigationService.gridList(request);
    }
	
	@PostMapping("/list")
    public Response getAll(@RequestBody(required = false) InvestigationEntity reqObj) {
        return investigationService.list(reqObj);
    }
    
    @PostMapping("/create")
    public Response create(@RequestBody InvestigationEntity reqObj) {
    	return investigationService.save(reqObj);
    }

    
    @PutMapping("/update")
    public Response update(@RequestBody InvestigationEntity reqObj) {
    	return investigationService.update(reqObj);
 
    }
    
    @DeleteMapping("/delete")
    public Response delete(@RequestParam("investigationId") long reqId) {
       	return investigationService.delete(reqId);
    }
}
