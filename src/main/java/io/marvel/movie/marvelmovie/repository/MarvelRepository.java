package io.marvel.movie.marvelmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.marvel.movie.marvelmovie.model.Movie;

@Repository
public interface MarvelRepository extends JpaRepository<Movie, Long> {

}
