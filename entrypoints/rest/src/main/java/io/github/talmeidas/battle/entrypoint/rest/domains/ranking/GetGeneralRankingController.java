package io.github.talmeidas.battle.entrypoint.rest.domains.ranking;

import io.github.talmeidas.battle.core.domains.ranking.models.Ranking;
import io.github.talmeidas.battle.core.domains.ranking.usecase.GetGeneralRankingUseCase;
import io.github.talmeidas.battle.entrypoint.rest.common.WebRequest;
import io.github.talmeidas.battle.entrypoint.rest.common.metric.LogExecutionTime;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
@RequestMapping("v1/rankings")
public class GetGeneralRankingController implements GetGeneralRankingApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetGeneralRankingController.class);

    private final GetGeneralRankingUseCase getGeneralRankingUseCase;
    private final WebRequest webRequest;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public RankingResponse execute() {
        log.info("Starting Controller -> GetGeneralRankingController");
        final Ranking ranking = getGeneralRankingUseCase.execute();
        return RankingPresenter.of(ranking);
    }
}
