package com.cts.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.user.exception.NoResourceException;
import com.cts.user.model.User;
import com.cts.user.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	@Mock
	User user;
	
	@Test
	void testfindidSucessAdmin() throws NoResourceException {
		user = new User("admin", "admin", true);
		Optional<User> user1 = Optional.of(user);
		when(userRepository.findById("admin")).thenReturn(user1);
		assertEquals(userService.findid("admin", "admin"), true);
	}
	
	@Test
	void testfindidSucessClient() throws NoResourceException {
		user = new User("admin", "admin", false);
		Optional<User> user1 = Optional.of(user);
		when(userRepository.findById("admin")).thenReturn(user1);
		assertEquals(userService.findid("admin", "admin"), false);
	}
	
	@Test
	void testfindidFailed() throws NoResourceException {
		user = new User("admin", "admin", true);
		Optional<User> user1 = Optional.of(user);
		when(userRepository.findById("admin")).thenReturn(user1);
		assertThrows(NoResourceException.class, () -> userService.findid("admin", "admin1"));
	}

	@Test
	void testfindidFailed2() throws NoResourceException {
		when(userRepository.findById("admin")).thenThrow(NoSuchElementException.class);
		assertThrows(NoResourceException.class, () -> userService.findid("admin", "admin1"));
	}
}
