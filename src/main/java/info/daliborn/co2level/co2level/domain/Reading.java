package info.daliborn.co2level.co2level.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="READING")
@Getter
@Setter
public class Reading {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    @Column(name="READING_VALUE")
    private Float readingValue;

    @Column(name="TIME")
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name="sensorId", nullable=false)
    private Sensor sensor;
}
