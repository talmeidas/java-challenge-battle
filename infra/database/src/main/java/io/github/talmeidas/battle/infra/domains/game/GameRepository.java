package io.github.talmeidas.battle.infra.domains.game;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GameRepository extends EntityGraphJpaRepository<GameEntity, Long>, EntityGraphQuerydslPredicateExecutor<GameEntity> {

    Optional<GameEntity> findByStatusIgnoreCaseAndPlayerId(final String status, final Long playerId, final EntityGraph entityGraph);
}
