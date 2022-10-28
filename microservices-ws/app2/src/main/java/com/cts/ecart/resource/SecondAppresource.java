package com.cts.ecart.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "api/app2")
public class SecondAppresource {

	private RestTemplate restTemplate=new RestTemplate();
	
	@GetMapping
	public String f111() {
		
		String msg=restTemplate.getForObject("http://localhost:9091/api/app1", String.class);
		
		return "Message from app1:: "+msg;
		
		
	}
	

}
