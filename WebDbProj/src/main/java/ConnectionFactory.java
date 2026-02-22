import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static Connection connection;
//	public static Connection getConnection(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {
//		Class.forName(driver);
//		connection = DriverManager.getConnection(url,username,password);
//		System.out.println(connection);
//		createTable();
//		return connection;
//	}
	private static HikariDataSource hikariDataSource;
	
	public static void init(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);
		hikariDataSource=new HikariDataSource(hikariConfig);
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		connection = hikariDataSource.getConnection();
		System.out.println(connection);
		studentTable();
		signupTable();
		return connection;
	}
	public static void studentTable() throws SQLException {
		String sql="CREATE TABLE IF NOT EXISTS student("
				+ "rollno INT NOT NULL UNIQUE,"
				+ "fullname VARCHAR(20) NOT NULL ,"
				+ "course VARCHAR(50) NOT NULL ,"
				+ "fee DECIMAL(10,2) NOT NULL ,"
				+ "college VARCHAR(50) NOT NULL ,"
				+ "address VARCHAR(100) NOT NULL);";
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Student Table Created");
	}
	public static void signupTable() throws SQLException {
		String sql="CREATE TABLE IF NOT EXISTS signup ("
				+ "    sn INT PRIMARY KEY AUTO_INCREMENT,"
				+ "    username VARCHAR(10) NOT NULL,"
				+ "    email VARCHAR(50) NOT NULL,"
				+ "    password VARCHAR(10) NOT NULL);";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Singup Table Created");
	}
}
