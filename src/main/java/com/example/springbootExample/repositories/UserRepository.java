package com.example.springbootExample.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springbootExample.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @Query
    List<User> findAll();
 
    @Deprecated
    User findFirstBySso(Long sso);

}
