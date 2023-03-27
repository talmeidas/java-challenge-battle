package io.github.talmeidas.battle.infra.domains.quiz;

import io.github.talmeidas.battle.core.domains.bet.model.Bet;
import io.github.talmeidas.battle.core.domains.quiz.model.Quiz;
import io.github.talmeidas.battle.infra.domains.bet.BetEntity;
import io.github.talmeidas.battle.infra.domains.game.GameMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {GameMapper.class})
public interface QuizMapper {

    Quiz of(final QuizEntity quizEntity);
    QuizEntity of(final Quiz quiz);

    @Mapping(target = "quiz", ignore = true)
    BetEntity of(Bet bet);

    @Mapping(target = "quiz", ignore = true)
    Bet of(BetEntity bet);
}
