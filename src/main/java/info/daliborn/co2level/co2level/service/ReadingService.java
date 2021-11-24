package info.daliborn.co2level.co2level.service;

import info.daliborn.co2level.co2level.domain.dto.ReadingDto;

import java.util.Optional;

public interface ReadingService {
    Optional<ReadingDto> find(String id);
    ReadingDto save(ReadingDto reading);
}
