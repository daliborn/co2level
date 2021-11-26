package info.daliborn.co2level.co2level.controller;

import info.daliborn.co2level.co2level.domain.Authorities;
import info.daliborn.co2level.co2level.domain.CityHall;
import info.daliborn.co2level.co2level.repository.AuthoritiesRepository;
import info.daliborn.co2level.co2level.repository.CityHallRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/v1/admin",
        produces="application/json",
        consumes = "application/json")
@CrossOrigin(origins="*")
public class AdminController {
    private final CityHallRepository cityHallRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthoritiesRepository authoritiesRepository;

    public AdminController(CityHallRepository cityHallRepository, PasswordEncoder passwordEncoder, AuthoritiesRepository authoritiesRepository) {
        this.cityHallRepository = cityHallRepository;
        this.passwordEncoder = passwordEncoder;
        this.authoritiesRepository = authoritiesRepository;
    }

    @PostMapping("/user")
    public CityHall saveUser(@RequestBody CityHall user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return cityHallRepository.save(user);
    }

    @PostMapping("/authorities")
    public Authorities save(@RequestBody Authorities authorities) {
        return authoritiesRepository.save(authorities);
    }

    @GetMapping("/citydistricts")
    public Authorities get() {
        return new Authorities();
    }
}
