package com.joaosantos.projectmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaosantos.projectmongo.domain.Post;
import com.joaosantos.projectmongo.resources.util.URL;
import com.joaosantos.projectmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findPostById(@PathVariable String id) {
		Post post = service.findPostById(id);
		
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findPostByTitle(@RequestParam(value = "text", defaultValue = "") String title) {
		title = URL.decodeParam(title);
		List<Post> posts = service.findByTitle(title);
		
		return ResponseEntity.ok().body(posts);
	}
	
	
}
