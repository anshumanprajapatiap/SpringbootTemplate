package com.springboot.template.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "healthCheck")
public class HealthCheckController {
	
	
	@GetMapping("")
	ResponseEntity<String> healthCheck(){
		return new ResponseEntity<String>("OK", HttpStatus.OK);
		
	}

}
