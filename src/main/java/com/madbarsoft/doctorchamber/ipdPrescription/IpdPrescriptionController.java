package com.madbarsoft.doctorchamber.ipdPrescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.ipdPrescription.service.IpdPrescriptinService;
import com.madbarsoft.doctorchamber.util.Response;
/**
 * @author Mohammad lockman
 *
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ipdPrescription")
public class IpdPrescriptionController {
	
	@Autowired
	IpdPrescriptinService IpdPrescriptinService;
	
	@PostMapping("/nurseStationList")
    public Response nurseStationList(@RequestBody long userNo) {
        return  IpdPrescriptinService.nurseStationList(userNo);
    }
	
	
	
	@PostMapping("/patientList")
    public Response patientList(@RequestBody PatientRequestParamEntity obj) {
        return  IpdPrescriptinService.patientList(obj);
    }
	
}
