package info.daliborn.co2level.co2level.service;

import info.daliborn.co2level.co2level.domain.CityHall;

import java.util.Optional;

public interface CityHallService {
    Optional<String> getUsername();

    Optional<CityHall> getCityHall();
}
