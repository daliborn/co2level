package info.daliborn.co2level.co2level.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="SENSOR")
@Getter
@Setter
public class Sensor {
    @Id
    private String sensorId;

    @ManyToOne
    @JoinColumn(name="city_hall_username", nullable=false)
    private CityHall cityHall;

    @ManyToOne
    @JoinColumn(name="id")
    private CityDistrict cityDistrict;

    @OneToMany(
            mappedBy = "sensor",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<Reading> sensorReadings;
}
