package com.joaosantos.projectmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaosantos.projectmongo.domain.Post;

@Repository
public interface PostRepository extends  MongoRepository<Post, String>{

}
