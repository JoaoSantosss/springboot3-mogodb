package com.joaosantos.projectmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaosantos.projectmongo.domain.User;

@Repository
public interface UserRepository extends  MongoRepository<User, String>{

}
