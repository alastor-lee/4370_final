<html>
<head><title>Login</title></head>

<!--This is the login screen -->
<!--Submits to login.java -->

<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="Style.css"/>

<head>
<title>Login</title>
</head>

<body>
<h1>Login</h1>

<div>
<!-- PRINTING BEAN MESSAGE -->
<p>${forPrint.logReturn}</p>

<form name="login" action="./log">
Username: <input type="text" name="user"> </input> 
<br><br>
Password: <input type="password" name="pass"> </input> 
<br><br>
<input type="submit" value="Login" class="reg">
</form>
</div>

</body>
</html>