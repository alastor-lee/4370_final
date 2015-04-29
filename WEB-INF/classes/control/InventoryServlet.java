/*
	Called from menu.jsp
*/

package control;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;

public class InventoryServlet extends HttpServlet {
	Login bean = new Login();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		Inventory bean = new Inventory();
		HttpSession session = request.getSession();
		//JDBC driver name and database URL
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/inventory";
		//user info from session
		final String USER = new String((String)session.getAttribute("userID"));
		final String PASS = new String((String)session.getAttribute("passID"));

		try {
			//Register JDBC driver
			Class.forName(JDBC_DRIVER).newInstance();
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			//execute a query
			Statement stmt = conn.createStatement();
			
			String sql;
			//getting # of rows for String array in Inventory Bean
			sql = "SELECT COUNT(*) FROM on_hand;";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			bean.setInven(rs.getInt("COUNT(*)"));

			//getting information from total on_hand table
			sql = "SELECT * FROM on_hand;";
			rs = stmt.executeQuery(sql);
			String temp;
			int count = 0;	//for array index
			//extract data
			while(rs.next()) {
				//retrieve by column name
				int sku = rs.getInt("sku");
				String name = rs.getString("name");
				int quantity = rs.getInt("qty");
				double price = rs.getDouble("price_per");
				temp = sku+":"+name+":"+quantity+":"+price+"<br />";
				bean.addToInven(temp, count);
				count++;
			}
			//forwarding info to inventory.jsp
			String address = "/site_works/inventory.jsp";
			request.setAttribute("strArray", bean);
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
			
			//clean up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException se) {
			//returning to login screen with failure
			/*
			bean.setLogReturn("Invalid Login");
			String address = "/site_works/login.jsp";
			request.setAttribute("forPrint", bean);
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
			*/
			//printing stack
			se.printStackTrace();
		} catch(Exception e) {
			//Errors for Class.forName
			//bean.addToLogReturn("Exception");
			e.printStackTrace();
		}
	}
}