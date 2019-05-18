package com.madbarsoft.doctorchamber.opdMedicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.opdMedicine.service.OpdMedicineService;
import com.madbarsoft.doctorchamber.util.Response;


/**
 * @author Md. Jahurul Islam
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/opd-medicine")
public class OpdMedicineController {

    @Autowired
    OpdMedicineService opdMedicineService;
   
	@PostMapping("/list")
    public Response getAllMedicine(@RequestBody(required = false) String  reqObj) {
        return opdMedicineService.list(reqObj);
    }
    
	@PostMapping("/list-opd")
    public Response getOpdMedicine(@RequestBody(required = false) String  reqObj) {
        return opdMedicineService.listOpdMedicine(reqObj);
    }
    
	@PostMapping("/list-ipd")
    public Response getIpdMedicine(@RequestBody(required = false) String  reqObj) {
        return opdMedicineService.listIpdMedicine(reqObj);
    }
    
}
