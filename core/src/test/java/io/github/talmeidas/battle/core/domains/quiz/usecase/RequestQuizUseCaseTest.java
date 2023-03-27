package io.github.talmeidas.battle.core.domains.quiz.usecase;

import io.github.talmeidas.battle.core.common.GetLocalDateTime;
import io.github.talmeidas.battle.core.domains.game.model.Game;
import io.github.talmeidas.battle.core.domains.game.model.Status;
import io.github.talmeidas.battle.core.domains.game.xcutting.GetGameByPlayerIdAndStatusGateway;
import io.github.talmeidas.battle.core.domains.game.xcutting.GetUnansweredQuizzesByGateway;
import io.github.talmeidas.battle.core.domains.movie.xcutting.GetAllMoviesCountGateway;
import io.github.talmeidas.battle.core.domains.movie.xcutting.GetRandomMovieGateway;
import io.github.talmeidas.battle.core.domains.player.model.Player;
import io.github.talmeidas.battle.core.domains.player.usecase.RegisterPlayerUseCase;
import io.github.talmeidas.battle.core.domains.player.xcutting.GetPlayerByEmailGateway;
import io.github.talmeidas.battle.core.domains.quiz.model.Quiz;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("Request Quiz Use Case Test")
class RequestQuizUseCaseTest {

    @Mock private final GetPlayerByEmailGateway getPlayerByEmailGateway = Mockito.mock(GetPlayerByEmailGateway.class);
    @Mock private final RegisterPlayerUseCase registerPlayerUseCase = Mockito.mock(RegisterPlayerUseCase.class);
    @Mock private final GetGameByPlayerIdAndStatusGateway getGameByPlayerIdAndStatusGateway = Mockito.mock(GetGameByPlayerIdAndStatusGateway.class);
    @Mock private final GetUnansweredQuizzesByGateway getUnansweredQuizzesByGateway = Mockito.mock(GetUnansweredQuizzesByGateway.class);
    @Mock private final GetRandomMovieGateway getRandomMovieGateway = Mockito.mock(GetRandomMovieGateway.class);
    @Mock private final GetAllMoviesCountGateway getAllMoviesCountGateway = Mockito.mock(GetAllMoviesCountGateway.class);
    @Mock private final GetAllQuizzesByGameIdGateway getAllQuizzesByGameIdGateway = Mockito.mock(GetAllQuizzesByGameIdGateway.class);
    @Mock private final GetLocalDateTime getLocalDateTime = Mockito.mock(GetLocalDateTime.class);
    @Mock private final RegisterQuizGateway registerQuizGateway = Mockito.mock(RegisterQuizGateway.class);

    @InjectMocks
    private final RequestQuizUseCase requestQuizUseCase =
            new RequestQuizUseCaseImpl(
                    getPlayerByEmailGateway,
                    registerPlayerUseCase,
                    getGameByPlayerIdAndStatusGateway,
                    getUnansweredQuizzesByGateway,
                    getRandomMovieGateway,
                    getAllMoviesCountGateway,
                    getAllQuizzesByGameIdGateway,
                    getLocalDateTime,
                    registerQuizGateway);

    @DisplayName("Fail to request quiz with invalid action")
    @Test
    void failToRequestQuizWithInvalidAction() {
        // Arrange
        when(getPlayerByEmailGateway.execute("john.smith.zero@xyz.com"))
                .thenReturn(Optional.of(buildJohnSmithPlayer()));

        when(getGameByPlayerIdAndStatusGateway.execute(1L, Status.IN_PROGRESS))
                .thenReturn(Optional.of(buildRegisteredGame()));

        when(getUnansweredQuizzesByGateway.execute(1L))
                .thenReturn(Optional.of(buildRegisteredQuiz()));

        RequestQuizCommand command = new RequestQuizCommand("john.smith.zero@xyz.com", "John Smith");

        // Act
        final Quiz quiz = requestQuizUseCase.execute(command);

        // Assert
        assertThat(quiz).isNotNull();
        assertThat(quiz.id()).isEqualTo(1L);

        Assertions.assertThat(quiz.game()).isNotNull();
        Assertions.assertThat(quiz.game().id()).isEqualTo(1L);
        Assertions.assertThat(quiz.game().player().id()).isEqualTo(1L);
        Assertions.assertThat(quiz.game().player().name()).isEqualTo("John Smith");
        Assertions.assertThat(quiz.game().player().email()).isEqualTo("john.smith.zero@xyz.com");
        Assertions.assertThat(quiz.game().player().createdAt()).isEqualTo(LocalDateTime.parse("2020-03-12T22:04:59.123"));
        Assertions.assertThat(quiz.game().player().updatedAt()).isEqualTo(LocalDateTime.parse("2020-03-12T22:04:59.123"));
        Assertions.assertThat(quiz.game().status()).isEqualTo(Status.IN_PROGRESS);
        Assertions.assertThat(quiz.game().createdAt()).isEqualTo(LocalDateTime.parse("2020-03-12T22:04:59.123"));
        Assertions.assertThat(quiz.game().updatedAt()).isEqualTo(LocalDateTime.parse("2020-03-12T22:04:59.123"));

        Assertions.assertThat(quiz.bet()).isNull();
        assertThat(quiz.optionOneId()).isEqualTo("tt0111161");
        assertThat(quiz.optionOneTitle()).isEqualTo("The Shawshank Redemption");
        assertThat(quiz.optionOneYear()).isEqualTo("1994");
        assertThat(quiz.optionTwoId()).isEqualTo("tt0468569");
        assertThat(quiz.optionTwoTitle()).isEqualTo("The Dark Knight");
        assertThat(quiz.optionTwoYear()).isEqualTo("2008");
        assertThat(quiz.createdAt()).isEqualTo(LocalDateTime.parse("2020-03-12T22:04:59.123"));
        assertThat(quiz.updatedAt()).isEqualTo(LocalDateTime.parse("2020-03-12T22:04:59.123"));
    }

    private static Player buildJohnSmithPlayer() {
        return new Player(1L, "John Smith", "john.smith.zero@xyz.com",
                LocalDateTime.parse("2020-03-12T22:04:59.123"),
                LocalDateTime.parse("2020-03-12T22:04:59.123"));
    }

    private static Game buildRegisteredGame() {
        return new Game(1L, buildJohnSmithPlayer(), Status.IN_PROGRESS,
                LocalDateTime.parse("2020-03-12T22:04:59.123"),
                LocalDateTime.parse("2020-03-12T22:04:59.123")
        );
    }

    private static Quiz buildRegisteredQuiz() {
        return new Quiz(1L, buildRegisteredGame(), null,
                "tt0111161", "The Shawshank Redemption", "1994",
                "tt0468569", "The Dark Knight", "2008",
                LocalDateTime.parse("2020-03-12T22:04:59.123"),
                LocalDateTime.parse("2020-03-12T22:04:59.123"));
    }
}
