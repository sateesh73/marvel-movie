package io.marvel.movie.marvelmovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.marvel.movie.marvelmovie.model.Movie;
import io.marvel.movie.marvelmovie.service.MovieServiceImpl;

@RestController
public class MovieController {

    @Autowired
    MovieServiceImpl service;

    @GetMapping("/marvel-movie")
    public List<Movie> getAllMovie() {
        return service.getAllMovie();
    }

    @GetMapping("/marvel-movie/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return service.getOneMovie(id);
    }

}
