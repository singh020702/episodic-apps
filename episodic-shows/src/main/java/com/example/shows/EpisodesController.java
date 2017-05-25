package com.example.shows;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class EpisodesController {

    private final EpisodeRepository episodeRepository;


    public EpisodesController(EpisodeRepository repository) {
        this.episodeRepository = repository;
    }

    @PostMapping("/{id}/episodes")
    public Episode createShows(@RequestBody Episode episode,@PathVariable String id) {

        episode.setShow_id(new Integer(id).longValue());
        Episode newEpisode= this.episodeRepository.save(episode);
        newEpisode.setTitle("S"+episode.getEpisode_number() + "  "+ "E"+ episode.getSeason_number() );
        return newEpisode;
    }

    @GetMapping("/{id}/episodes")
    public Iterable<Episode> findById(@PathVariable String id) {

        Iterable<Episode> episodes=this.episodeRepository.findAll();

        List<Episode> newEpisodes=new ArrayList<>();

        for (Episode episode : episodes)
        {
            if(id.equalsIgnoreCase(episode.getShow_id().toString())) {
                episode.setTitle("S"+episode.getEpisode_number() + "  "+ "E"+ episode.getSeason_number() );
                newEpisodes.add(episode);
            }
        }
        return newEpisodes;
    }


}