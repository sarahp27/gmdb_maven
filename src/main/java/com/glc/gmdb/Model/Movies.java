package com.glc.gmdb.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// @AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movies {

    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private Long movie_id; //will use as a foreign key 
   
    @Column(nullable = false)
    private String movieTitle;

    @Column(nullable = false)
    private int movieReleased; 

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private int runtime;

    // @OneToMany(mappedBy = "movies")
    // private List<Reviews> reviews;

    public Movies(String movieTitle, int movieReleased, String genre, int runtime){
        this.movieTitle=movieTitle;
        this.movieReleased=movieReleased;
        this.genre=genre;
        this.runtime=runtime;
    }

    public Object getReviews() {
        return null;
    }

    public void setReviews(Object reviews) {
    }   
}