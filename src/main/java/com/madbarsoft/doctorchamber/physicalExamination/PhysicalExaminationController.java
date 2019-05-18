package com.madbarsoft.doctorchamber.physicalExamination;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Md. Jahurul Islam
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/physical-exam")
public class PhysicalExaminationController {

	@Autowired
	PhysicalExaminationService physicalExaminationService;
	
	
	@PostMapping("/gridList")
    public Response gridList(HttpServletRequest request) {
        return  physicalExaminationService.gridList(request);
    }
	

	@PostMapping("/list")
	public Response getAll(@RequestBody(required = false) PhysicalExaminationEntity reqObj) {
		return physicalExaminationService.list(reqObj);
	}
	
	
/*	@PostMapping("/list")
    public Response getAll(Pageable pageable) {
        return physicalExaminationService.list();
    }*/
    
    @PostMapping("/create")
    public Response create(@RequestBody PhysicalExaminationEntity reqObj) {
    	return physicalExaminationService.save(reqObj);
    }

    
    @PutMapping("/update")
    @ResponseBody
    public Response update(@RequestBody PhysicalExaminationEntity reqObj) {
    	return physicalExaminationService.update(reqObj);
    }
    
    @DeleteMapping("/delete")
    public Response delete(@RequestParam("examId") long reqId) {
   	    	return physicalExaminationService.delete(reqId);
        
    }
	
	
}
