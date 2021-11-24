
package info.daliborn.co2level.co2level.repository;

import info.daliborn.co2level.co2level.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String>{
    Optional<Sensor> findBySensorIdAndCityHallUsername(String sensorId, String cityHallUsername);
}
