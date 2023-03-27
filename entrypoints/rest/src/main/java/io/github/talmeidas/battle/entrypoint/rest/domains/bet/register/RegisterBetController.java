package io.github.talmeidas.battle.entrypoint.rest.domains.bet.register;

import io.github.talmeidas.battle.entrypoint.rest.domains.bet.BetResponse;
import io.github.talmeidas.battle.entrypoint.rest.common.JsonConverter;
import io.github.talmeidas.battle.entrypoint.rest.common.metric.LogExecutionTime;
import io.github.talmeidas.battle.core.domains.bet.model.Bet;
import io.github.talmeidas.battle.core.domains.bet.usecase.RegisterBetCommand;
import io.github.talmeidas.battle.core.domains.bet.usecase.RegisterBetUseCase;
import io.github.talmeidas.battle.entrypoint.rest.common.WebRequest;
import io.github.talmeidas.battle.entrypoint.rest.domains.bet.BetPresenter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/*
 * A EntryPoint follows these steps:
 *
 * - Maps HTTP requests to Java objects
 * - Performs authorization checks
 * - Maps input to the input model of the use case
 * - Calls the use case
 * - Maps the output of the use case back to HTTP Returns an HTTP response
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/bets")
public class RegisterBetController implements RegisterBetApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterBetController.class);

    private final RegisterBetUseCase registerBetUseCase;
    private final WebRequest webRequest;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BetResponse execute(final Authentication authentication, @RequestBody @DefaultValue final RegisterBetRequest request) {
        log.info("Starting Controller -> RegisterBetController for Player {}", webRequest.getEmail());
        final String json = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterBetController with Bet option id {}", json);
        final RegisterBetCommand command = new RegisterBetCommand(webRequest.getEmail(), webRequest.getFullName(), request.getOptionId());
        final Bet bet = registerBetUseCase.execute(command);
        return BetPresenter.of(bet);
    }
}
