package io.github.talmeidas.battle.core.domains.ranking.usecase;

import io.github.talmeidas.battle.core.domains.ranking.models.Ranking;


@FunctionalInterface
public interface GetGeneralRankingUseCase {

    Ranking execute();
}