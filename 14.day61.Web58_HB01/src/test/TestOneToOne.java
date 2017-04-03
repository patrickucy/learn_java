package test;

import java.util.Date;

import com.patrick.entity.Account;
import com.patrick.entity.Service;

public class TestOneToOne {

	public static void test1(){
		
		Account a = new Account();
		a.setLoginName("swk");
		a.setLoginName("123");
		a.setStatus("0");
		a.setCreateDate(new Date(System.currentTimeMillis()));
		a.setRealName("孙悟空");
		a.setIdcardNo("789456199305051234");
		a.setGender("0");
		a.setTelephone("110");
		
		Service s1 = new Service();
		s1.setAccount(a);
		s1.setOsUserName("s1");
		s1.setUnixHost("192.168.0.26");
		s1.setLoginPassword("1");
		s1.setStatus("0");
		s1.setCostId(1);
		
		Service s2 = new Service();
		s2.setAccount(a);
		s2.setOsUserName("s2");
		s2.setUnixHost("192.168.0.23");
		s2.setLoginPassword("2");
		s2.setStatus("0");
		s2.setCostId(2);
		
		
		
		
	}
}
