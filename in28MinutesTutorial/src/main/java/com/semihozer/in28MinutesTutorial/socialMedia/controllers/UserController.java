package com.semihozer.in28MinutesTutorial.socialMedia.controllers;

import com.semihozer.in28MinutesTutorial.socialMedia.dataAccsess.UserDaoService;
import com.semihozer.in28MinutesTutorial.socialMedia.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {


    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDaoService.findALl();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id){
        return userDaoService.findById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
