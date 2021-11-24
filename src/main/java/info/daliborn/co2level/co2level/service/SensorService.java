package info.daliborn.co2level.co2level.service;

import info.daliborn.co2level.co2level.domain.dto.SensorDto;
import info.daliborn.co2level.co2level.domain.dto.SensorReadingDto;

import java.util.Optional;

public interface SensorService {
    SensorDto create(SensorDto sensor);
    Optional<SensorReadingDto> getSensorReading(String sensorId);
}
