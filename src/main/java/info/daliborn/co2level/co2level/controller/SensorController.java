package info.daliborn.co2level.co2level.controller;

import info.daliborn.co2level.co2level.domain.dto.SensorDto;
import info.daliborn.co2level.co2level.domain.dto.SensorReadingDto;
import info.daliborn.co2level.co2level.service.SensorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/sensor",
        produces="application/json")
@CrossOrigin(origins="*")
public class SensorController {
    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/{sensorId}")
    public SensorReadingDto getSensor(@PathVariable String sensorId) {
        return sensorService.getSensorReading(sensorId).orElseThrow(()->new RuntimeException("Sensor does not exist!"));
    }

    @PostMapping
    public SensorDto createSensor(@RequestBody SensorDto sensor) {
        return sensorService.create(sensor);
    }
}
