package weather.service.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="weather")
public class Weather {

	@Id
	@GeneratedValue	
	private Long id;
	private String forecast;
	private String city;
	
	public Weather() {
		
	}
	
	public Weather(String city,String forecast) {
		this.city = city;
		this.forecast = forecast;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
