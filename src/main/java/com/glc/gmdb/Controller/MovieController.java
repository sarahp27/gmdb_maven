package com.glc.gmdb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.gmdb.Modal.Movie;
import com.glc.gmdb.Repository.IMovieRepository;

import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/movies")
public class MovieController  {
@Autowired
   private  IMovieRepository movierepo;

  
@PostMapping("/post")
public void postMethodName(@RequestBody  Movie movi) {
       movierepo.save(movi);
}
@GetMapping("/all")
    public List<Movie>getAllMovies(){
        return movierepo.findAll();
    }
    
}
