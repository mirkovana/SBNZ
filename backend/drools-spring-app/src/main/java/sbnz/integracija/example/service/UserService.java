package sbnz.integracija.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import sbnz.integracija.example.facts.User;
import sbnz.integracija.example.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	
	@JsonIgnore
	public List<User> listAll() {
		return repo.findAll();
	}

	public User save(User user) {
		return repo.save(user);

	}

	public User get(Long id) {
		return repo.findById(id).get();
	}
	
	public User findByUsername(String username) {
		return repo.findByUsername(username);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
