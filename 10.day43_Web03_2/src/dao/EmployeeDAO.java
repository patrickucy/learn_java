package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Employee;

public class EmployeeDAO {

	public List<Employee> findAll() throws Exception{
		List<Employee> employees = new ArrayList<Employee>();
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("select * from t_emp");
			rst = stat.executeQuery();
			
			while(rst.next()){
				Employee e = new Employee();
				e.setId(rst.getInt("id"));
				e.setName(rst.getString("name"));
				e.setSalary(rst.getDouble("salary"));
				e.setAge(rst.getInt("age"));
				
				employees.add(e);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if(rst !=null ){
				rst.close();
			}
			if(stat!=null){
				stat.cancel();
			}
			DBUtil.close(conn);
			
		}
		
		return employees;
		
	}

	public void add(Employee employee) throws Exception{
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("insert into t_emp(name,salary,age)"
					+ "values(?,?,?)");
			stat.setString(1, employee.getName());
			stat.setDouble(2, employee.getSalary());
			stat.setInt(3, employee.getAge());
			stat.executeUpdate();
			
		} catch(Exception e){
			throw e;
		} finally {
			if(stat!=null){
				stat.cancel();
			}
			DBUtil.close(conn);
			
		}
	}
	
	
}
