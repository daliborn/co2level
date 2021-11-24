package info.daliborn.co2level.co2level.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="CITYHALL")
@Getter
@Setter
public class CityHall {
    @Id
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "boolean default true")
    private Boolean enabled;

    @OneToMany(mappedBy="username")
    private Set<Authorities> roles;

    @OneToMany
    private Set<CityDistrict> cityDistricts;
}
