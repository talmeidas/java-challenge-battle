package io.github.talmeidas.battle.core.domains.ranking.models;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Generated
public record PlayerScore(String playerEmail, String playerName, Float score) implements Serializable {

    @Serial
    private static final long serialVersionUID = 8231755197403971745L;
}
