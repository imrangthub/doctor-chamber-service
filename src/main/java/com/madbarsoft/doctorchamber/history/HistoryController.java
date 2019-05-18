package com.madbarsoft.doctorchamber.history;

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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/history")
public class HistoryController {

	@Autowired
	private HistoryService historyService;

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return historyService.gridList(request);
	}

	@PostMapping("/list")
	public Response getAll(@RequestBody(required = false) HistoryEntity reqObj) {
		return historyService.list(reqObj);
	}

	@PostMapping("/create")
	public Response create(@RequestBody HistoryEntity reqObj) {
		return historyService.save(reqObj);
	}

	@PutMapping("/update")
	@ResponseBody
	public Response update(@RequestBody HistoryEntity reqObj) {
		return historyService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("reqId") long reqId) {
		return historyService.delete(reqId);

	}

}
