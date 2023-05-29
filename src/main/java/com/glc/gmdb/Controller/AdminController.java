package com.glc.gmdb.Controller;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.gmdb.Model.Movies;
import com.glc.gmdb.Model.User;
import com.glc.gmdb.Repository.IMovieRepository;
import com.glc.gmdb.Repository.IUserRepo;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    
    @Autowired
    private IUserRepo adminRepository;


    @Autowired
    private IMovieRepository movieRepo;


//     @PostMapping("/post")
//     public void postMethodName(@RequestBody User ) {
//         userRepo.save(review);
//  }

 @PostMapping("/Register")
    public ResponseEntity<User> registerAdmin(@RequestBody User reviewer){
        reviewer.setRole("Admin");
        reviewer.setReviews(new ArrayList<>());
        reviewer.setDateJoin(new Date(0));
        return ResponseEntity.ok().body(this.adminRepository.save(reviewer));
    }




    // @PostMapping("/Movie/add")
    // public ResponseEntity<Movies> addMovie(@RequestBody Movies movies){   
    //     movies.setReviews(new ArrayList<>());
    //     return ResponseEntity.ok().body(movieRepo.save(movies));
    // }




     @PutMapping("/Movie/{id}/update")
    public ResponseEntity<Movies> updateMovie(@PathVariable Long id, @RequestBody Movies movies){ 
        movies.setReviews(this.movieRepo.findById(id).get().getReviews());
        movies.setId(id);  
        
        return ResponseEntity.ok().body(movieRepo.save(movies));
    }

    @DeleteMapping("/Movie/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        try {
            movieRepo.deleteById(id);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
