package com.boss.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boss.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
//Extra methods to db relatedOperation
//Custome Query Method
//Custome Finder Method
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
}
