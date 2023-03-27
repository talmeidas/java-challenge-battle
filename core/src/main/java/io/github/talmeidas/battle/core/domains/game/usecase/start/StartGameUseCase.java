package io.github.talmeidas.battle.core.domains.game.usecase.start;

import io.github.talmeidas.battle.core.domains.game.model.Game;

@FunctionalInterface
public interface StartGameUseCase {

    Game execute(final StartGameCommand command);
}
