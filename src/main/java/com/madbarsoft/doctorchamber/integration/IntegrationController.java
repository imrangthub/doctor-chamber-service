package com.madbarsoft.doctorchamber.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.integration.service.IntegrationService;
import com.madbarsoft.doctorchamber.util.Response;


/**
 * @author Md. Jahurul Islam
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/integration")
public class IntegrationController {

   @Autowired
   IntegrationService integrationService;


	@PostMapping("/list")
    public Response getAll(@RequestParam long consulationId) {
		
        return  integrationService.findByConsultationId(consulationId);
    }
    

    
   
}