import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceImpl implements Service {
	Dto dto;
	SignupDto signupDto;
	@Override
	public boolean insert(Dto dto) throws ClassNotFoundException, SQLException {
		String sql="INSERT INTO student(rollno,fullname,course,fee,college,address) VALUES(?,?,?,?,?,?);";
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, dto.getRollno());
		preparedStatement.setString(2, dto.getFullname());
		preparedStatement.setString(3, dto.getCourse());
		preparedStatement.setFloat(4, dto.getFee());
		preparedStatement.setString(5, dto.getCollege());
		preparedStatement.setString(6, dto.getAddress());
		int executeUpdate = preparedStatement.executeUpdate();
		if(executeUpdate>0) {
			System.out.println("Data Inserted");
		}else {
			System.out.println("Data Not Inserted");
		}
		return true;
	}
	
	@Override
	public Dto read(int rollno) throws ClassNotFoundException, SQLException {
		String sql="SELECT * FROM student WHERE rollno=?;";
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, rollno);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			String fullname=resultSet.getString("fullname");
			String course=resultSet.getString("course");
			float fee=resultSet.getFloat("fee");
			String college=resultSet.getString("college");
			String address=resultSet.getString("address");
			
			dto=new Dto(rollno,fullname,course,fee,college,address);
			
			
			System.out.println("Data Reading");
			return dto;
		}
		else {
			System.out.println("Data Not Found");
			return null;
		}
		
	}

	@Override
	public boolean update(Dto dto) throws ClassNotFoundException, SQLException {
		String sql="UPDATE student SET fullname=?,course=?,fee=?,college=?,address=? WHERE rollno=?;";
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(6, dto.getRollno());
		preparedStatement.setString(1, dto.getFullname());
		preparedStatement.setString(2, dto.getCourse());
		preparedStatement.setFloat(3, dto.getFee());
		preparedStatement.setString(4, dto.getCollege());
		preparedStatement.setString(5, dto.getAddress());
		int executeUpdate = preparedStatement.executeUpdate();
		if(executeUpdate>0) {
			System.out.println("Data Updated");
		}else {
			System.out.println("Data Not Updated");
		}
		return true;
	}

	@Override
	public boolean delete(int rollno) throws ClassNotFoundException, SQLException {
		String sql="DELETE FROM student WHERE rollno=?;";
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, rollno);
		int executeUpdate = preparedStatement.executeUpdate();
		if(executeUpdate>0) {
			System.out.println("Data Deleted");
		}else {
			System.out.println("Data Not Deleted");
		}
		return true;
	}

	@Override
	public boolean signup(String username,String email,String password) throws SQLException, ClassNotFoundException {
		String sql="INSERT INTO signup(username,email,password) VALUES(?,?,?);";
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, password);
		int executeUpdate = preparedStatement.executeUpdate();
		if(executeUpdate>0) {
			System.out.println("Signup Data Inserted");
			return true;
		}else {
			System.out.println("Signup Data Not Inserted");
			return false;
		}
		
	}

	@Override
	public SignupDto login(String username, String password) throws ClassNotFoundException, SQLException {
		signupDto=new SignupDto();
		String sql="SELECT * FROM signup WHERE username=? AND password=?;";
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			String user=resultSet.getString("username");
			String pass=resultSet.getString("password");
			
			signupDto=new SignupDto(user,pass);
			
			
			System.out.println("Login User");
			return signupDto;
		}
		else {
			System.out.println("User Not Found");
			return null;
		}
	}

}
