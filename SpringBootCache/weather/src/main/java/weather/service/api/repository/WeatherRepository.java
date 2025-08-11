package weather.service.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import weather.service.api.entity.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>{

	Optional<Weather> findByCity(String city);
	void deleteByCity(String city);
}
