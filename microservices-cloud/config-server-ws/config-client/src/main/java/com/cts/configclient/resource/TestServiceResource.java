package com.cts.configclient.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/testapp")
public class TestServiceResource {
	
	@Value("${city}")
	private String cityName;
	
	@GetMapping
	public String getCity() {
		return cityName;
	}

}
