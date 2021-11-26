package info.daliborn.co2level.co2level.service;

import info.daliborn.co2level.co2level.domain.CityDistrict;
import info.daliborn.co2level.co2level.domain.Sensor;
import info.daliborn.co2level.co2level.domain.dto.SensorDto;
import info.daliborn.co2level.co2level.domain.dto.SensorReadingDto;
import info.daliborn.co2level.co2level.repository.CityDistrictRepository;
import info.daliborn.co2level.co2level.repository.SensorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class SensorServiceImplTest {
    SensorServiceImpl sensorServiceImpl;
    @MockBean
    private SensorRepository sensorRepository;
    @MockBean
    private CityDistrictRepository cityDistrictRepository;
    @MockBean
    private CityHallService cityHallServiceIml;
    @MockBean
    private DtoMapper dtoMapper;

    @BeforeEach
    void setUp() {
        sensorServiceImpl = new SensorServiceImpl(sensorRepository,cityDistrictRepository,cityHallServiceIml,dtoMapper);
    }

    @Test
    void create() {
        SensorDto dto = new SensorDto();
        dto.setCityDistrictId("district1");
        when(cityHallServiceIml.getUsername()).thenReturn(Optional.of("username"));
        CityDistrict district = new CityDistrict();
        when(cityDistrictRepository.findByCityHallUsernameAndId(eq("username"),eq("district1"))).thenReturn(Optional.of(district));
        Sensor sensor = new Sensor();
        when(dtoMapper.mapSensor(eq(dto), eq(district))).thenReturn(sensor);
        when(sensorRepository.save(eq(sensor))).thenReturn(sensor);
        SensorDto dtoResult = new SensorDto();
        dtoResult.setSensorId("1");
        when(dtoMapper.mapSensor(eq(sensor))).thenReturn(dtoResult);

        var result = sensorServiceImpl.create(dto);

        assertNotNull(result);
        assertEquals("1",result.getSensorId());
    }

    @Test
    void getSensorReading() {
        Sensor sensor = new Sensor();
        when(sensorRepository.findById(eq("1"))).thenReturn(Optional.of(sensor));
        SensorReadingDto dto = new SensorReadingDto();
        dto.setCityHall("hall");
        when(dtoMapper.mapSensorReadingDto(eq(sensor))).thenReturn(dto);

        var result = sensorServiceImpl.getSensorReading("1");
        assertNotNull(result);
        assertEquals("hall",result.get().getCityHall());
    }
}