package control;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		Login bean = new Login();

		//String address = "/site_works/login.jsp";
		//RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		//dispatcher.forward(request, response);

		//JDBC driver name and database URL
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/music";

		//Credentials
		final String USER = request.getParameter("user");
		final String PASS = request.getParameter("pass");
		//final String USER = "root";
		//final String PASS = "jakill990";

		//String returnStr = new String();
		
		try {
			//TEST
			bean.setLogReturn("HALP ME PLOX");

			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			//setting session info
			//this only happens if the connection works
			HttpSession session = request.getSession(true);
			//session creation time
			Date createTime = new Date(session.getCreationTime());
			Date lastAccessTime = new Date(session.getLastAccessedTime());
			//bean.setLogReturn("Current Session Time: " + createTime.toString() + "\n");

			if(session.isNew()) {
				//returnStr += "New User \n";
				session.setAttribute("userID", USER);
				session.setAttribute("passID", PASS);
			} else {
				//returnStr += "Returning User \n";
			}
			conn.close();

			//returning info to login.jsp
			String address = "/site_works/login.jsp";
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
			END OF WRITE STATEMENT	*/ 

		} catch(SQLException se) {
			//errors for JDBC
			response.sendRedirect("localhost:8080/4370_final/site_works/login.jsp");
			se.printStackTrace();
		} catch(Exception e) {
			//Errors for Class.forName
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