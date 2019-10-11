package com.madbarsoft.doctorchamber.consultation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.core.util.Def;
import com.madbarsoft.doctorchamber.consultation.service.ConsultationService;
import com.madbarsoft.doctorchamber.physicalExamination.PhysicalExaminationEntity;
import com.madbarsoft.doctorchamber.util.Response;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/consulation")
public class ConsultationController {

   @Autowired
   ConsultationService consulationService;
   
	@GetMapping("/list")
	public Response list(){
		 return  consulationService.list();
	}
   
	@GetMapping("/search-consulation")
	public Response searchConsulation(@RequestParam Map<String, String> queryMap){
		 return  consulationService.listWithFilter(queryMap);
	}
	
	@PostMapping("/list")
    public Response getAll() {
        return  consulationService.list();
    }
	
	
  @PostMapping("/create")
  public Response create(@RequestBody ConsultationEntity reqObj) {
  	return consulationService.save(reqObj);
  }
  
	@GetMapping("/findByDoctorNo")
    public Response findByDoctorNo(@RequestParam Long doctorNo) {
	return consulationService.findByDoctorNo(doctorNo);
   }
	
	@GetMapping("/findListByDoctorNo")
	public Response findListByDoctorNo(@RequestParam Long doctorNo) {
		
		return consulationService.findListDocotorNo(doctorNo);
	}
	
	
	
//	@GetMapping("/search-registration")
//	public Response searchRegistration(@RequestParam Map<String, String> queryMap){
//		 return  consulationService.registrationListWithFilter(queryMap);
//	}
//
//

//    
//
//	@PostMapping("/gridList")
//    public Response gridList(HttpServletRequest request) {
//        return  consulationService.gridList(request);
//    }
//    
//    @PutMapping("/update")
//    public Response update(@RequestBody ConsultationEntity reqObj) {
//    	
//    	return consulationService.update(reqObj);
//    }
//    
//    @DeleteMapping("/delete")
//    public Response delete(@RequestParam("medicationId") long reqId) {
//    	
//    	return consulationService.delete(reqId);  
//        
//    }
//	
//    @DeleteMapping("/remove")
//    public Response remove(@RequestParam("medicationId") long reqId) {
//    	
//    	return consulationService.delete(reqId);          
//    }
//    
	
	
	@PostMapping("/findByConsultationId")
    public Response findByConsultationId(@RequestBody ConsultationEntity reqObj) {
		return consulationService.findByConsultationId(reqObj);
	}
	
//	@PostMapping("/findByHospitalNumber")
//    public Response findByHospitalNumber(@RequestBody String reqObj) {
//		JSONObject json = new JSONObject(reqObj);
//		String hospitalNo = Def.getString(json, "hospitalId");
//		return consulationService.findByHospitalNumber(hospitalNo);
//	}
}
