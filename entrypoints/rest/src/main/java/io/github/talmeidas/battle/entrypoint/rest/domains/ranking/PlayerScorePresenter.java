package io.github.talmeidas.battle.entrypoint.rest.domains.ranking;

import io.github.talmeidas.battle.core.domains.ranking.models.PlayerScore;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PlayerScorePresenter {

    public static PlayerScoreResponse of(final PlayerScore playerScore) {
        return new PlayerScoreResponse(playerScore.playerEmail(),
                playerScore.playerName(),
                playerScore.score());
    }
}
