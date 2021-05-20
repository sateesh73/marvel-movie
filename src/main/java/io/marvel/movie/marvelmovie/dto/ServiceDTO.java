package io.marvel.movie.marvelmovie.dto;

import java.util.List;

import io.marvel.movie.marvelmovie.model.Movie;

public interface ServiceDTO {

    List<Movie> getAllMovie();

    Movie getOneMovie(Long id);

}
