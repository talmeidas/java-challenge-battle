package io.github.talmeidas.battle.core.domains.player.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Generated
public record Player(
        Long id,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt)
        implements Serializable {

    @Serial
    private static final long serialVersionUID = -3375023988104084177L;
}
