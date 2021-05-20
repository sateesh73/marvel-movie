package io.marvel.movie.marvelmovie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @GetMapping("/marvel-movie")
    public String getAllMovie() {
        return "this is test";
    }

}
