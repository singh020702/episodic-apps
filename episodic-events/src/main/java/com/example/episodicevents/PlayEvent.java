package com.example.episodicevents;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by singh on 5/22/2017.
 */

@Getter
@Setter
@NoArgsConstructor
public class PlayEvent extends Event {


    public PlayEvent(String id, Long userId, Long showId, Long episodeId, Date createdAt) {
        super(id, userId, showId, episodeId, createdAt);
    }
    public String getType() {
        return "PlayEvent";
    }

}
