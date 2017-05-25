package com.example.users;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by singh on 5/18/2017.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
