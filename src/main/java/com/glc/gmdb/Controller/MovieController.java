package com.glc.gmdb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.gmdb.Model.Movies;
import com.glc.gmdb.Repository.IMovieRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/movies")
public class MovieController  {
@Autowired
   private  IMovieRepository movierepo;

  
@PostMapping("/post")
public void postMethodName(@RequestBody  Movies movi) {
       movierepo.save(movi);
}
@GetMapping("/all")
    public List<Movies>getAllMovies(){
        return (List<Movies>) movierepo.findAll();
    }
     
    
}
