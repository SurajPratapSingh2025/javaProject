

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Signup.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		ServiceImpl serviceImpl = new ServiceImpl();
		try {
			boolean key = serviceImpl.signup(username, email, password);
			if(key) {
				response.getWriter().print("<h1>Account Created</h1><br><a href=\"http://localhost:8080/WebDbProj/\">Go to Welcome Page</a>");
			}else {
				response.getWriter().print("<h1>Account Not Created</h1><br><a href=\"http://localhost:8080/WebDbProj/\">Go to Welcome Page</a>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
