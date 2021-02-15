package com.cts.user.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.user.exception.NoResourceException;
import com.cts.user.model.User;
import com.cts.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public boolean findid(String userName, String password) throws NoResourceException {
		try {
			User user = userRepository.findById(userName).get();
			if (user.getPassword().equals(password)) {
				return user.isAdmin();
			} else {
				throw new NoResourceException("Wrong Password!!");
			}
		} catch (NoSuchElementException e) {
			throw new NoResourceException("ID does not exist");
		}
	}
}
