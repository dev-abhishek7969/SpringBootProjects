package weather.service.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import weather.service.api.entity.Weather;
import weather.service.api.repository.WeatherRepository;
import weather.service.api.service.CacheInspectionService;
import weather.service.api.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	WeatherService weatherService;

	@Autowired
	WeatherRepository weatherRepository;

	@Autowired
	CacheInspectionService cacheInspectionService;

	@GetMapping("/getApi")
	public String getApi() {

		return "hello";

	}

	@GetMapping
	public String getWeather(@RequestParam String city) {
		return weatherService.getWeatherByCity(city);
	}

	@PostMapping(path = "/add")
	public Weather addWeather(@RequestBody Weather weather) {
		System.out.println(weather);
		return weatherRepository.save(weather);
	}

	@GetMapping("/all")
	public List<Weather> getAllWeather() {
		return weatherRepository.findAll();
	}

	@GetMapping("/cacheData")
	public void getCacheDate() {
		cacheInspectionService.printCacheContents("weather");
	}

	@PutMapping("/{city}/{weatherFound}")
	public String updateWeather(@PathVariable String city, @PathVariable String weatherFound) {
		return weatherService.updateWeather(city, weatherFound);
	}

}
