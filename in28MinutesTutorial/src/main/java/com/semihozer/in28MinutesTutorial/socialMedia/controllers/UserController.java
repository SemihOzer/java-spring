package com.semihozer.in28MinutesTutorial.socialMedia.controllers;

import com.semihozer.in28MinutesTutorial.socialMedia.dataAccsess.UserDaoService;
import com.semihozer.in28MinutesTutorial.socialMedia.entities.User;
import com.semihozer.in28MinutesTutorial.socialMedia.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
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

        User user = userDaoService.findById(id);

        if(user == null)
            throw new UserNotFoundException("id:" + id);

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){

        userDaoService.deleteUser(id);
    }


}
