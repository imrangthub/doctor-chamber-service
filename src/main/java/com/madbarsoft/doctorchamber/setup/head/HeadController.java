package com.madbarsoft.doctorchamber.setup.head;

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
@RequestMapping("/api/setup-head")
public class HeadController {

	@Autowired
	private HeadService headService;
	

	@PostMapping("/gridList")
    public Response gridList(HttpServletRequest request) {
        return  headService.gridList(request);
    }
		

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestBody HeadEntity reqObj) {
		return headService.listByDoctorNo(reqObj);
	}
	
	



	@PostMapping("/create")
	public Response create(@RequestBody HeadEntity reqObj) {
		return headService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody HeadEntity reqObj) {
		return headService.update(reqObj);
	}
	
	@PutMapping("/saveOrupdate")
	public Response saveOrupdate(@RequestBody HeadEntity reqObj) {
		return headService.saveOrupdate(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("id") long reqId) {
		return headService.delete(reqId);

	}

}
