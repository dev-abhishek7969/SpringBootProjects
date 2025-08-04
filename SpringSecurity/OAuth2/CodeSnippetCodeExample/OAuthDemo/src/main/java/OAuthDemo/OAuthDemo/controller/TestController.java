package OAuthDemo.OAuthDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class TestController {
	
	@GetMapping("/getAccess")
	public String getAccess() {
		System.out.println("call back url called.");
		return "Access granted !!";
	}

}
