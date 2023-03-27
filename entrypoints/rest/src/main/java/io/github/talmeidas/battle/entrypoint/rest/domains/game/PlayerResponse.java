package io.github.talmeidas.battle.entrypoint.rest.domains.game;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public record PlayerResponse(
        Long id,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt)
        implements Serializable {

    @Serial
    private static final long serialVersionUID = -2882249634089711164L;
}
