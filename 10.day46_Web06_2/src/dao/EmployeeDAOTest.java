package dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import entity.Employee;

public class EmployeeDAOTest {

	@Test
	public void testFindall() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		
		List<Employee> employees =  dao.findAll();
		
		System.out.println(employees);
		
		
	}
	
	@Test
	public void testSave() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = new Employee();
		e.setName("emp1111");
		e.setAge(20);
	
		e.setSalary(5000);
		dao.add(e);
	}
	
	
	@Test
	public void testDelete() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		dao.delete(27);
		
	}
	
	@Test
	public void testLoad() throws Exception {
		
	}

}
