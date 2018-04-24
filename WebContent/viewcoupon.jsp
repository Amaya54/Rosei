<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW COUPON</title>
<style>
@font-face{font-family: Nova Square; src: url('Files/NovaSquare.ttf');}
body{font-family:Nova Square;color:white;}
</style>
</head>
<body>
<%



  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%> 

<form action="Servlet/ControllerGenerateCouponPdf" method="POST" enctype="application/x-www-form-urlencoded">
<table  style="position:absolute;left:200px;top:160px;">
<tr>
<td>ID:</td><td><select name="id"><option value="m001">ROSEIGHARA-1</option><option value="m002">ROSEIGHARA-2</option></select></td></tr>
<tr><td></td><td><input style="font-size:20px;"  type="submit"/></td></tr>
</table>

</form>
</body>
</html>