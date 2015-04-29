/*
	AddToCart.java
	called from inventory.jsp
*/
package control;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;

public class AddToCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		/*
			1. Decrement qty from on_hand db
			2. Add item to cart DB
			3. If item is already in cart DB then simply increment the order quantity by 1
		*/
		Cart bean = new Cart();
		HttpSession session = request.getSession();
		//JDBC driver name and database URL
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/inventory";
		//user info from session
		final String USER = new String((String)session.getAttribute("userID"));
		final String PASS = new String((String)session.getAttribute("passID"));

		String sku = request.getParameter("sku");	//from inventory.jsp
		
		try {
			//Register JDBC driver
			Class.forName(JDBC_DRIVER).newInstance();
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Connection conn2 = DriverManager.getConnection(DB_URL,USER,PASS);
			
			//execute a query
			Statement stmt = conn.createStatement();
			Statement stmt2 = conn2.createStatement();
			String sqlUp, sql;
			ResultSet rs;
			//ResultSet set;

			/*
		//UPDATING CART AND INVENTORY 
			//sku is primary, can only have <= 1 row
			sqlUp = "Select * FROM cart WHERE sku="+sku;
			set = stmt.executeQuery(sqlUp);
			if(set.next()) {	//item is already in cart
				//incrementing order amount
				sqlUp = "UPDATE cart SET order_qty = order_qty + 1";
				stmt.executeQuery(sqlUp);
				bean.addToFeed("Order Amount Increased");
			} else {	//placing new item into cart
				sqlUp = "INSERT INTO cart(sku,name,price_per) SELECT sku,name,price_per FROM on_hand WHERE sku="+sku;
				stmt.executeQuery(sqlUp);
				sqlUp = "UPDATE cart SET order_qty = order_qty + 1";
				stmt.executeQuery(sqlUp);
				sqlUp = "UPDATE cart SET total=price_per*order_qty";
				stmt.executeQuery(sqlUp);
				bean.addToFeed("Item Added To Cart");
			}
			//decrementing amount in on_hand
			sqlUp = "UPDATE on_hand SET qty = qty - 1";
			stmt.executeQuery(sqlUp);

		*/
		//FROM HERE ON THE GOAL IS TO GET THE FULL INVENTORY

			//getting # of rows for String array in Inventory Bean
			sql = "SELECT COUNT(*) FROM cart;";
			rs = stmt2.executeQuery(sql);
			rs.next();
			bean.setInven(rs.getInt("COUNT(*)"));

			//getting information from total on_hand table
			sql = "SELECT * FROM cart;";
			rs = stmt2.executeQuery(sql);
			String temp;
			int count = 0;	//for array index
			//extract data
			while(rs.next()) {
				//retrieve by column name
				int newSku = rs.getInt("sku");
				String name = rs.getString("name");
				int quantity = rs.getInt("order_qty");
				double price = rs.getDouble("price_per");
				double total = rs.getDouble("total");
				temp = newSku+":"+name+":"+quantity+":"+price+":"+total+"<br />";
				bean.addToInven(temp, count);
				count++;
			}

			//forwarding info to viewcart.jsp
			String address = "/site_works/viewcart.jsp";
			request.setAttribute("strArray", bean);
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);

			//clean up environment
			//set.close();
			rs.close();
			stmt.close();
			stmt2.close();
			conn.close();

		} catch(SQLException se) {
			//dispatching return
			bean.setFeed("SQL Error");
			String address = "/site_works/viewcart.jsp";
			request.setAttribute("strArray", bean);
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
			se.printStackTrace();
		} catch(Exception e) {
			//Errors for Class.forName
			//bean.addToLogReturn("Exception");
			e.printStackTrace();
		}
	}
}