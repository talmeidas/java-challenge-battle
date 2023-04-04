package io.github.talmeidas.battle.infra.domains.movie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "movies", url = "${app.movies.url}")
public interface MoviesRestClient {

    @GetMapping(value = "/v1/movies/count")
    MoviesCountResponse getAllMoviesCount();

    @GetMapping(value = "/v1/movies/byImdbId/{imdbId}")
    MovieResponse getMovieByImdbId(@PathVariable("imdbId") final String imdbId);

    @GetMapping(value = "/v1/movies/random")
    MovieResponse getRandomMovie();
}
