package io.github.talmeidas.battle.infra.domains.game;

import io.github.talmeidas.battle.core.domains.game.model.Game;
import io.github.talmeidas.battle.core.domains.game.usecase.start.RegisterGameGateway;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class RegisterGameProvider implements RegisterGameGateway {

    private static final GameMapper gameMapper = Mappers.getMapper(GameMapper.class);
    
    private final GameRepository gameRepository;

    @Override
    public Game execute(final Game game) {
        final GameEntity gameEntityToPersist = gameMapper.of(game);
        final GameEntity gameEntity = gameRepository.save(gameEntityToPersist);
        return gameMapper.of(gameEntity);
    }
}
