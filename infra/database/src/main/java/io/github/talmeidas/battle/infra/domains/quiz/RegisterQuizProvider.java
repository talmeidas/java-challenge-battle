package io.github.talmeidas.battle.infra.domains.quiz;

import io.github.talmeidas.battle.core.domains.quiz.model.Quiz;
import io.github.talmeidas.battle.core.domains.quiz.usecase.RegisterQuizGateway;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class RegisterQuizProvider implements RegisterQuizGateway {

    private static final QuizMapper quizMapper = Mappers.getMapper(QuizMapper.class);
    
    private final QuizRepository quizRepository;

    @Override
    public Quiz execute(final Quiz quiz) {
        final QuizEntity quizEntity = quizMapper.of(quiz);
        return quizMapper.of(quizRepository.saveAndFlush(quizEntity));
    }
}
