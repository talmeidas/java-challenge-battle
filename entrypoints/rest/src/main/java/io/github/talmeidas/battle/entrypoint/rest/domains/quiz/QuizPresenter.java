package io.github.talmeidas.battle.entrypoint.rest.domains.quiz;

import io.github.talmeidas.battle.core.domains.quiz.model.Quiz;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class QuizPresenter {

    public static QuizResponse of(final Quiz quiz) {
        return new QuizResponse(quiz.id(),
                quiz.optionOneId(),
                quiz.optionOneTitle(),
                quiz.optionOneYear(),
                quiz.optionTwoId(),
                quiz.optionTwoTitle(),
                quiz.optionTwoYear(),
                quiz.createdAt(),
                quiz.updatedAt());
    }
}
