<%@ page import="control.Inventory" %>

<!DOCTYPE html>
<html>
<head>
	<title>Inventory</title>
	<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="Style.css"/>
</head>
	<body>
	<!-- FILLER
		<h3>Menu Item - $100</h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque tincidunt mattis eros. Proin pretium in risus pretium fringilla. Nulla dictum, erat elementum varius feugiat, nisi ligula iaculis ligula, eget vulputate enim urna ut diam. Integer massa tellus, tincidunt quis nisi a, viverra gravida sem. Quisque eget feugiat augue, id tincidunt nibh. Donec aliquam arcu quis ligula tristique, vitae scelerisque elit scelerisque. Vestibulum laoreet ex sem, at tincidunt erat dapibus euismod. Aenean fringilla condimentum augue, et finibus nisl fringilla a. </p>
		<hr>
		<h3>Menu Item 2 - $100</h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque tincidunt mattis eros. Proin pretium in risus pretium fringilla. Nulla dictum, erat elementum varius feugiat, nisi ligula iaculis ligula, eget vulputate enim urna ut diam. Integer massa tellus, tincidunt quis nisi a, viverra gravida sem. Quisque eget feugiat augue, id tincidunt nibh. Donec aliquam arcu quis ligula tristique, vitae scelerisque elit scelerisque. Vestibulum laoreet ex sem, at tincidunt erat dapibus euismod. Aenean fringilla condimentum augue, et finibus nisl fringilla a. </p>
		<hr>
		
	-->


		<table>
		<tr>
			<td>SKU</td>
			<td>Item</td>
			<td>Quantity</td>
			<td>Price</td>
		</tr>
			<% 	Inventory wholeInven = (Inventory)request.getAttribute("strArray"); 
				String[] print = new String[4]; //4 is # of columns in on_hand table
				String sku = "";
				for(int i=0; i < wholeInven.getInvenLength(); i++) {
					print = wholeInven.getInven(i).split(":");
					sku = print[0];
					out.println("<tr>");
					for(int j=0; j < print.length; j++) {
						out.println("<td>" + print[j] + "</td>");
					}
					//this button sends info to AddToCart
					out.println("<td><form action=\"./shop\"><input type=\"submit\" name=\"sku\" value=\""+sku+"\" /></form></td>");
					out.println("</tr>");
				}
			%>
		</table>
		<a href="menu.jsp">Return to Menu</a>
	</body>
</html>