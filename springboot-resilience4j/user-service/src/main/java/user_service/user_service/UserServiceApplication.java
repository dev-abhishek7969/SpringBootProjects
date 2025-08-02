package user_service.user_service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import user_service.user_service.dto.OrderDTO;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@RequestMapping("/user-service")
public class UserServiceApplication {

	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	public static final String USER_SERVICE = "userService";

	private static final String BASEURL = "http://localhost:9191/orders";

	private int attempt = 1;

	@GetMapping("/displayOrders")
	@CircuitBreaker(name = USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
//    @Retry(name = USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
	public List<OrderDTO> displayOrders(@RequestParam("category") String category) {
		String url = category == null ? BASEURL : BASEURL + "/" + category;
		return restTemplate.getForObject(url, ArrayList.class);
	}

	
	public List<OrderDTO> getAllAvailableProducts(Exception e){		
		return Stream.of(
				new OrderDTO(1,"Default product 1","Default Category1","white",450),
				new OrderDTO(2,"Default product 2","Default Category2","white",400),
				new OrderDTO(3,"Default product 3","Default Category3","white",200),
				new OrderDTO(4,"Default product 4","Default Category4","white",435)

		).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
