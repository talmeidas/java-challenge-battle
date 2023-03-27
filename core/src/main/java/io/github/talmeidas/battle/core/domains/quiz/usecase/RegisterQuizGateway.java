package io.github.talmeidas.battle.core.domains.quiz.usecase;

import io.github.talmeidas.battle.core.domains.quiz.model.Quiz;

@FunctionalInterface
public interface RegisterQuizGateway {

    Quiz execute(final Quiz quiz);
}
