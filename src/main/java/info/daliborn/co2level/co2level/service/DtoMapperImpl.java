package info.daliborn.co2level.co2level.service;

import info.daliborn.co2level.co2level.domain.CityDistrict;
import info.daliborn.co2level.co2level.domain.Reading;
import info.daliborn.co2level.co2level.domain.Sensor;
import info.daliborn.co2level.co2level.domain.dto.ReadingDto;
import info.daliborn.co2level.co2level.domain.dto.SensorDto;
import info.daliborn.co2level.co2level.domain.dto.SensorReadingDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DtoMapperImpl implements DtoMapper {
    @Override
    public SensorReadingDto mapSensorReadingDto(Sensor sensor){
        var sensorReading = new SensorReadingDto();
        sensorReading.setCityDistrict(sensor.getCityDistrict()!=null?sensor.getCityDistrict().getName():null);
        sensorReading.setCityHall(sensor.getCityHall()!=null?sensor.getCityHall().getUsername():null);
        if(sensor.getSensorReadings()!=null) {
            sensorReading.setReadings(sensor.getSensorReadings().stream().map(this::mapReading).collect(Collectors.toList()));
        }
        return sensorReading;
    }

    @Override
    public Sensor mapSensor(SensorDto dto, CityDistrict cityDistrict){
        var sensor = new Sensor();
        sensor.setSensorId(dto.getSensorId());
        sensor.setCityDistrict(cityDistrict);
        sensor.setCityHall(cityDistrict.getCityHall());
        return sensor;
    }

    @Override
    public SensorDto mapSensor(Sensor sensor){
        var sensorDto = new SensorDto();
        sensorDto.setSensorId(sensor.getSensorId());
        sensorDto.setCityDistrictId(sensor.getCityDistrict().getId());
        return sensorDto;
    }

    @Override
    public Reading mapReading(ReadingDto reading, Sensor sensor){
        var entity = new Reading();
        entity.setReadingValue(reading.getReadingValue());
        entity.setTime(reading.getTime());
        entity.setSensor(sensor);
        return entity;
    }

    @Override
    public ReadingDto mapReading(Reading reading){
        var entity = new ReadingDto();
        entity.setReadingValue(reading.getReadingValue());
        entity.setTime(reading.getTime());
        var sensor = Optional.ofNullable(reading.getSensor());
        sensor.ifPresent(value -> entity.setSensorId(value.getSensorId()));
        return entity;
    }
}
