package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import entity.Employee;

public class EmployeeDAOTest {

	@Test
	public void testFindByPages() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> employees = dao.findByPages(2, 5);
		System.out.println(employees);
	}

	@Test
	public void testGetTotalPages() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		System.out.println(dao.getTotalPages(5));
	}

}
