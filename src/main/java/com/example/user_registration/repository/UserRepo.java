package com.example.user_registration.repository;

import com.example.user_registration.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<UserEntity ,String> {

     Optional<UserEntity> findByUsername(String username);
    List<UserEntity> findByEmail(String email);
}
