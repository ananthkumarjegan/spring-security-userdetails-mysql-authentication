package com.learning.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring.security.model.User;
import com.learning.spring.security.service.UserServiceImpl;

@RestController
public class SpringController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

	@GetMapping("/addUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity(userServiceImpl.createUser(user),
				HttpStatus.CREATED);

	}

}
