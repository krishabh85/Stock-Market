package com.socg.casestudy.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socg.casestudy.register.model.User;
import com.socg.casestudy.register.repository.RegisterRepository;

@Service
public class RegisterService {
	@Autowired
	private RegisterRepository repo;
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	public User fetchUserByEmailIdAndPassword(String email, String pass) {
		return repo.findByEmailIdAndPassword(email, pass);
	}
}
	

