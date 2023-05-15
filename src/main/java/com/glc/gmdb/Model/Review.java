package com.glc.gmdb.Model;

import java.sql.Date;

import com.glc.gmdb.Repository.IReviewerRepo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer  id;

    @ManyToOne
    @JoinColumn(name ="movie_id")
    private Movie movie_id;

    @ManyToOne
    @JoinColumn (name="reviewer_id")
    private Reviewer reviewer_id; 
    private String review_text;
    private Date date_time;


  
}
