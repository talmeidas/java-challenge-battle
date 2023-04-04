package io.github.talmeidas.battle.infra.domains.movie;

import io.github.talmeidas.battle.core.domains.movie.model.Movie;
import io.github.talmeidas.battle.core.domains.movie.xcutting.GetMovieByImdbIdGateway;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetMovieByImdbIdDatabaseProvider implements GetMovieByImdbIdGateway {

    private final MovieDatabaseMapper movieDatabaseMapper = Mappers.getMapper(MovieDatabaseMapper.class);
    
    private final MovieRepository movieRepository;

    @Override
    public Optional<Movie> execute(String imdbId) {
        final Optional<MovieEntity> optional = movieRepository.findByImdbIdIgnoreCase(imdbId);
        return optional.map(movieDatabaseMapper::of);
    }
}
