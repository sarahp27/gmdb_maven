package com.glc.gmdb.Controller;

import java.sql.Date;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.gmdb.Model.Reviews;
import com.glc.gmdb.Model.User;
import com.glc.gmdb.Repository.IMovieRepository;
import com.glc.gmdb.Repository.IReviewRepo;
import com.glc.gmdb.Repository.IUserRepo;


@RestController
@RequestMapping("/Reviewers")
public class ReviewerController {
    
    @Autowired
    private IUserRepo reviewerRepository;

    @Autowired
    private IMovieRepository movieRepo;

    @Autowired 
    private IReviewRepo reviewsRepo;

    
    // @GetMapping("/{id}")
    // public ResponseEntity<User> getReviewer(@PathVariable Long id){
    //    reviewer = reviewerRepository.findById(id);
        

    /**
     * @param id
     * @return
     */
    public ResponseEntity<User> getReviewer(@PathVariable Long id) {
        Optional<User> reviewer = reviewerRepository.findById(id);
        if (reviewer.isPresent() && reviewer.get().getRole().equalsIgnoreCase("Reviewer")) {
            return ResponseEntity.ok().body(reviewer.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/postReview")
    public void postReview(@RequestBody User reviews){
    reviewerRepository.save(reviews);
    }

    // @PostMapping("/{reviewerId}/Movie/{movieId}/Review")
    // public ResponseEntity<Reviews> postReview(@PathVariable Long reviewerId){
    //     reviews.setMovies(movieRepo.findById(movieId).get());

    @PostMapping("/{reviewerId}/Movie/{movieId}/Review")
    public ResponseEntity<Reviews> postReview(@PathVariable Long reviewerId, @PathVariable Long movieId, @RequestBody Reviews reviews){
        reviews.setMovies(movieRepo.findById(movieId).get());
        reviews.setReviewer(reviewerRepository.findById(reviewerId).get());
        reviews.setDate_time(new Date(0).toString());
        return ResponseEntity.ok().body(reviewsRepo.save(reviews));
    }
}
