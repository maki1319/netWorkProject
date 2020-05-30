package netWorkProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {
	private static  String url="jdbc:mysql://localhost:3306/qquser";
    private static String user="root";
    private static String password="maki";
    private jdbcUtil() {
    	
    }
    static {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw  new ExceptionInInitializerError(e);
		}
    }
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,password);
	}

	public static void free(ResultSet rs, PreparedStatement st, Connection conn) {
		// TODO Auto-generated method stub
		if(rs!=null)
		{
			if(st!=null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			finally {
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
		
	
}
