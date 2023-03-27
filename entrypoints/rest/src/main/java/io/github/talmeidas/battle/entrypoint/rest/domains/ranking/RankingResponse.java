package io.github.talmeidas.battle.entrypoint.rest.domains.ranking;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record RankingResponse(List<PlayerScoreResponse> scores) implements Serializable {

    @Serial
    private static final long serialVersionUID = 329774416403185866L;
}
