//set class path?
package control;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		Login bean = new Login();
		request.setAttribute("stringTest", bean);
		String address = "/site_works/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);

		/*
		//JDBC driver name and database URL
		static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		static final String DB_URL="jdbc:mysql://localhost:3306/music";

		//Credentials
		static final String USER="root";
		static final String PASS="jakill990";

		//setting response Content type
		response.setContentType("text/html");
		*/
	}
}