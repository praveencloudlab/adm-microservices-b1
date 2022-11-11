package com.cts.client1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "client2-service" )
public interface Client2ServiceProxy {
	
	@GetMapping("api/client2")
	public String f1();

}
