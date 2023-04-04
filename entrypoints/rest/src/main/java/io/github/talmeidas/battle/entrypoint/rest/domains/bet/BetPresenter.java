package io.github.talmeidas.battle.entrypoint.rest.domains.bet;

import io.github.talmeidas.battle.core.domains.bet.model.Bet;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BetPresenter {

    public static BetResponse of(final Bet bet) {
        return new BetResponse(bet.id(),
                bet.optionId(),
                bet.winTheBet(),
                bet.createdAt(),
                bet.updatedAt());
    }
}
