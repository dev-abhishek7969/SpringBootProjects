package weather.service.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import weather.service.api.entity.Weather;
import weather.service.api.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	WeatherRepository weatherRepository;
	
	@Cacheable(value="weather",key = "#city")
	public String getWeatherByCity(String city) {
		Optional<Weather> weather = weatherRepository.findByCity(city);
		return weather.map(Weather::getForecast).orElse("Weather data not available");		
	}
	
	@CachePut(value="weather",key = "#city")
	public String updateWeather(String city,String weatherUpdate) {
		weatherRepository.findByCity(city).ifPresent( w ->{
			w.setForecast(weatherUpdate);
			weatherRepository.save(w);
		});
		return weatherUpdate;
	}

}
