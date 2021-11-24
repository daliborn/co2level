package info.daliborn.co2level.co2level.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CITYDISTRICT")
@Getter
@Setter
public class CityDistrict {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    private String name;

    @ManyToOne
    @JoinColumn(name="city_hall_username", nullable=false)
    private CityHall cityHall;

    @OneToMany(
            mappedBy = "cityDistrict",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Sensor> sensorReadings = new ArrayList<>();
}
