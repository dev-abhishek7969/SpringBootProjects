package user_service.user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/getUser")
	public String gerUserDetails() {
		return "Getting user details.";
	}

}
