
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static synchronized Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/prs_db";
			String username = "prs_db_user";
			String password = "sesame";

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(dbUrl, username, password);
			//Connection connection = DriverManager.getConnection(dbUrl, username, password);
			// return connection;
		} catch (SQLException e) {
			System.out.println("Error establishing connection");
			throw e;
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException me) {
			// IllegalAccessException|InstiatingException|ClassNotFoundException me) {
			System.err.println("exception in DBUtil...");
			me.printStackTrace();
		}
		return connection;
	}
}

