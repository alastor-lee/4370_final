<html>
<!--This is the menu.-->
<head>
<title>Main Menu</title>
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="Style.css"/>
</head>
	<body>
		<p>${forPrint.logReturn}</p>
		<h1>Main Menu</h1>

		<form name="view_profile" action="./profile">
			<input type="submit" value="Profile">
		</form>

		<form name="inventory_view" action="./inventory">
			<input type="submit" value="Inventory">
		</form>

		<form action="viewcart.jsp">
			<input type="submit" value="Shopping Cart">
		</form>

		<form action="register.jsp">
			<input type="submit" value="Register">
		</form>

		<form name="logout" action="./logout">
			<input type="submit" value="Logout">
		</form>

	</body>
</html>