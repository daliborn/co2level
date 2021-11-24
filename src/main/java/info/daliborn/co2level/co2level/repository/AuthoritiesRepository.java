package info.daliborn.co2level.co2level.repository;

import info.daliborn.co2level.co2level.domain.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {
}
