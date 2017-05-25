package com.example.shows;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="episodes")
@Getter
@Setter
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long show_id;

    @JsonProperty("seasonNumber")
    int season_number;

    @JsonProperty("episodeNumber")
    int episode_number;

    @Transient
    String title;

}