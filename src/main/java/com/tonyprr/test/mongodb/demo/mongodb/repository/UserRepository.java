package com.tonyprr.test.mongodb.demo.mongodb.repository;

import com.tonyprr.test.mongodb.demo.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findFirstByName(String name);
}
