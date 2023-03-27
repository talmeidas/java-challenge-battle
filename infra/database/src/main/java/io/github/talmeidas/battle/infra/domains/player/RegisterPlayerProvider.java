package io.github.talmeidas.battle.infra.domains.player;

import io.github.talmeidas.battle.core.domains.player.model.Player;
import io.github.talmeidas.battle.core.domains.player.usecase.RegisterPlayerGateway;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class RegisterPlayerProvider implements RegisterPlayerGateway {

    private final PlayerMapper playerMapper = Mappers.getMapper(PlayerMapper.class);
    
    private final PlayerRepository playerRepository;

    @Override
    public Player execute(final Player player) {
        final PlayerEntity playerEntity = playerMapper.of(player);
        return playerMapper.of(playerRepository.saveAndFlush(playerEntity));
    }
}
