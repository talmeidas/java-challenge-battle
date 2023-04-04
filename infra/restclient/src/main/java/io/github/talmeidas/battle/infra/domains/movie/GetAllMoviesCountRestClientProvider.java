package io.github.talmeidas.battle.infra.domains.movie;

import io.github.talmeidas.battle.core.domains.movie.xcutting.GetAllMoviesCountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetAllMoviesCountRestClientProvider implements GetAllMoviesCountGateway {

    private final MoviesRestClient moviesRestClient;

    @Override
    public Long execute() {
        final MoviesCountResponse response = moviesRestClient.getAllMoviesCount();
        return response.count();
    }
}
