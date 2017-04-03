package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Account;

public class AccountDAOTest {

	@Test
	public void testFindByAccountNo() throws Exception {
		AccountDAO dao = new AccountDAO();
		Account a = dao.findByAccountNo("62258810");
		System.out.println(a);
	}

}
