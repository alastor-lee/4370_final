<html>
<head><title>Login</title></head>

<!--This is the login screen -->
<!--Submits to login.java -->
<head>
<title>Login</title>
</head>
	<body>
		<!-- PRINTING BEAN MESSAGE -->
		<p>${forPrint.logReturn}</p>

		<form name="login" action="./log">
			Username: <input type="text" name="user"> </input> <br>
			Password: <input type="password" name="pass"> </input> <br>
			<input type="submit" value="Login">
		</form>
	</body>
</html>