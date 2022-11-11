package com.cts.client1.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.client1.service.Client1Service;

@RestController
@CrossOrigin
@RequestMapping("api/find")
public class Clinet1ServiceResource {
	
	@Autowired
	private Client1Service client1Service;

	@GetMapping
	public String f1() {
		System.out.println(">>>> client1 :: get");
		return client1Service.loadBalanceTest();
	}
	
	
}
