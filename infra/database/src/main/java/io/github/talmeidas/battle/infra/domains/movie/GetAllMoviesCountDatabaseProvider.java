package io.github.talmeidas.battle.infra.domains.movie;

import io.github.talmeidas.battle.core.domains.movie.xcutting.GetAllMoviesCountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetAllMoviesCountDatabaseProvider implements GetAllMoviesCountGateway {

    private final MovieRepository movieRepository;

    @Override
    public Long execute() {
        return movieRepository.count();
    }
}