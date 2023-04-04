package io.github.talmeidas.battle.core.domains.game.usecase.end;

import io.github.talmeidas.battle.core.domains.game.model.Game;


@FunctionalInterface
public interface EndGameUseCase {

    Game execute(final EndGameCommand parameters);
}
