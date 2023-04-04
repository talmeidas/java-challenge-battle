package io.github.talmeidas.battle.entrypoint.rest.domains.ranking;

import io.github.talmeidas.battle.core.domains.ranking.models.Ranking;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RankingPresenter {

    public static RankingResponse of(final Ranking ranking) {
        final List<PlayerScoreResponse> scores = ranking
                .getPlayersScores()
                .stream()
                .map(PlayerScorePresenter::of)
                .sorted(Comparator.comparing(PlayerScoreResponse::score).reversed())
                .toList();
        return new RankingResponse(scores);
    }
}
