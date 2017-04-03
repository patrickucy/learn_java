package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.User;

public class UserDAOTest {

	@Test
	public void testFindByUserName() throws Exception {
		UserDAO dao = new UserDAO();
		User user = dao.findByUsername("kitty");
		System.out.println(user);
		System.out.println(user.getUsername());
	}

}
