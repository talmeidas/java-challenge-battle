package io.github.talmeidas.battle.core.domains.bet.xcutting;

import io.github.talmeidas.battle.core.domains.bet.model.Bet;

import java.util.List;


@FunctionalInterface
public interface GetAllBetsGateway {

    List<Bet> execute();
}
