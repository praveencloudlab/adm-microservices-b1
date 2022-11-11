package com.cts.client1.resouce;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/client2")
public class Clinet1ServiceResource {

	@GetMapping
	public String f1() {
		System.out.println("CLIENT-5 :: getmapping");
		
		return "client 2 get mapping data";
	}
	
	
	
}
