package com.glc.gmdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glc.gmdb.Model.Reviews;

public interface IReviewRepo extends JpaRepository <Reviews, Long> {
    
}
