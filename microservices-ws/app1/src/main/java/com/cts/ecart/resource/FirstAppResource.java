package com.cts.ecart.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/app1")
public class FirstAppResource {
	
	@GetMapping
	public String greet() {
		return "Good Morning!";
	}
	
	

}
