package com.cts.ecart.controller;

import java.time.LocalDateTime;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Bean
	public Queue f1() {
		return new Queue("Q1", false);
	}
	
	@Bean
	public void sendMessage() {
		rabbitTemplate.convertAndSend("Q1","Message-4 from sender app");
	}

}
