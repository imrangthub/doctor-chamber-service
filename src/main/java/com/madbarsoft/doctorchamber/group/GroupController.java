package com.madbarsoft.doctorchamber.group;

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
@RequestMapping("/api/group")
public class GroupController {

	@Autowired
	GroupService groupService;
	
	@PostMapping("/list")
    public Response getAll(@RequestBody(required = false) GroupEntity reqObj) {
        return  groupService.list(reqObj);
    }
    
    @PostMapping("/create")
    public Response create(@RequestBody GroupEntity reqObj) {
    	return groupService.save(reqObj);
    }

    
    @PutMapping("/update")
    public Response update(@RequestBody GroupEntity reqObj) {
    	
    	return groupService.update(reqObj);
    }
    
    @DeleteMapping("/delete")
    public Response delete(@RequestParam("groupId") long reqId) {
    	
    	return groupService.delete(reqId);  
        
    }
	
    @DeleteMapping("/remove")
    public Response remove(@RequestParam("medicationId") long reqId) {
    	
    	return groupService.delete(reqId);  
        
    }

}
