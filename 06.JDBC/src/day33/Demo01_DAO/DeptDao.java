package day33.Demo01_DAO;

import java.beans.Expression;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import day32.Demo01_DbUtil.DbUtil;

/**
 * Dao component, manipulation for table "dept"
 * 
 */
public class DeptDao {

	//find id via primary key 
	public Dept findById(int id) throws Exception {
		Connection con = null;
		try {
			con = DbUtil.getConnection();
			String sql = "select dept, deptname, from dept where deptno = ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			// encapsulate ResultSet as a dept Obejct
			if (rs.next()){ // because you just have one record, just use if(), don't use while()
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDeptname(rs.getString("deptname"));
				return dept;
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			/**
			 *  even though you throw this exception out, but you still need the finally block
			 */
			throw e;
		} finally{
			DbUtil.closeConnection(con);
		}
	}
}
