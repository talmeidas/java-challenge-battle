package io.github.talmeidas.battle.infra.domains.bet;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends EntityGraphJpaRepository<BetEntity, Long>, EntityGraphQuerydslPredicateExecutor<BetEntity> {

    List<BetEntity> findAll(final EntityGraph entityGraph);
}