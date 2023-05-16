package com.glc.gmdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.glc.gmdb.Model.Reviews;

// @Repository
public interface IReviewRepo extends JpaRepository <Reviews, Long> {
    
}
