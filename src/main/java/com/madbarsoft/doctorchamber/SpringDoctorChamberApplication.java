package com.madbarsoft.doctorchamber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.madbarsoft"})
@EntityScan(basePackageClasses= {
		SpringDoctorChamberApplication.class
})
public class SpringDoctorChamberApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorChamberApplication.class, args);
	}
	
	
	
}
