<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login </title>
<link rel="stylesheet" href="css/jquery-ui-1.10.3.custom.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-1.11.1.js"></script>
<script src="js/jquery-ui-1.10.3.custom.js"></script>
<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>
</head>
<body>
<div class="wrapper">	
<div class="container">
<div id="tabs">
  <ul>
    <li><a href="#login">Login</a></li>
    
  </ul>
  <div id="login">
  	
    <form method="post" action="LoginController">
    	<label for="Usuario">Usuario:</label>
    	<br/>
    	<input type="text" name="username" id="username"/>
    	<br/>
    	<label for="password">Password:</label>
    	<br/>
    	<input type="password" name="password" id="password"  />
    	<br/>
    	<br/>
    	<input type="submit" value="Login">
    </form>
  </div>
  
  
  
  </div>
</div>
</div>

</body>
</html>