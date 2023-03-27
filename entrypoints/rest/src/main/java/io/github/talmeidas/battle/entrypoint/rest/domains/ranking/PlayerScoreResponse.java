package io.github.talmeidas.battle.entrypoint.rest.domains.ranking;

import java.io.Serial;
import java.io.Serializable;

public record PlayerScoreResponse(
        String playerEmail,
        String playerName,
        Float score)
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 329774416403185866L;
}
