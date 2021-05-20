package io.marvel.movie.marvelmovie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.marvel.movie.marvelmovie.dto.ServiceDTO;
import io.marvel.movie.marvelmovie.model.Movie;
import io.marvel.movie.marvelmovie.repository.MarvelRepository;

@Service
public class MovieServiceImpl implements ServiceDTO {

    @Autowired
    MarvelRepository repository;

    @Override
    public List<Movie> getAllMovie() {
        return repository.findAll();
    }

    @Override
    public Movie getOneMovie(Long id) {
        Optional<Movie> movie = repository.findById(id);
        return movie.get();
    }

}
