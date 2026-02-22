import java.sql.SQLException;

public interface Service {
	public boolean insert(Dto dto) throws ClassNotFoundException, SQLException;
	public Dto read(int rollno) throws ClassNotFoundException, SQLException;
	public boolean update(Dto dto) throws ClassNotFoundException, SQLException;
	public boolean delete(int rollno) throws ClassNotFoundException, SQLException;
	
	public boolean signup(String username,String email,String password) throws SQLException, ClassNotFoundException;
	public SignupDto login(String username,String password) throws ClassNotFoundException, SQLException;
}
