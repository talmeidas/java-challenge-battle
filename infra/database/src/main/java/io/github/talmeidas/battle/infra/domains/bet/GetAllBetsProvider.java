package io.github.talmeidas.battle.infra.domains.bet;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import io.github.talmeidas.battle.core.domains.bet.model.Bet;
import io.github.talmeidas.battle.core.domains.bet.xcutting.GetAllBetsGateway;
import io.github.talmeidas.battle.infra.common.ListMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Transactional
@Service
public class GetAllBetsProvider implements GetAllBetsGateway {

    private final ListMapper<Bet, BetEntity> listMapper = new ListMapper<>() { };
    private static final BetMapper betMapper = Mappers.getMapper(BetMapper.class);

    private final BetRepository betRepository;

    @Override
    public List<Bet> execute() {
        final EntityGraph entityGraph = DynamicEntityGraph.loading().addPath("quiz", "game", "player").build();
        final List<BetEntity> bets = betRepository.findAll(entityGraph);

        return listMapper.of(bets, betMapper::of);
    }
}
