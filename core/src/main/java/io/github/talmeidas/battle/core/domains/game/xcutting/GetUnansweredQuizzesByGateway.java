package io.github.talmeidas.battle.core.domains.game.xcutting;

import io.github.talmeidas.battle.core.domains.quiz.model.Quiz;

import java.util.Optional;

@FunctionalInterface
public interface GetUnansweredQuizzesByGateway {

    Optional<Quiz> execute(final Long gameId);
}
