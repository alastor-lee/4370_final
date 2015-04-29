<%@ page import="control.Inventory" %>

<html>
<head>
<title>Inventory</title>

<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="Style.css"/>

</head>
	<body>
	<!--
		<h3>Menu Item - $100</h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque tincidunt mattis eros. Proin pretium in risus pretium fringilla. Nulla dictum, erat elementum varius feugiat, nisi ligula iaculis ligula, eget vulputate enim urna ut diam. Integer massa tellus, tincidunt quis nisi a, viverra gravida sem. Quisque eget feugiat augue, id tincidunt nibh. Donec aliquam arcu quis ligula tristique, vitae scelerisque elit scelerisque. Vestibulum laoreet ex sem, at tincidunt erat dapibus euismod. Aenean fringilla condimentum augue, et finibus nisl fringilla a. </p>
		<hr>
		<h3>Menu Item 2 - $100</h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque tincidunt mattis eros. Proin pretium in risus pretium fringilla. Nulla dictum, erat elementum varius feugiat, nisi ligula iaculis ligula, eget vulputate enim urna ut diam. Integer massa tellus, tincidunt quis nisi a, viverra gravida sem. Quisque eget feugiat augue, id tincidunt nibh. Donec aliquam arcu quis ligula tristique, vitae scelerisque elit scelerisque. Vestibulum laoreet ex sem, at tincidunt erat dapibus euismod. Aenean fringilla condimentum augue, et finibus nisl fringilla a. </p>
		<hr>
		<a href="menu.jsp">Return to Menu</a>
	-->

		<% 	Inventory wholeInven = (Inventory)request.getAttribute("strArray"); 
			for(int i=0; i < wholeInven.getInvenLength(); i++) {
				out.println(wholeInven.getInven(i) + "<br />");
			}
		%>
	</body>
</html>