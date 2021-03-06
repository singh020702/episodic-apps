package com.example.viewings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="viewings")
@Getter
@Setter
public class Viewing  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long show_id;


    Long user_id;

    @JsonProperty("episodeId")
    Long episode_id;

    @JsonProperty("updatedAt")
    Date updated_at;

    int timecode;

}