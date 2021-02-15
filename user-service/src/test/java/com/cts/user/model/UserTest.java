package com.cts.user.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	User user = new User();
	
	@Test
	void testSetUserid() {
		user.setUserid("admin");
		assertEquals("admin",user.getUserid());
	}

	@Test
	void testSetPassword() {
		user.setPassword("admin");
		assertEquals("admin",user.getPassword());
		}

	@Test
	void testSetAdminbit() {
		user.setAdmin(true);
		assertEquals(true,user.isAdmin());
	}
	
	@Test
	void testToString() {
		String string = user.toString();
		assertEquals(string,user.toString());
	}
}
