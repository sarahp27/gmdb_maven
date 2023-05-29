package com.glc.gmdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glc.gmdb.Model.User;

public interface IUserRepo extends JpaRepository<User, Long>{
 
}
