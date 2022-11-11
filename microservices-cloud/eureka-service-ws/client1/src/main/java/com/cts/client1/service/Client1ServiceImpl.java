package com.cts.client1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Client1ServiceImpl implements Client1Service {

	@Autowired
	private Client2ServiceProxy client2ServiceProxy;
	
	
	@Override
	public String loadBalanceTest() {
		return client2ServiceProxy.f1();
	}
	
	
	

}
