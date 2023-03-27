package io.github.talmeidas.battle.core.domains.bet.usecase;

import io.github.talmeidas.battle.core.domains.bet.model.Bet;

@FunctionalInterface
public interface RegisterBetUseCase {

    Bet execute(final RegisterBetCommand command) ;
}
