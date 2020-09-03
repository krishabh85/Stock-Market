package com.socg.casestudy.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.socg.casestudy.register.model.User;
import com.socg.casestudy.register.service.RegisterService;
@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId!=null && !"".equals(tempEmailId)) {
			User userobj= service.fetchUserByEmailId(tempEmailId);
			if(userobj !=null) {
				throw new Exception("user with " + tempEmailId + " is already present" );
			}
			
		}	
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User userobj=null;
		if(tempEmailId!= null && !"".equals(tempEmailId) && tempPassword!=null && !"".equals(tempPassword)) {
			userobj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
			
		}
		if(userobj==null) {
			throw new Exception("Bad Credentials");
		}
		return userobj;
	}
}
