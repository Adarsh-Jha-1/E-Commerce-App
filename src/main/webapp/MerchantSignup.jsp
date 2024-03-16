<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="SaveMerchant" method="post">

		<label for="Name">Name:</label> <input type="text" id="name"
			name="name" required><br> 
		`<label for="email">Email:</label>
		<input type="text" id="email" name="email" required><br>
		
		<label for="mobileNumber">Phone Number:</label>
		<input type="text" id="mobileNumber" name="mobileNumber" required><br>

		<label for="password">Password:</label> <input type="password"
			id="password" name="password" required><br> <input
			type="submit" value="Login">
	</form>
	<a href="MerchantLogin">Already a merchant -Log in</a>
</body>
</html>