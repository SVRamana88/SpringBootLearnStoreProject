package com.example.Learn.repositories;

import com.example.Learn.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    //Eager fetch specific query not the entity
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findUserByEmail(String email);


    @EntityGraph(attributePaths = "addresses")
    @Query("select u from User u")
    Iterable<User> findUserWithAddresses();
}
