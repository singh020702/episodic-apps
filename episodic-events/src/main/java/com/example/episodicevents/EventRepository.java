package com.example.episodicevents;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by singh on 5/22/2017.
 */
public interface EventRepository extends MongoRepository<Event, Long> {
}
