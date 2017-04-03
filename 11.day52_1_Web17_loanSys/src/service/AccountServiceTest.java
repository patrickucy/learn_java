package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountServiceTest {

	@Test
	public void testApply() {
		AccountService service = new AccountService();
		try {
			String number = service.apply("62258811", 5000);
			System.out.println("application is sussessful: "+number);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(e instanceof AccountNotExistException){
				System.out.println("account doesn't exist");
			}else if(e instanceof AccountLimitException){
				System.out.println("balance is not enough");
			}else{
				System.out.println("system is busy, please try again later");
			}
		}
		
	}

}
