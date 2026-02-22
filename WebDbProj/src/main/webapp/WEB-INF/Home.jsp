<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Welcome to Home Page..</h1>
	<%
	Connection connection =(Connection) getServletContext().getAttribute("dbConnection");
	out.print("conn 1: "+connection);
	response.getWriter().print("conn 2:"+connection);
	%>
	<br>conn 3:
	<%=connection %>
	<br><br>
	<a href="Insert">Insert</a><br>
	<a href="Update">Update</a><br>
	<a href="Read">Read</a><br>
	<a href="Delete">Delete</a><br><br>
	
	<a href="http://localhost:8080/WebDbProj/">Logout</a><br>
	<a href="http://localhost:8080/WebDbProj/">Go to Welcome Page</a>
</body>
</html>