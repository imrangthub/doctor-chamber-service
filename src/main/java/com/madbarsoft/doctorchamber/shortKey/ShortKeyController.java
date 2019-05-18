package com.madbarsoft.doctorchamber.shortKey;

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
@RequestMapping("/api/shortKey")
public class ShortKeyController {

	@Autowired
	private ShortKeyService shortKeyService;

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return shortKeyService.gridList(request);
	}

	@PostMapping("/list")
	public Response listByDoctorNo(@RequestBody(required = false) ShortKeyEntity reqObj) {
		return shortKeyService.listByDoctorNo(reqObj);
	}

	@PostMapping("/create")
	public Response create(@RequestBody ShortKeyEntity reqObj) {
		return shortKeyService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody ShortKeyEntity reqObj) {
		return shortKeyService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("reqId") long reqId) {
		return shortKeyService.delete(reqId);

	}

}
