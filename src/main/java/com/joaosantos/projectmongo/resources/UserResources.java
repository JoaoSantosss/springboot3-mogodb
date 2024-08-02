package com.joaosantos.projectmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaosantos.projectmongo.domain.User;
import com.joaosantos.projectmongo.dto.UserDTO;
import com.joaosantos.projectmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> users = service.findAll();
		List<UserDTO> usersDTO = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(usersDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		Optional<User> user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user.get()));
		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
		User user = service.fromDTO(userDTO);
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update (@PathVariable String id, @RequestBody UserDTO userDTO) {
		User user = service.fromDTO(userDTO);
		user.setId(id);
		service.update(user);
		return ResponseEntity.noContent().build();
	}

}
