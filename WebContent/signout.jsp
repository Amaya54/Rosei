<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';colo:white;}

h2{position  :absolute;top : 200px; left : 550px;font-size : 20px;}
p{position  :absolute;top : 255px; left : 650px;font-size : 20px;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<br><br><br>

<%session.invalidate(); System.out.println("Logged out");%>
<h2 align="center">You are Successfully Logged Out</h2>
<p align="center"><a href="LoginPage.jsp">Log In Again</a></p>
</body>
</html>