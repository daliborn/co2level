package info.daliborn.co2level.co2level.service;

import info.daliborn.co2level.co2level.domain.dto.SensorDto;
import info.daliborn.co2level.co2level.domain.dto.SensorReadingDto;
import info.daliborn.co2level.co2level.repository.CityDistrictRepository;
import info.daliborn.co2level.co2level.repository.SensorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;
    private final CityDistrictRepository cityDistrictRepository;
    private final CityHallService cityHallServiceIml;
    private final DtoMapper dtoMapper;

    public SensorServiceImpl(SensorRepository sensorRepository, CityDistrictRepository cityDistrictRepository, CityHallService cityHallServiceIml, DtoMapper dtoMapper) {
        this.sensorRepository = sensorRepository;
        this.cityDistrictRepository = cityDistrictRepository;
        this.cityHallServiceIml = cityHallServiceIml;
        this.dtoMapper = dtoMapper;
    }


    public SensorDto create(SensorDto sensor) {
        var cityDistrict = cityDistrictRepository.findByCityHallUsernameAndId(cityHallServiceIml.getUsername().orElse(""),sensor.getCityDistrictId());
        if (cityDistrict.isEmpty()){
            throw new RuntimeException("City district does not exist!");
        }
        var sensorDto = sensorRepository.save(dtoMapper.mapSensor(sensor, cityDistrict.get()));
        return dtoMapper.mapSensor(sensorDto);
    }

    @Override
    public Optional<SensorReadingDto> getSensorReading(String sensorId) {
        var sensor = sensorRepository.findById(sensorId);
        if (sensor.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(dtoMapper.mapSensorReadingDto(sensor.get()));
    }
}
