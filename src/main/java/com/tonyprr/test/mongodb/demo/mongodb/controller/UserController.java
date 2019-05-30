package com.tonyprr.test.mongodb.demo.mongodb.controller;

import com.tonyprr.test.mongodb.demo.mongodb.model.User;
import com.tonyprr.test.mongodb.demo.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllPets() {

        return ResponseEntity.ok(userRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") String id) {

        return ResponseEntity.ok(userRepository.findById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

        return ResponseEntity.ok(userRepository.save(user));
    }
}
