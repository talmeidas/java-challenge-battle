package io.github.talmeidas.battle.infra.domains.game;

import io.github.talmeidas.battle.core.domains.game.model.Game;
import io.github.talmeidas.battle.infra.domains.player.PlayerMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {PlayerMapper.class})
public interface GameMapper {

    Game of(final GameEntity gameEntity);
    GameEntity of(final Game game);
}
