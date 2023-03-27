package io.github.talmeidas.battle.core.domains.game.usecase.end;

import io.github.talmeidas.battle.core.domains.game.model.Game;

import java.util.Optional;

@FunctionalInterface
public interface UpdateGameStatusByIdGateway {

    Optional<Game> execute(final Game game);
}
