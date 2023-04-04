package io.github.talmeidas.battle.infra.domains.movie;

import io.github.talmeidas.battle.core.domains.movie.model.Movie;
import org.mapstruct.Mapper;


@Mapper
public interface MovieRestClientMapper {

    Movie of(final MovieResponse movieResponse);

    MovieResponse of(final Movie movie);
}
