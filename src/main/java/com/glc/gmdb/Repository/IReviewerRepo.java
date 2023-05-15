package com.glc.gmdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glc.gmdb.Model.Reviewer;

@Repository
public interface IReviewerRepo extends JpaRepository<Reviewer, Long>{
 
}
