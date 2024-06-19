package com.example.user_registration.controller;

import com.example.user_registration.entity.UserEntity;
import com.example.user_registration.repository.UserRepo;
import com.example.user_registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserEntity>>getAll(){
        return new ResponseEntity<List<UserEntity>>(userService.getAllUsers() , HttpStatus.OK);
    }

    @PostMapping("/api/user/register")
    public ResponseEntity registerUser(@RequestBody UserEntity userEntity){
                try{
                  if(userRepo.findByUsername(userEntity.getUsername()).isPresent())
                      return ResponseEntity.status(HttpStatus.CONFLICT).body(userEntity.getUsername()+ " Already Exist...!");

                  userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
                   UserEntity save = userService.saveToDb(userEntity);
                    return new ResponseEntity(userEntity.getUsername() + " user registered successfully to database. ", HttpStatus.OK );
                }catch (Exception e){
                    return ResponseEntity.internalServerError().body(e.getMessage());
                }

    }

    @GetMapping("/api/user/fetch/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){

        Optional<UserEntity> userEntity =userService.getUser(username);

        if(userEntity.isPresent()){
            return
            new ResponseEntity<Optional<UserEntity>>(userEntity , HttpStatus.OK);

        }else {
            return new ResponseEntity<>("User Details is not available for this search "+username , HttpStatus.NOT_FOUND);
        }

    }


}
