package com.cts.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.user.exception.NoResourceException;
import com.cts.user.service.UserService;

@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/hi")
	public String getUs() {
		return "hello";
	}

	@GetMapping("/authenticate/{username}/{password}")
	public boolean checkLogin(@PathVariable String username,@PathVariable String password) throws NoResourceException{
		return userService.findid(username,password);
	}
}
