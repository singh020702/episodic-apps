package com.example.viewings;

import com.example.shows.Episode;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class ViewingController {

    private final ViewingsRepository viewingsRepository;


    public ViewingController(ViewingsRepository repository) {
        this.viewingsRepository = repository;
    }

    @PatchMapping("/{id}/viewings")
    public Viewing createShows(@RequestBody Viewing viewing, @PathVariable String id) {

        Iterable<Viewing> viewings=this.viewingsRepository.findAll();

        Viewing userViewing=null;

        for (Viewing viewing1 : viewings)
        {
            if(viewing1.getUser_id().toString().equalsIgnoreCase(id)) {
                userViewing= viewing1;
            }
        }
        if(userViewing!=null) {
            userViewing.setTimecode(viewing.getTimecode());
            userViewing.setEpisode_id(viewing.getEpisode_id());
            userViewing.setUpdated_at(viewing.getUpdated_at());
            this.viewingsRepository.save(userViewing);
        }else{
            this.viewingsRepository.save(viewing);
        }

        return viewing;
    }

    @GetMapping("/{id}/recently-watched")
    public Iterable<Viewing> findById(@PathVariable String id) {

        Iterable<Viewing> viewings=this.viewingsRepository.findAll();

        return viewings;
    }


}