package com.glc.gmdb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.gmdb.Repository.IReviewerRepo;


@RestController
@RequestMapping
public class ReviewerController {
    
    @Autowired
    private IReviewerRepo reviewerRepository;

}
