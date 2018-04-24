<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}</style>
</head>
<body>
<%@ page language="java" import="java.util.*,java.text.*,java.util.Date,java.sql.*, java.io.*" %>
<%
	if(session.getAttribute("currentSessionUsername")==null)
	{
	response.sendRedirect("https://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
	}%>
<%
String monbf=request.getParameter("monbf");
		String monlun=request.getParameter("monbfmt");
		String mondin=request.getParameter("mondin");
		out.println("here:"+monbf+monlun+mondin);
		%>
</body>
</html>