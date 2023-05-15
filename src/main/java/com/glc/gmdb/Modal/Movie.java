package com.glc.gmdb.Modal;


import org.springframework.web.bind.annotation.SessionAttributes;

//import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblmovies")
public class Movie {

    @Id  
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @OneToMany 
    private Long movie_id;

   
    private String movie_title;
    private int movie_year_released; 
    private String movei_genre;
    private int movie_runtime;
}