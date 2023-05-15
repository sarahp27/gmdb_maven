package com.glc.gmdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glc.gmdb.Model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface IMovieRepository extends JpaRepository <Movie, Long> {

}

