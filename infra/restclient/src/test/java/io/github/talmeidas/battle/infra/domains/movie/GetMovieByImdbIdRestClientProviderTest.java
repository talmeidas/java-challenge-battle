package io.github.talmeidas.battle.infra.domains.movie;

import io.github.talmeidas.battle.core.domains.movie.model.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@DisplayName("Get Movie By ImdbId Provider Test")
class GetMovieByImdbIdRestClientProviderTest {

    @Mock
    private final MoviesRestClient moviesRestClient = Mockito.mock(MoviesRestClient.class);

    @InjectMocks
    private final GetMovieByImdbIdRestClientProvider getMovieByImdbIdProvider = new GetMovieByImdbIdRestClientProvider(moviesRestClient);

    @DisplayName("Fail to get movie by imdbId when imdbId does not exist")
    @Test
    void failToGetMovieByImdbIdWhenImdbIdDoesNotExist() {
        // Arrange
        when(moviesRestClient.getMovieByImdbId("tt0468590")).thenReturn(null);

        // Act
        final Optional<Movie> optional = getMovieByImdbIdProvider.execute("tt0468590");

        // Assert
        assertThat(optional).isNotPresent();
    }

    @DisplayName("Get Movie By ImdbId")
    @Test
    void successfulToGetMovieByImdbId() {
        // Arrange
        when(moviesRestClient.getMovieByImdbId("tt0468569"))
                .thenReturn(new MovieResponse(2L, "tt0468569", "The Dark Knight", "2008", "Action, Crime, Drama", 9.0F, 2628154L, 23653386F, "http://poster.url"));

        // Act
        final Optional<Movie> optional = getMovieByImdbIdProvider.execute("tt0468569");

        // Assert
        assertThat(optional).isPresent();

        final Movie movie = optional.get();

        assertThat(movie).isNotNull();

        assertThat(movie.id()).isEqualTo(2L);
        assertThat(movie.imdbId()).isEqualTo("tt0468569");
        assertThat(movie.title()).isEqualTo("The Dark Knight");
        assertThat(movie.year()).isEqualTo("2008");
        assertThat(movie.genre()).isEqualTo("Action, Crime, Drama");
        assertThat(movie.imdbRating()).isEqualTo(9.0F);
        assertThat(movie.imdbVotes()).isEqualTo(2628154L);
        assertThat(movie.score()).isEqualTo(23653386L);
        assertThat(movie.posterUrl()).isEqualTo("http://poster.url");
    }
}
