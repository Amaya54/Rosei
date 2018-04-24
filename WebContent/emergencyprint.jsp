<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet/ControllerEmergencyPrint" method="POST" enctype="application/x-www-form-urlencoded">
	
	<table style="position:absolute;left:200px;top:160px;">
	<tr><td>DATE</td><td><input type="date" size="25" name="dt" title="Enter Date here" /></td></tr><br/>	<br/>	
	
	
	<%

String x=((String)session.getAttribute("currentSessionUserId")).substring(0,1);

  if(session.getAttribute("currentSessionUserId")==null || !x.equals("m"))
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%> 
		
	<tr><td></td><td><input type="submit" style="font-size:20px;" size="5" name="button" value="submit"/> </td></tr>
	</table>
	</form>
</body>
</html>