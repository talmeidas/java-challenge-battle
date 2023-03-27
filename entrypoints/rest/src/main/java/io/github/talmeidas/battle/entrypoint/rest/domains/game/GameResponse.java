package io.github.talmeidas.battle.entrypoint.rest.domains.game;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public record GameResponse(
        Long id,
        PlayerResponse player,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt)
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 1698092149790294590L;
}
