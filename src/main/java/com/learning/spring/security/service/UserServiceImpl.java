package com.learning.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.spring.security.model.User;
import com.learning.spring.security.model.UserData;
import com.learning.spring.security.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService,UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found for name: " + username));
		return new UserData(user);
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	

}
