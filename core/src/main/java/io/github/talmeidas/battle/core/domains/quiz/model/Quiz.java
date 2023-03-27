package io.github.talmeidas.battle.core.domains.quiz.model;

import io.github.talmeidas.battle.core.domains.bet.model.Bet;
import io.github.talmeidas.battle.core.domains.game.model.Game;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Generated
public record Quiz(
        Long id,
        Game game,
        Bet bet,
        String optionOneId,
        String optionOneTitle,
        String optionOneYear,
        String optionTwoId,
        String optionTwoTitle,
        String optionTwoYear,
        LocalDateTime createdAt,
        LocalDateTime updatedAt)
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 8231755197403971745L;
}
