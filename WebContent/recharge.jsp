<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RECHARGE YOUR ACCOUNT</title>
<style>@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}</style>

<script>
function validateForm()
{
var x=document.forms["myForm"]["stdid"].value;
if (x==null || x=="")
  {
  alert("Please Enter the ID");
  return false;
  }
var y=document.forms["myForm"]["amt"].value;
if (y==null || y=="" || isNaN(y))
  {
  alert("Please Enter a valid Amount");
  return false;
  }
}
</script>
</head>
<body style="color:white;font-size:20px;font-face:bold;">
<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%> 
<form name="myForm"  action="Servlet/ControllerRecharge" method="POST" enctype="application/x-www-form-urlencoded" onsubmit="return validateForm()">
	
	<table style="position:absolute;left:150px;top:160px;">
	<tr><td>Student ID:</td><td><input type="text" size="25" name="stdid" title="Enter student id"/></td></tr><br/>	<br/>	
	
	
		<tr><td>Amount:</td><td><input type="text" size="25" name="amt" title="Enter amount" /></td></tr><br/>	<br/>
	<tr><td></td><td><input type="submit" style="font-size:20px;"  value="RECHARGE"/> </td></tr>
	</table>
	</form>

</body>
</html>