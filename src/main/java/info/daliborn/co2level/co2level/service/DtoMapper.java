package info.daliborn.co2level.co2level.service;

import info.daliborn.co2level.co2level.domain.CityDistrict;
import info.daliborn.co2level.co2level.domain.Reading;
import info.daliborn.co2level.co2level.domain.Sensor;
import info.daliborn.co2level.co2level.domain.dto.ReadingDto;
import info.daliborn.co2level.co2level.domain.dto.SensorDto;
import info.daliborn.co2level.co2level.domain.dto.SensorReadingDto;

public interface DtoMapper {
    SensorReadingDto mapSensorReadingDto(Sensor sensor);

    Sensor mapSensor(SensorDto dto, CityDistrict cityDistrict);

    SensorDto mapSensor(Sensor sensor);

    Reading mapReading(ReadingDto reading, Sensor sensor);

    ReadingDto mapReading(Reading reading);
}
