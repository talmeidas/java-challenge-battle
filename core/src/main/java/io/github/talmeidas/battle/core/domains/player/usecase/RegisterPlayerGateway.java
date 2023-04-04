package io.github.talmeidas.battle.core.domains.player.usecase;

import io.github.talmeidas.battle.core.domains.player.model.Player;


@FunctionalInterface
public interface RegisterPlayerGateway {

    Player execute(final Player player);
}
