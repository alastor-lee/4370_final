package control;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;

public class LoginServlet extends HttpServlet {
	Login bean = new Login();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		//JDBC driver name and database URL
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/music";

		//Credentials
		final String USER = new String(request.getParameter("user"));
		final String PASS = new String(request.getParameter("pass"));
		
		try {
			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			//setting session info
			//note that this only happens if the connection works
			HttpSession session = request.getSession(true);
			//session time
			Time createTime = new Time(session.getCreationTime());
			Time lastAccessTime = new Time(session.getLastAccessedTime());
			//bean.setLogReturn("Current Session Time: " + createTime.toString() + "\n");
			bean.setLogReturn("Created: "+createTime.toString()+" Current Sess: "+lastAccessTime.toString()+ "<br />");
			bean.addToLogReturn(session.getId() + "<br />");
			session.setAttribute("userID", USER);
			session.setAttribute("passID", PASS);

			/* NOT WORKING AND NOT NEEDED IMO
			if(session.isNew()) {
				bean.addToLogReturn("New User <br />");
				session.setAttribute("userID", USER);
				session.setAttribute("passID", PASS);
			} else {
				bean.addToLogReturn("Welcome to returning user <br />");
			}
			*/
			//getting session info for print test
			bean.addToLogReturn((String)session.getAttribute("userID") + "<br />");
			bean.addToLogReturn((String)session.getAttribute("passID") + "<br />");

			//closing out mysql test connection
			conn.close();

			//forwarding info to menu.jsp if login was successful
			String address = "/site_works/menu.jsp";
			request.setAttribute("forPrint", bean);
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);

		/* FOR WRITING TO BROWSER
		//setting response Content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Database Result";
		String docType = 
			"<!DOCTYPE html>" +
			"<html>" +
			"<head><title>HUEHUEHUE</title></head>" +
			"<body>";
		out.println(docType+"<p>Trying the out.println() statement</p>");
		try {
			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			out.println("<p>Try to print in the Try statement</p>");
			//Opening connection
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//execute a query
			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM albums;";
			ResultSet rs = stmt.executeQuery(sql);

			//extract data
			while(rs.next()) {
				//retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("album_name");
				String artist = rs.getString("artist_name");
				double time = rs.getDouble("play_time");

				//display the values
				out.println("ID: "+id+"<br />");
				out.println("Album: "+name+"<br />");
				out.println("Artist: "+artist+"<br />");
				out.println("Length: "+time+"<br />");
			}
			

			//clean up environment
			rs.close();
			stmt.close();
			//END OF WRITE STATEMENT	*/ 

		} catch(SQLException se) {
			//returning to login screen with failure
			bean.setLogReturn("Invalid Login");
			String address = "/site_works/login.jsp";
			request.setAttribute("forPrint", bean);
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
			//printing stack
			se.printStackTrace();
		} catch(Exception e) {
			//Errors for Class.forName
			bean.addToLogReturn("Exception");
			e.printStackTrace();
		}

		//out.println("</body></html>");
		/*
		finally {
			//for closing resources
			try {
				if(stmt != null)
					stmt.close();
			} catch(SQLException se) {
				//nothing to do 
			}
			try {
				if(conn != null)
					conn.close();
			} catch(SQLException se) {
				se.printStackTrace();
			} //end finally try
		}	//end try
		*/
	}
}