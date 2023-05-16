package com.glc.gmdb.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// @AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Reviews {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long  id;

    @ManyToOne
    @JoinColumn(name ="movie_id")
    private Movies movie_id;

    // @ManyToOne
    // @JoinColumn(name="reviewer_id")
    // private Reviewers reviewer_id; 

    private String review_text;
    private Date date_time;

    public Reviews(String review_text, Date date_time){
        this.review_text=review_text;
        this.date_time=date_time;
    }

  
}
