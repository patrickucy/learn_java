package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.User;

public class UserDAOTest {

	@Test
	public void testAddUser() throws Exception {
		UserDAO dao = new UserDAO();
		User user = new User();
		user.setUsername("King");
		user.setGender("m");
		user.setPwd("test");
		user.setName("tom");
		dao.addUser(user);
	}

}
