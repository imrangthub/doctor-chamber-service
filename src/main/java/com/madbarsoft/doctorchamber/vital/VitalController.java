package com.madbarsoft.doctorchamber.vital;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.physicalExamination.PhysicalExaminationEntity;
import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Md. Jahurul Islam
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vital")
public class VitalController {

	@Autowired
	VitalService vitalService;
	
	
	@PostMapping("/gridList")
    public Response gridList(HttpServletRequest request) {
        return  vitalService.gridList(request);
    }
	
	
	@PostMapping("/list")
    public Response getAll(@RequestBody(required = false) VitalEntity reqObj) {
        return vitalService.list(reqObj);
    }
    
    @PostMapping("/create")
    public Response create(@RequestBody VitalEntity reqObj) {
    	return vitalService.save(reqObj);
    }

    
    @PutMapping("/update")
    @ResponseBody
    public Response update(@RequestBody VitalEntity reqObj) {
    	return vitalService.update(reqObj);
    }
    
    @DeleteMapping("/delete")
    public Response delete(@RequestParam("vitalId") long reqId) {
   	    	return vitalService.delete(reqId);
        
    }
	
	
}
