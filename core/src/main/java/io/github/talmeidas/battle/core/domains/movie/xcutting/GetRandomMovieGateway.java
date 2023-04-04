package io.github.talmeidas.battle.core.domains.movie.xcutting;

import io.github.talmeidas.battle.core.domains.movie.model.Movie;

import java.util.Optional;

@FunctionalInterface
public interface GetRandomMovieGateway {

    Optional<Movie> execute(int index);
}