package info.daliborn.co2level.co2level.service;

import info.daliborn.co2level.co2level.domain.CityHall;
import info.daliborn.co2level.co2level.repository.CityHallRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityHallServiceIml implements CityHallService {
    private final CityHallRepository cityHallRepository;

    public CityHallServiceIml(CityHallRepository cityHallRepository) {
        this.cityHallRepository = cityHallRepository;
    }

    public Optional<String> getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return Optional.ofNullable(currentUserName);
        }
        return Optional.empty();
    }

    public Optional<CityHall> getCityHall(){
            return cityHallRepository.findById(getUsername().orElse(""));
    }
}
