package io.github.talmeidas.battle.infra.domains.game;

import io.github.talmeidas.battle.core.domains.game.model.Game;
import io.github.talmeidas.battle.core.domains.game.model.Status;
import io.github.talmeidas.battle.core.domains.player.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Register Game Provider Test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({RegisterGameProvider.class})
@Sql("RegisterGameProviderTest.sql")
class RegisterGameProviderTest {

    @Autowired
    private RegisterGameProvider registerGameProvider;

    @Autowired
    private GameRepository gameRepository;

    @DisplayName("Register Game")
    @Test
    void successfulToRegisterGame() {
        // Arrange
        final Player player = new Player(
                1L,
                "John Smith",
                "john.smith.zero@xyz.com",
                LocalDateTime.parse("2020-03-12T22:04:59.123"),
                LocalDateTime.parse("2020-03-12T22:04:59.123"));

        final Game newGame = new Game(
                null,
                player,
                Status.IN_PROGRESS,
                LocalDateTime.parse("2020-03-12T22:04:59.123"),
                LocalDateTime.parse("2020-03-12T22:04:59.123")
        );

        // Act
        final Game game = registerGameProvider.execute(newGame);

        // Assert
        assertThat(game).isNotNull();
        assertThat(game.id()).isNotNull();
        assertThat(game.player()).isNotNull();
        assertThat(game.player()).isEqualTo(player);
        assertThat(game.status()).isEqualTo(Status.IN_PROGRESS);
        assertThat(game.createdAt()).isEqualTo(LocalDateTime.parse("2020-03-12T22:04:59.123"));
        assertThat(game.updatedAt()).isEqualTo(LocalDateTime.parse("2020-03-12T22:04:59.123"));

        assertThat(gameRepository.count()).isEqualTo(2L);
    }
}
