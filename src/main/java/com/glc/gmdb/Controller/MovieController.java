package com.glc.gmdb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.gmdb.Model.Movies;
import com.glc.gmdb.Repository.IMovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private IMovieRepository movieRepo;

    // @PostMapping("/post")
    // public void postMethodName(@RequestBody Movies movie) {
    // movieRepo.save(movie);
    // }

    @GetMapping("")
    public String getAllMovi() {
        return "(List<Movies>) movieRepo.findAll();";
    }


    @GetMapping("/all")
    public List<Movies> getAllMovies() {
        return (List<Movies>) movieRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.movieRepo.findById(id).get());
    }

}
