package com.example.users;

import com.example.shows.Show;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserRepository repository;


    public UsersController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("")
    public User create(@RequestBody User user) {
        return  this.repository.save(user);
    }

    @GetMapping("")
    public Iterable<User> all() {
        return this.repository.findAll();
    }

}