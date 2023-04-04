package io.github.talmeidas.battle.core.domains.player.xcutting;

import io.github.talmeidas.battle.core.domains.player.model.Player;

import java.util.Optional;


@FunctionalInterface
public interface GetPlayerByEmailGateway {

    Optional<Player> execute(final String email);
}