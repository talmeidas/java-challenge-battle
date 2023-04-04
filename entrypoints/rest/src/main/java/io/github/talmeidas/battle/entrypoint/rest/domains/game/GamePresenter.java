package io.github.talmeidas.battle.entrypoint.rest.domains.game;

import io.github.talmeidas.battle.core.domains.game.model.Game;
import io.github.talmeidas.battle.core.domains.player.model.Player;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GamePresenter {

    public static GameResponse of(final Game game) {
        return new GameResponse(game.id(),
                                     of(game.player()),
                                        game.status().name(),
                                        game.createdAt(),
                                        game.updatedAt());
    }

    public static PlayerResponse of(final Player player) {
        return new PlayerResponse(player.id(),
                                  player.name(),
                                  player.email(),
                                  player.createdAt(),
                                  player.updatedAt());
    }
}
