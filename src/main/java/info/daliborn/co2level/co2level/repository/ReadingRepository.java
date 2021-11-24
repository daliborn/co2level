
package info.daliborn.co2level.co2level.repository;


import info.daliborn.co2level.co2level.domain.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<Reading, String> {

}
