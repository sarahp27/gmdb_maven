package com.glc.gmdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glc.gmdb.Model.Movies;



public interface IMovieRepository extends JpaRepository <Movies, Long> {

}

