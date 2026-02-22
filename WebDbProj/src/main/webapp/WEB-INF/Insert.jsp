<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">This is my Data Insert Page</h1>
	
	<form action="Insert" method="post">
		<input type="number" name="rollno" placeholder="rollno">
		<input type="text" name="fullname" placeholder="fullname">
		<input type="text" name="course" placeholder="course">
		<input type="number" name="fee" placeholder="fee">
		<input type="text" name="college" placeholder="college">
		<input type="text" name="address" placeholder="address">
		<button type="submit">Submit</button>
	</form>
	
	
	<br><a href="http://localhost:8080/WebDbProj/">Go to Welcome Page</a>
	<br><a href="Test">Go to Home Page</a>
</body>
</html>