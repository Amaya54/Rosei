<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h1{position:fixed; left:35%; top:5%; }
h2{position:fixed; left:33%; top:35%;}
img{position:fixed; left:45%; top:20%;}
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}body{font-family:'Nova Square';color:white;}

</style>
<script>
function a(){
alert("here");
}
</script>
</head>
<body onclick="a()">
<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/invalidLogin.jsp"); //error page
		}%> 
<h1>Processing your request</h1>
<h2>Do not refresh or press back button</h2>
<br>
Please collect all your food cards between Friday 6:00 PM to Saturday 10:00 PM
<img src="files/loader.gif"/>
</body>
</html>