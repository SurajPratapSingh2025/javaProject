

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Update.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		String fullname=request.getParameter("fullname");
		String course=request.getParameter("course");
		int fee=Integer.parseInt(request.getParameter("fee"));
		String college=request.getParameter("college");
		String address=request.getParameter("address");
		
		Dto dto = new Dto(rollno,fullname,course,fee,college,address);
		ServiceImpl serviceImpl = new ServiceImpl();
		try {
			if(serviceImpl.update(dto)) {
				response.getWriter().print("<h1>Data Updated</h1><br><a href=\"Test\">Go to Home</a>");
			}else {
				response.getWriter().print("<h1>Data Not Updated</h1><br><a href=\"Test\">Go to Home</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
