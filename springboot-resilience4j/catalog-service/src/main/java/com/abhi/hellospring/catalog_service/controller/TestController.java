package com.abhi.hellospring.catalog_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/getName")
	public String getName() {
		return "This is a test controller test.";
	}

}
