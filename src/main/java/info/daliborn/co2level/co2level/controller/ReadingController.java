package info.daliborn.co2level.co2level.controller;

import info.daliborn.co2level.co2level.domain.Reading;
import info.daliborn.co2level.co2level.domain.dto.ReadingDto;
import info.daliborn.co2level.co2level.service.ReadingServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path="/v1/reading",
        produces="application/json")
@CrossOrigin(origins="*")
public class ReadingController {
    private final ReadingServiceImpl readingService;

    public ReadingController(ReadingServiceImpl readingService) {
        this.readingService = readingService;
    }

    @GetMapping
    public Iterable<Reading> allReadings() {
        return readingService.findAll();
    }

    @GetMapping("/{id}")
    public ReadingDto getReading(@PathVariable String id) {
        var dto = new ReadingDto();
        dto.setTime(LocalDateTime.now());
        return readingService.find(id).orElse(dto);
    }

    @PostMapping
    public ReadingDto save(@RequestBody ReadingDto reading) {
        return readingService.save(reading);
    }
}
