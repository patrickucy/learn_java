package service;

import java.util.Random;

import dao.AccountDAO;
import entity.Account;

public class AccountService {

	public String apply(String accountNo, double amount) throws Exception{
		// step1, check the availability of an account
		AccountDAO dao = new AccountDAO();
		Account a = dao.findByAccountNo(accountNo); // let our controller to handle this exception
		if (a == null){
			// account doesn't exist, define yourself an exception
			throw new AccountNotExistException();
		}
		
		// step2, balance availability
		if(amount > a.getBalance() *10){
			throw new AccountLimitException();
		}
		
		// step3, generate a serial number
		Random r = new Random();
		String number = r.nextInt(88888888)+"";
		// in real application, you need to store this serial number
		return number;
	}
}
