package info.daliborn.co2level.co2level.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuthoritiesId implements Serializable {
    private String authority;
    private String username;
}
