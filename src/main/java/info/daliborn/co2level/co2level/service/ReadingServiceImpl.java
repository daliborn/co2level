package info.daliborn.co2level.co2level.service;

import info.daliborn.co2level.co2level.domain.Reading;
import info.daliborn.co2level.co2level.domain.dto.ReadingDto;
import info.daliborn.co2level.co2level.repository.ReadingRepository;
import info.daliborn.co2level.co2level.repository.SensorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ReadingServiceImpl implements ReadingService{
    private final ReadingRepository readingRepository;
    private final SensorRepository sensorRepository;
    private final CityHallService cityHallServiceIml;
    private final DtoMapper dtoMapper;

    public ReadingServiceImpl(ReadingRepository readingRepository, SensorRepository sensorRepository, CityHallService cityHallServiceIml, DtoMapper dtoMapper) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
        this.cityHallServiceIml = cityHallServiceIml;
        this.dtoMapper = dtoMapper;
    }

    public Iterable<Reading> findAll() {
        return readingRepository.findAll();
    }

    public Optional<ReadingDto> find(String id) {
        var reading =readingRepository.findById(id);
        return reading.map(dtoMapper::mapReading);
    }

    @Override
    public ReadingDto save(ReadingDto reading) {
        var cityHall = cityHallServiceIml.getCityHall();
        if (cityHall.isEmpty()){
            throw new RuntimeException("No city hall!");
        }
        var sensor = sensorRepository.findBySensorIdAndCityHallUsername(reading.getSensorId(),cityHall.get().getUsername());
        if (sensor.isEmpty()){
            throw new RuntimeException("Sensor does not exist");
        }
        return dtoMapper.mapReading(readingRepository.save(dtoMapper.mapReading(reading, sensor.get())));
    }


}
