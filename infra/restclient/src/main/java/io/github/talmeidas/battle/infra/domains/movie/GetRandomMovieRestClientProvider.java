package io.github.talmeidas.battle.infra.domains.movie;

import io.github.talmeidas.battle.core.domains.movie.model.Movie;
import io.github.talmeidas.battle.core.domains.movie.xcutting.GetRandomMovieGateway;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetRandomMovieRestClientProvider implements GetRandomMovieGateway {

    private static final MovieRestClientMapper MOVIE_RESPONSE_MAPPER = Mappers.getMapper(MovieRestClientMapper.class);
    private final MoviesRestClient moviesRestClient;

    @Override
    public Optional<Movie> execute(int index) {
        final MovieResponse response = moviesRestClient.getRandomMovie();
        return Optional.of(MOVIE_RESPONSE_MAPPER.of(response));
    }
}
