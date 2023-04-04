package io.github.talmeidas.battle.infra.domains.quiz;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import io.github.talmeidas.battle.core.domains.game.xcutting.GetUnansweredQuizzesByGateway;
import io.github.talmeidas.battle.core.domains.quiz.model.Quiz;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetUnansweredQuizzesByProvider implements GetUnansweredQuizzesByGateway {

    private static final QuizMapper quizMapper = Mappers.getMapper(QuizMapper.class);

    private final QuizRepository quizRepository;

    @Override
    public Optional<Quiz> execute(final Long gameId) {
        final EntityGraph entityGraph = DynamicEntityGraph.loading().addPath("game").build();
        Optional<QuizEntity> quizEntity = quizRepository.findByGameIdAndBetIsNull(gameId, entityGraph);

        return quizEntity.map(quizMapper::of);
    }
}
