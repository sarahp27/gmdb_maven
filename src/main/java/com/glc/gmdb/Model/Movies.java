package com.glc.gmdb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
// @Table(name = "movies")
public class Movies {

    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private Long movie_id; //will use as a foreign key 
   
    
    private String movie_title;
    private int movie_year_released; 
    private String movie_genre;
    private int movie_runtime;
}