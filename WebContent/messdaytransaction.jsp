<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}body{font-family:'Nova Square';color:white;}</style>

</head>
<body>
<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/invalidLogin.jsp"); //error page
		}%> 
<form action="processmessdaytransaction.jsp" method="GET" enctype="application/x-www-form-urlencoded">
	
	<table>
	<tr><td>DATE</td><td><input type="date" size="25" name="dt" title="Enter Date here" /></td></tr><br/>	<br/>	
	
	
		
	<tr><td><input type="submit" size="5" name="button" value="GET"/> </td></tr>
	</table>
	</form>
</body>
</html>