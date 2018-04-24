<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,javax.servlet.http.HttpSession" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square'; color:white; background:rgba(4,158,196,1);}
input{font-family:'Nova Square'; color:white;}
a{text-decoration:none; color:white; font-size:120%;}
</style>

</head>
	<body>
	<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%> 
	<br><br><br><br><br>
	<center><p style="cursor:hand;font-size:250%;">Account Settings</p><hr style="position:relative;top:-20px;width:300px;"/>
		
	<p><a href="changepassword.jsp">CHANGE PASSWORD</a></p>
	<p><a href="changedetails.jsp">CHANGE YOUR PERSONAL INFORMATION</a></p>
	<p><a href="login.jsp"><input style="border:none;background:rgba(3,107,129,1);color:white;border-radius:5px;padding:8px;cursor:pointer;font-size:110%;" type="button" value="BACK"/></a></p>
	</center>
	</body>
	</html>
