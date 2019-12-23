package com.flowers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.rest.beans.UserDetail;
import com.flowers.rest.service.IUserDetailService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.flowers")
@EnableSwagger2
public class FlowersRestApiApplication implements CommandLineRunner{
	
	@Autowired
	IUserDetailService userDetailService;

	public static void main(String[] args) {
		SpringApplication.run(FlowersRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int id = 4; 
		String value = "1800Flowers";
		
		UserDetail userDetails = userDetailService.updateUserDetailsById(id, value);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(userDetails);

		System.out.println("Modified Json response : " + jsonData);
		
	}
	
	

}

