package com.example.episodicevents;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by singh on 5/22/2017.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PlayEvent.class, name = "play"),

})
public class Event {

    @Id
    String id;

    Long userId;
    Long showId;
    Long episodeId;
    Date createdAt;

    public String getType() {
        return "Event";
    }

}
