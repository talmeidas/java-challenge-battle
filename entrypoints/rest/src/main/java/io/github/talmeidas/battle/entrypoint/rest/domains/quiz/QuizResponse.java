package io.github.talmeidas.battle.entrypoint.rest.domains.quiz;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public record QuizResponse(
        Long id,
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
    private static final long serialVersionUID = 9217004935831572247L;
}
