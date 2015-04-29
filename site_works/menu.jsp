<html>
<!--This is the menu.-->
<head>
<title>Main Menu</title>
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="Style.css"/>
</head>

<body>
<h1>Main Menu</h1>

<p>${forPrint.logReturn}</p>

<form action="register.jsp">
<input type="submit" value="Register" class="menu">
</form>

<form action="profile.jsp">
<input type="submit" value="Profile" class="menu">
</form>

<form action="inventory.jsp">
<input type="submit" value="Inventory" class="menu">
</form>

<form action="viewcart.jsp">
<input type="submit" value="Shopping Cart" class="menu">
</form>

<<<<<<< HEAD
<form>
<input type="submit" value="Logout" class="menu">
=======
<form name="logout" action="./logout">
<input type="submit" value="Logout">
>>>>>>> origin/master
</form>

</body>
</html>