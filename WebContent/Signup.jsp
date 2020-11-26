<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.mie.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>SkuleBus - Create an Account</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Date Picker Javascript -->
<!-- https://jqueryui.com/datepicker/ -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>

	<%@ include file="navbar.jsp"%>

	

	<div class="container-fluid text-center">
		<div class="row content">
			
			<div class="col-sm-8 text-left">
				<h1>Create an Account</h1>

				
				 <br>
				<br>

				<form method="POST" action='SignupController' name="frmAddUser">
					Username: <input type="text" name="username"
						value="<c:out value="${member.username}" />"><br>
					Password: <input type="text" name="password"
						value="<c:out value="${member.password}" />"><br>
					First Name: <input type="text" name="firstName"
						value="<c:out value="${member.firstName}" />"><br>
					Last Name : <input type="text" name="lastName"
						value="<c:out value="${member.lastName}" />"><br>
					Email: <input type="text" name="email"
						value="<c:out value="${member.email}" />"><br> <br>
					<input type="submit" class="btn btn-info" value="Submit" />
				</form>

			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>
