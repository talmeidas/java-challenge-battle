package io.github.talmeidas.battle.infra.domains.bet;

import io.github.talmeidas.battle.core.domains.bet.model.Bet;
import io.github.talmeidas.battle.core.domains.bet.usecase.RegisterBetGateway;
import io.github.talmeidas.battle.infra.domains.quiz.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class RegisterBetProvider implements RegisterBetGateway {

    private static final BetMapper betMapper = Mappers.getMapper(BetMapper.class);

    private final BetRepository betRepository;

    private final QuizRepository quizRepository;

    @Override
    public Bet execute(final Bet bet) {
        final BetEntity betEntity = betMapper.of(bet);
        quizRepository.findById(bet.quiz().id()).ifPresent(quizEntity -> {
            quizEntity.setBet(betEntity);
            betEntity.setQuiz(quizEntity);
        });
        final BetEntity betEntity1 = betRepository.saveAndFlush(betEntity);
        return betMapper.of(betEntity1);
    }
}
