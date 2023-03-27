package io.github.talmeidas.battle.core.domains.game.model;

import io.github.talmeidas.battle.core.domains.player.model.Player;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Generated
public record Game(
        Long id,
        Player player,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt)
        implements Serializable {

    @Serial
    private static final long serialVersionUID = -5142356851101054436L;
}
