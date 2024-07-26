package com.joaosantos.projectmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaosantos.projectmongo.domain.User;
import com.joaosantos.projectmongo.dto.UserDTO;
import com.joaosantos.projectmongo.repositories.UserRepository;
import com.joaosantos.projectmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}

	public Optional<User> findById(String id) {
		 Optional<User> user = repository.findById(id);
		 if (user.isEmpty()) {
			 throw new ObjectNotFoundException("Object not Found");
		 }
		 return user;
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public User fromDTO(UserDTO user) {
		return new User(user.getId(), user.getName(), user.getEmail());
	}

}
