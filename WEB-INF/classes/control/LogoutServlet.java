package control;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;

public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		Logout bean = new Logout();

		HttpSession session = request.getSession();
		bean.setLogReturn("Previous user: " + session.getAttribute("userID") + "<br />");
		bean.addToLogReturn("Previous pass: " + session.getAttribute("passID") + "<br />");

		//ending session
		session.invalidate();
		bean.addToLogReturn("Session Ended");

		//returning to login screen
		String address = "/site_works/login.jsp";
		request.setAttribute("forPrint", bean);
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
}