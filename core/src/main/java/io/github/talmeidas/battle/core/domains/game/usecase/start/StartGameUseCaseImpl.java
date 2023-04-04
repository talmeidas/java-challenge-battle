package io.github.talmeidas.battle.core.domains.game.usecase.start;

import io.github.talmeidas.battle.core.common.GetLocalDateTime;
import io.github.talmeidas.battle.core.domains.game.xcutting.GetGameByPlayerIdAndStatusGateway;
import io.github.talmeidas.battle.core.domains.game.model.Game;
import io.github.talmeidas.battle.core.domains.game.model.Status;
import io.github.talmeidas.battle.core.domains.player.model.Player;
import io.github.talmeidas.battle.core.domains.player.xcutting.GetPlayerByEmailGateway;
import io.github.talmeidas.battle.core.domains.player.usecase.RegisterPlayerUseCase;
import io.github.talmeidas.battle.core.domains.player.usecase.RegisterPlayerCommand;
import io.github.talmeidas.battle.core.exception.InvalidActionException;
import lombok.RequiredArgsConstructor;

import jakarta.inject.Named;
import java.time.LocalDateTime;
import java.util.Optional;

/*
 * A Use Case follows these steps:
 * - Takes input
 * - Validates business rules
 * - Manipulates the model state
 * - Returns output
 */


@Named
@RequiredArgsConstructor
public class StartGameUseCaseImpl implements StartGameUseCase {

    private final GetPlayerByEmailGateway getPlayerByEmailGateway;
    private final RegisterPlayerUseCase registerPlayerUseCase;
    private final GetGameByPlayerIdAndStatusGateway getGameByPlayerIdAndStatusGateway;
    private final GetLocalDateTime getLocalDateTime;
    private final RegisterGameGateway registerGameGateway;

    @Override
    public Game execute(final StartGameCommand command) {

        final Player player = getPlayerOrRegister(command.getPlayerEmail(), command.getPlayerName());

        checkGameInProgressByPlayerId(player.id());

        final LocalDateTime createdAt = getLocalDateTime.now();
        final LocalDateTime updatedAt = getLocalDateTime.now();

        final Game game = new Game(null, player, Status.IN_PROGRESS, createdAt, updatedAt);

        return registerGameGateway.execute(game);
    }

    private Player getPlayerOrRegister(final String email, String name) {
        final Optional<Player> optional = getPlayerByEmailGateway.execute(email);
        return optional.orElseGet(() -> registerNewPlayer(email, name));
    }

    private Player registerNewPlayer(final String email, String name) {
        final RegisterPlayerCommand registerPlayerCommand = new RegisterPlayerCommand(email, name);
        return registerPlayerUseCase.execute(registerPlayerCommand);
    }

    private void checkGameInProgressByPlayerId(final Long playerId) {
        getGameByPlayerIdAndStatusGateway.execute(playerId, Status.IN_PROGRESS)
            .ifPresent(game -> {
                final String messageKey = "validation.game.already.in.progress";
                throw new InvalidActionException(messageKey, String.valueOf(game.id()));
            });
    }
}
