package day32.Demo01_DbUtil;
/**
 * in order to prevent constant alteration of source code, you can store all parameter into a file
 * later you just need to read those files instead of altering your source code
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	private static String url = "";
	private static String username = "";
	private static String password = "";
	private static String driver = "";
	
	static{
		/**
		 *  because this is s util class, every thing should be static. this is not a class for instantiation
		 *  this block will only be executed for once
		 */
		Properties props = new Properties();
		// it can leave this input stream alone, GC will collect it if don't close it. but if you got 1K input stream, you'd better close it
		InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("day32/Demo01_DbUtil/db.properties");
		try {
			props.load(is);
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
			driver = props.getProperty("driver");
			
			Class.forName(driver); // register driver

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * For testing
	 */
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = getConnection();
			System.out.println(con);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException{
		
		
		
		
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
	
	
	public static void closeConnection(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
