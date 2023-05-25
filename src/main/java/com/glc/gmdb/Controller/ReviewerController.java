package com.glc.gmdb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.gmdb.Model.Reviewers;
import com.glc.gmdb.Model.Reviews;
import com.glc.gmdb.Repository.IReviewerRepo;


@RestController
@RequestMapping
public class ReviewerController {
    
    @Autowired
    private IReviewerRepo reviewerRepository;

    @PostMapping("/postReview")
    public void postReview(@RequestBody Reviewers reviews){
    reviewerRepository.save(reviews);
    }
}
