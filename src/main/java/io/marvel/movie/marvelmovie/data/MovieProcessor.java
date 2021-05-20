package io.marvel.movie.marvelmovie.data;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;

import io.marvel.movie.marvelmovie.model.Movie;

public class MovieProcessor implements ItemProcessor<MovieInput, Movie> {

    @Override
    public Movie process(final MovieInput movieInput) throws Exception {

        Movie movie = new Movie();
        movie.setId(Long.parseLong(movieInput.getId()));
        movie.setTitle(movieInput.getTitle());
        movie.setGenres(movieInput.getGenres());
        movie.setReleaseDate(LocalDate.parse(movieInput.getRelease_date()));
        movie.setDirector(movieInput.getDirector());
        movie.setScreenWriter(movieInput.getScreen_writer());
        movie.setProducer(movieInput.getProducer());
        movie.setCast(movieInput.getCast());
        movie.setLanguage(movieInput.getLanguage());
        movie.setFilmingLocations(movieInput.getFilming_locations());
        movie.setStatus(movieInput.getStatus());
        movie.setMovieRating(movieInput.getMovie_rating());
        movie.setReviewRating(movieInput.getReview_rating());
        movie.setMovieRunTime(movieInput.getmovie_run_time());
        movie.setBudget(movieInput.getBudget());
        movie.setBoxOffice(movieInput.getBox_office());

        return movie;
    }

}
