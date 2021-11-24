package info.daliborn.co2level.co2level.service;

import info.daliborn.co2level.co2level.domain.CityDistrict;
import info.daliborn.co2level.co2level.domain.Sensor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtoMapperTest {
    DtoMapper dtoMapper;

    @BeforeEach
    void setUp() {
        dtoMapper = new DtoMapper();
    }

    @Test
    @DisplayName("City distrct mapping should work")
    void mapSensorReadingDto() {
        Sensor sensor = new Sensor();
        CityDistrict district = new CityDistrict();
        district.setName("test");
        sensor.setCityDistrict(district);
        var result = dtoMapper.mapSensorReadingDto(sensor);
        assertEquals("test",result.getCityDistrict());
    }
}