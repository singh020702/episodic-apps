package com.example.shows;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shows")
public class ShowsController {

    private final ShowRepository showRepository;


    public ShowsController(ShowRepository repository) {
        this.showRepository = repository;
    }

    @PostMapping("")
    public Show create(@RequestBody Show show) {
        return  this.showRepository.save(show);
    }

    @GetMapping("")
    public Iterable<Show> all() {
        return this.showRepository.findAll();
    }


}