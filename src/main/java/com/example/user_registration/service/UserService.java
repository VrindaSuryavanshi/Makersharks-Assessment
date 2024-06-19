package com.example.user_registration.service;

import com.example.user_registration.entity.UserEntity;
import com.example.user_registration.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<UserEntity> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<UserEntity> getUser(String username){
        return userRepo.findByUsername(username);
    }

    public UserEntity saveToDb(UserEntity user) {
        return  userRepo.save(user);
    }


//     public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException {
//                    Optional<UserEntity> user = userRepo.findByUsername(username.toLowerCase());
//                    if(!user.isPresent()){
//                        throw new UsernameNotFoundException(username);
//                    }else {
//                        return User.builder()
//                                .username(user.get().getUsername())
//                                .password(user.get().getPassword())
//                                .build();
//                    }
//    }


    }
