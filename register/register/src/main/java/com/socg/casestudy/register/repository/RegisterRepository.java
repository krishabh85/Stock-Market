package com.socg.casestudy.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socg.casestudy.register.model.User;
public interface RegisterRepository extends JpaRepository<User, Integer> {
	
	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId, String password);

}
