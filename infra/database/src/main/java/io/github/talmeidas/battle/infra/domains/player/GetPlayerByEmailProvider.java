package io.github.talmeidas.battle.infra.domains.player;

import io.github.talmeidas.battle.core.domains.player.model.Player;
import io.github.talmeidas.battle.core.domains.player.xcutting.GetPlayerByEmailGateway;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetPlayerByEmailProvider implements GetPlayerByEmailGateway {

    private static final PlayerMapper playerMapper = Mappers.getMapper(PlayerMapper.class);
    
    private final PlayerRepository playerRepository;

    @Override
    public Optional<Player> execute(String email) {
        final Optional<PlayerEntity> optional = playerRepository.findByEmailIgnoreCase(email);
        return optional.map(playerMapper::of);
    }
}
