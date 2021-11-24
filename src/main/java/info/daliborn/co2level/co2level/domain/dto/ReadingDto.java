package info.daliborn.co2level.co2level.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReadingDto {
    private Float readingValue;
    private LocalDateTime time;
    private String sensorId;
}
