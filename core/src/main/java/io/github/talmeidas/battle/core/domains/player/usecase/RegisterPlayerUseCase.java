package io.github.talmeidas.battle.core.domains.player.usecase;

import io.github.talmeidas.battle.core.domains.player.model.Player;

@FunctionalInterface
public interface RegisterPlayerUseCase {

    Player execute(final RegisterPlayerCommand parameters);
}
