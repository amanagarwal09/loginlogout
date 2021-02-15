package com.cts.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.user.exception.NoResourceException;
import com.cts.user.model.User;
import com.cts.user.service.UserService;

@SpringBootTest
public class UserControllerTest {

	@InjectMocks
	UserController userController;
	
	@Mock
	User user;
	
	@Mock
	UserService userservice;

	@Test
	void testCheckLoginSucess() throws NoResourceException {
		when(userservice.findid("admin", "admin")).thenReturn(true);
		assertEquals(userController.checkLogin("admin", "admin"),true);
	}
	
	@Test
	void testCheckLoginFailed() throws NoResourceException {
		when(userservice.findid("admin11", "admin11")).thenReturn(false);
		assertEquals(userController.checkLogin("admin", "admin"),false);

	}

}
