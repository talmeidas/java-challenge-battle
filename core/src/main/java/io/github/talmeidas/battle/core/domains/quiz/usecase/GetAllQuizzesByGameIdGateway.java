package io.github.talmeidas.battle.core.domains.quiz.usecase;

import io.github.talmeidas.battle.core.domains.quiz.model.Quiz;

import java.util.List;


@FunctionalInterface
public interface GetAllQuizzesByGameIdGateway {

    List<Quiz> execute(final Long gameId);
}
