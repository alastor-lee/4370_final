<%@ page import="control.Cart" %>

<html>
<!--This is the shopping cart.-->
<head>
	<title>Shopping Cart</title>
	<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="Style.css"/>
</head>

<body>
	<h1>Shopping Cart</h1>
	<!--
	<table class="shifted">
	<tr>
		<th>Item</th>
		<th>Price</th>
	</tr>
	<tr>
		<td>Cart Item</td>
		<td>$100</td>
	</tr>
	</table>

	<p>Cart Items go into the above table. We may need to create the html tags in java, too.</p>
	<hr>

	-->

	<table>
		<tr>
			<td>SKU</td>
			<td>Item</td>
			<td>Quantity</td>
			<td>Price</td>
		</tr>
			<% 	Cart cartInven = (Cart)request.getAttribute("strArray"); 
				String[] print = new String[5]; //5 is # of columns in cart table
				for(int i=0; i < cartInven.getInvenLength(); i++) {
					print = cartInven.getInven(i).split(":");
					out.println("<tr>");
					for(int j=0; j < print.length; j++) {
						out.println("<td>" + print[j] + "</td>");
					}
					out.println("</tr>");
				}
			%>
		</table>

	<form>
	<input type="Submit" value="Checkout" class="shiny">
	</form>

	<a href="menu.jsp">Return to menu</a>
</body>
</html>