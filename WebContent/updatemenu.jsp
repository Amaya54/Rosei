<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MESS 0</title>

<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;font-size:150%;}
input{font-size:20px;}
select{font-size:20px;}

<%

String x=((String)session.getAttribute("currentSessionUserId")).substring(0,1);

  if(session.getAttribute("currentSessionUserId")==null || !x.equals("s"))
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%> 

</style>
</head>
<body>
<center>
<form action="Servlet/ControllerUpdateMenu" method="POST" enctype="application/x-www-form-urlencoded">
<table>

						<tr><td><select name="mid">
								<option value="m001">Mess1</option>
								<option value="m002">Mess2</option>					
								</select></td>		
												
						   <td><select name="day">
								<option value="mon">Monday</option>
								<option value="tue">Tuesday</option>
								<option value="wed">Wednesday</option>
								<option value="thu">Thursday</option>
								<option value="fri">Friday</option>
								<option value="sat">Saturday</option>
								<option value="sun">Sunday</option>
							</select></td>
							<td><select name="category">
								<option value="bf">Breakfast</option>
								<option value="lun">Lunch</option>
								<option value="din">Dinner</option>
							</select></td></tr>
						
							
						<tr><td>Veg: </td><td><input type="textbox" name="updateveg"  value=""></input></td></tr>
						<tr><td>Non veg: </td><td><input type="textbox" name="updatenv"  value=""></input></td></tr>
							<tr><td></td><td><input type="submit" value="update"  name="finalupdate"></input></td></tr>
</table>
</form></center>
</body>
</html>	