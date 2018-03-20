package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rkritchat
 * @date 20-03-2561
 */
public class ConnectionDB {
	/**
	 * This method use for get Connection
	 * @return
	 * @throws ClassNotFoundException 
	 */
	public static Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return null;
	}
		
	/**
	 * This method use for close Connection, PrepareStatement and ResultSet
	 * @param con
	 * @param ps
	 * @param rs
	 * @throws SQLException
	 */
	public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(con!=null) con.close();
		if(ps!=null) ps.close();
		if(rs!=null) rs.close();
	}

}
