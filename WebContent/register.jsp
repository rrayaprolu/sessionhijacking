<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="css/loginstyle.css">

<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.js"></script>
<title>Register</title>
</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> </a>
		</div>
	</div>
	</nav>

	<div class="container">

		<div class="col-sm-12">
			<div class="col-sm-4 col-sm-offset-4" style="margin-top: 50px;">

				<form class="form-signin" autocomplete="off" action="register"
					method="post">


					<h4 class="form-signin-heading">Register</h4>

					<input name="name" class="form-control" placeholder="Your name"
						required="" autofocus="" autocomplete="off">


					<label class="sr-only form-control"> User Name</label>
					<input name="username" class="form-control" placeholder="User Name"
						required="" autofocus="" autocomplete="off">
					<label class="sr-only form-control">Password</label>
					<input type="password" style="display: none">
					<input type="password" name="password" class="form-control"
						autocomplete="off" placeholder="Password" required="">
				
					<input type="email" name="email" class="form-control"
						autocomplete="off" placeholder="Email" required="">
				
				
					<input name="checkinjection" class="hide"
						value="<%=request.getParameter("testsqlinj")%>">
						
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						Register</button>

				</form>

				<a class="btn btn-lg btn-warning btn-block" href="login.jsp"
					style="margin-top: 15px;">Login </a>


			</div>
		</div>
	</div>

</body>
</html>