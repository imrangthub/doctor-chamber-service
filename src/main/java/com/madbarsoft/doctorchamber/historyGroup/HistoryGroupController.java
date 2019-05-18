package com.madbarsoft.doctorchamber.historyGroup;

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
@RequestMapping("/api/history-group")
public class HistoryGroupController {

	@Autowired
	private HistoryGroupService historyGroupService;

	@PostMapping("/gridList")
	public Response gridList(HttpServletRequest request) {
		return historyGroupService.gridList(request);
	}

	@PostMapping("/list")
	public Response getAll(@RequestBody(required = false) HistoryGroupEntity reqObj) {
		return historyGroupService.list(reqObj);
	}

	@PostMapping("/create")
	public Response create(@RequestBody HistoryGroupEntity reqObj) {
		return historyGroupService.save(reqObj);
	}

	@PutMapping("/update")
	@ResponseBody
	public Response update(@RequestBody HistoryGroupEntity reqObj) {
		return historyGroupService.update(reqObj);
	}

	@DeleteMapping("/delete")
	public Response delete(@RequestParam("historyGroupId") long reqId) {
		return historyGroupService.delete(reqId);

	}

}
