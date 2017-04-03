package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

	public int add(Employee employee) throws Exception{
		int id = -1;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("insert into t_emp(name,salary,age)"
					+ "values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, employee.getName());
			stat.setDouble(2, employee.getSalary());
			stat.setInt(3, employee.getAge());
			stat.executeUpdate();
			rst = stat.getGeneratedKeys();
			if(rst.next()){
				id = rst.getInt(1);
			}

		} catch(Exception e){
			throw e;
		} finally {
			if(stat!=null){
				stat.cancel();
			}
			DBUtil.close(conn);

		}
		return id;
	}

	public void delete(int id) throws Exception{
		Connection conn = null;
		PreparedStatement stat =null;

		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("delete from t_emp where id=?");
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally{
			if(stat !=null){
				stat.close();
			}
			DBUtil.close(conn);
		}

	}

	public Employee findById(int id) throws Exception {
		Employee e = null;

		Connection conn = null;
		PreparedStatement stat =null;
		ResultSet rst = null;

		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("select * from t_emp where id=?");
			stat.setInt(1, id);
			rst = stat.executeQuery();

			if(rst.next()){
				e = new Employee();
				e.setId(id);
				e.setName( rst.getString("name"));
				e.setSalary( rst.getDouble("salary"));
				e.setAge(rst.getInt("age"));
			}
			return e;
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			throw e2;
		} finally{
			if(rst != null){
				rst.close();
			}
			if(stat != null){
				stat.close();
			}
			DBUtil.close(conn);

		}

	}


	public void modify(Employee e) throws Exception{
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("update t_emp set name=?,salary=?,age=? where id=?");
			stat.setString(1, e.getName());
			stat.setDouble(2, e.getSalary());
			stat.setInt(3, e.getAge());
			stat.setInt(4, e.getId());
			stat.executeUpdate();
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		} finally{
			if(stat != null){
				stat.close();
			}
			if( conn!= null){
				conn.close();
			}
			DBUtil.close(conn);
		}
	}
}














