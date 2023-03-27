package io.github.talmeidas.battle.infra.domains.player;

import io.github.talmeidas.battle.core.domains.player.model.Player;
import org.mapstruct.Mapper;

@Mapper
public interface PlayerMapper {
    Player of(final PlayerEntity playerEntity);
    PlayerEntity of(final Player player);
}
