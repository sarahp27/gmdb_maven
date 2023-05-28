package com.glc.gmdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.glc.gmdb.Model.User;

// @Repository
public interface IUserRepo extends JpaRepository<User, Long>{
 
}
