package io.github.talmeidas.battle.infra.domains.movie;

import lombok.Generated;

import java.io.Serial;
import java.io.Serializable;


@Generated
public record MoviesCountResponse(Long count) implements Serializable {

    @Serial
    private static final long serialVersionUID = -8366908225523005779L;
}
