package OAuthDemo.OAuthDemo.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

	@GetMapping("/public")
	public String publicApi() {
		return "public api called.";
	}

	@GetMapping("/private")
	public String privateApi(OAuth2AuthenticationToken token) {
		System.out.println(token.getPrincipal());
		return "private api called. "+token.getPrincipal().getAttribute("email");
	}

}
