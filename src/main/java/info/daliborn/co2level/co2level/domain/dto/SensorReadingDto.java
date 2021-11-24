package info.daliborn.co2level.co2level.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class SensorReadingDto {
    private String cityDistrict;
    private String cityHall;
    private List<ReadingDto> readings;
}
