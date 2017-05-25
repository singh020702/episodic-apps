package com.example.episodicevents;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EventController {

    final  EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping("")
    public Event create(@RequestBody Event event) {

        return  this.eventRepository.save(event);

    }
    @GetMapping("")
    public List<Event> getEvents( ) {
        return  this.eventRepository.findAll();

    }
}
