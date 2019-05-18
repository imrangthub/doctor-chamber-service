package com.madbarsoft.doctorchamber.note;

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
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.util.Response;


/**
 * @author Md. Jahurul Islam
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/note")
public class NoteController {

	@Autowired
	NoteService noteService;
	
	
	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return noteService.gridList(request);
	}
	
	@PostMapping("/list")
    public Response getAll(@RequestBody(required = false) NoteEntity reqObj) {
        return noteService.list(reqObj);
    }
    
    @PostMapping("/create")
    public Response create(@RequestBody NoteEntity reqObj) {
    	return noteService.save(reqObj);
    }

    
    @PutMapping("/update")
    public Response update(@RequestBody NoteEntity reqObj) {
    	return noteService.update(reqObj);
    }
    
    @DeleteMapping("/delete")
    public Response delete(@RequestParam("noteId") long reqId) {
   	    	return noteService.delete(reqId);
        
    }
	
    @DeleteMapping("/remove")
    public Response remove(@RequestParam("noteId") long reqId) {
   	    	return noteService.remove(reqId);
        
    }
}
