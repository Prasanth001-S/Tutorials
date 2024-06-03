package com.daystar.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControll {
	
	@GetMapping("/greeting")
	public String greeting() {
		return "Hi Greetings";
	}

}
