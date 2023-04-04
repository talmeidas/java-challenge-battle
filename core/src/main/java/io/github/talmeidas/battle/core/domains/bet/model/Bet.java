package io.github.talmeidas.battle.core.domains.bet.model;

import io.github.talmeidas.battle.core.domains.quiz.model.Quiz;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Generated
public record Bet(
        Long id,
        Quiz quiz,
        String optionId,
        Boolean winTheBet,
        LocalDateTime createdAt,
        LocalDateTime updatedAt)
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 2369191175204185991L;
}
