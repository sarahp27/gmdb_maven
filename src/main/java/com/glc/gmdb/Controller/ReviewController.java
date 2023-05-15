package com.glc.gmdb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.gmdb.Model.Review;
import com.glc.gmdb.Repository.IReviewRepo;

@RestController
@RequestMapping("/review")
public class ReviewController {
    
    @Autowired
    private IReviewRepo reviewRepository;


    @PostMapping("/post")
    public void postMethodName(@RequestBody Review review) {
        reviewRepository.save(review);
 }

    
}
