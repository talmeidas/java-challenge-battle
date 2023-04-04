package io.github.talmeidas.battle.infra.domains.movie;

import io.github.talmeidas.battle.core.domains.movie.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface MovieDatabaseMapper {

    Movie of(final MovieEntity movieEntity);

    @Mapping(target = "score", ignore = true)
    MovieEntity of(final Movie movie);
}
