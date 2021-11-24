package info.daliborn.co2level.co2level.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="AUTHORITIES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AuthoritiesId.class)
public class Authorities {
    @Id
    private String authority;
    @Id
    private String username;
}
