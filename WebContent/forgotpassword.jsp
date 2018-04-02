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


<title>Login Form</title>
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


	         	<%
					if (request.getAttribute("success") != null) {
				%>

				<div class="alert alert-success" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span>
					<%=request.getAttribute("success")%>
				</div>

				<%
					request.removeAttribute("success");

					}
				%>



				<%
					if (request.getAttribute("error") != null) {
				%>

				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span>
					<%=request.getAttribute("error")%>
				</div>

				<%
					request.removeAttribute("error");

					}
				%>


				<form class="form-signin" autocomplete="off" action="ForgotPassword"
					method="post">

					<h4 class="form-signin-heading">Forgot Password</h4>

					<input type="email" name="email" class="form-control"
						autocomplete="off" placeholder="Enter your Email" required="">

					<button class="btn  btn-primary" type="submit">
						Done</button>

				</form>
			</div>


		</div>
	</div>

</body>
</html>