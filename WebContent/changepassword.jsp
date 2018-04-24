

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*,javax.servlet.http.HttpSession" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square'; color:white; background:rgba(4,158,196,1); font-size:140%;}
input{font-family:'Nova Square'; color:white;}
p{font-size:180%;}
#sub{border:none;background:rgba(3,107,129,1);color:white;border-radius:5px;padding:8px;cursor:pointer;font-size:110%;position:relative;left:10px;}
table tr th{height:40px;}
table td{background:rgba(3,107,129,1);border-radius:5px;padding:8px;cursor:pointer;font-size:110%;}
table th{background:rgba(3,107,129,1);border-radius:5px;padding:8px;cursor:pointer;font-size:110%;}
//table div{background:rgba(3,107,129,1);border-radius:5px;padding:8px;cursor:pointer;font-size:110%;}
//table div:hover{background:white;border-radius:5px;padding:2px;cursor:pointer;font-siz:110%;}
table input{border:none;box-shadow:1px 1px 2px black,-1px -1px 2px black;background:rgba(3,107,129,1);color:white;border-radius:5px;padding:8px;cursor:text;font-size:110%;width:300px;}

</style>
<script>

function check(){
	var id1=document.getElementById('np');
	var id2=document.getElementById('rnp');
	var id3=document.getElementById('op');

		
	if(id3.value=='')
		document.getElementById('p').innerHTML="*old password field is blank";
	else if(id1.value=='')
		document.getElementById('p').innerHTML="*new password field is blank";
	else if(id1.value!=id2.value||id1.value=='')
		document.getElementById('p').innerHTML="*password doesn't match";
	else
		document.getElementById('myForm').submit();
}

</script>
</head>
	<body>
	 
	 
	 <%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%>
	 
	
	<br><br>
	<center><p>Update Your Information</p><hr style="width:470px;position:relative;top:-20px;background-color:rgba(3,107,129,1);"/>
	<form id="myForm" action="Servlet/ControllerAccountSettings" method="POST" enctype="application/x-www-form-urlencoded">
	
	<table>
	<tr><th>User Id:</td><td><center><%out.println(session.getAttribute("currentSessionUserId")); %></center></th></tr>
	<tr><th>Old Password:</td><td><div><input id="op" type="password" size="25" name="opw" title="Enter OLD Password" /></div></th></tr>	
	<tr><th>New Password:</td><td><input id="np" type="password" size="25" name="npw" title="Enter NEW Password" /></th></tr>	
	<tr><th>Confirm Password:</td><td><input id="rnp" type="password" size="25" name="cnpw" title="Type NEW Password again" /></th></tr>	
				
	</table>
	<input id="sub" type="submit" size="5" name="button" value="Submit" onclick="check();"/> 
	<div id="p" style="position:absolute;top:480px;color:red;left:750px;font-size:70%;"></div>
	<p><a href="accountSettings.jsp"><input style="position:absolute;left:745px;top:475px;border:none;background:rgba(3,107,129,1);color:white;border-radius:5px;padding:8px;cursor:pointer;font-size:60%;" type="button" value="BACK"/></a></p>
	</form>
	</center>
	</body>
	</html>
