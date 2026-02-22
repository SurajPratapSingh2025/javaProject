

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Delete.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		
		ServiceImpl serviceImpl = new ServiceImpl();
		try {
			if(serviceImpl.delete(rollno)) {
				response.getWriter().print("<h1>Data Deleted</h1><br><a href=\"Test\">Go to Home</a>");
			}else {
				response.getWriter().print("<h1>Data Not Deleted</h1><br><a href=\"Test\">Go to Home</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
