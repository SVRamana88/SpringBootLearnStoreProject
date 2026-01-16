package com.example.Learn.repositories;

import com.example.Learn.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {

}
