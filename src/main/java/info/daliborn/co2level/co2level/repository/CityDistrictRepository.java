package info.daliborn.co2level.co2level.repository;

import info.daliborn.co2level.co2level.domain.CityDistrict;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityDistrictRepository extends JpaRepository<CityDistrict, String> {
    Optional<CityDistrict> findByCityHallUsernameAndId(String cityHallUsername,String id);
}
