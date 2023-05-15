package com.glc.gmdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.glc.gmdb.Modal.Movie;


@Repository
public interface IMovieRepository extends JpaRepository <Movie, Long> {

}

