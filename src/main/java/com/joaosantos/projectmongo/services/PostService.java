package com.joaosantos.projectmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaosantos.projectmongo.domain.Post;
import com.joaosantos.projectmongo.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository repository;
	
	public Post findPostById(String id) {
		return repository.findById(id).get();
	}
	
	public List<Post> findByTitle(String title) {
		return repository.findByTitleContainingIgnoreCase(title);
	}

}
