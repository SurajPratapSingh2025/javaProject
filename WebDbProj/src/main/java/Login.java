

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		
		ServiceImpl serviceImpl=new ServiceImpl();
		try {
			SignupDto signupDto=serviceImpl.login(username, password);
			HttpSession session = request.getSession();
			if(signupDto != null) {
				session=request.getSession();
				session.setAttribute("user", username);

				request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
