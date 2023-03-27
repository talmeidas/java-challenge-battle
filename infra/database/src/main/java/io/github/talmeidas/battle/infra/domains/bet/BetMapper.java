package io.github.talmeidas.battle.infra.domains.bet;

import io.github.talmeidas.battle.core.domains.bet.model.Bet;
import io.github.talmeidas.battle.core.domains.quiz.model.Quiz;
import io.github.talmeidas.battle.infra.domains.quiz.QuizEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BetMapper {

    Bet of(final BetEntity betEntity);
    BetEntity of(final Bet bet);

    @Mapping(target = "bet", ignore = true)
    QuizEntity of(Quiz quiz);

    @Mapping(target = "bet", ignore = true)
    Quiz of(QuizEntity quiz);
}