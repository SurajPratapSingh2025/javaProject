

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Read.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		ServiceImpl serviceImpl = new ServiceImpl();
		try {
			Dto dto = serviceImpl.read(rollno);
	        if (dto != null) {
	        	response.getWriter().print("<h1>Data Updated</h1>");
	        	
	            response.getWriter().println("Fullname: " + dto.getFullname() + "<br>");
	            response.getWriter().println("Course: " + dto.getCourse() + "<br>");
	            response.getWriter().println("Fee: " + dto.getFee() + "<br>");
	            response.getWriter().println("College: " + dto.getCollege() + "<br>");
	            response.getWriter().println("Address: " + dto.getAddress() + "<br><br>");
	            
	            response.getWriter().println("<a href='Test'>Go to Home</a>");

	        }else {
				response.getWriter().print("<h1>Data Not Read</h1><br><a href=\"Test\">Go to Home</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


