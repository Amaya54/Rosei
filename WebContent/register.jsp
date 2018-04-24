<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square'; color:white; background:rgba(4,158,196,1); font-size:140%;}
input{font-family:'Nova Square'; color:white;}
p{font-size:180%;}
#sub{border:none;background:rgba(3,107,129,1);color:white;border-radius:5px;padding:8px;cursor:pointer;font-size:110%;position:relative;left:50px;}
table tr th{height:40px;}
table td{background:rgba(3,107,129,1);border-radius:5px;padding:8px;curso:pointer;font-size:110%;}
//table input:focus{outline:none;border:1px dotted white}
table th{background:rgba(3,107,129,1);border-radius:5px;padding:8px;cursor:inherit;font-size:110%;}
//table div{background:rgba(3,107,129,1);border-radius:5px;padding:8px;curso:pointer;font-size:110%;}
//table div:hover{background:white;border-radius:5px;padding:2px;curso:pointer;font-siz:110%;}
table input{border:none;box-shadow:1px 1px 2px black,-1px -1px 2px black;text-align:center;background:rgba(3,107,129,1);color:white;border-radius:5px;padding:8px;cursor:text;font-size:110%;width:300px;}

</style>

</head>
<body>
	 
	 
	 
	 
	<br><br>
		<center><p>IIIT SOFTWARE GROUP REGISTERATION</p><hr style="width:310px;position:relative;top:-20px;background-color:rgba(3,107,129,1);"/>

	<form action="Servlet/ControllerRegister" method="POST" enctype="application/x-www-form-urlencoded">
	
	<table>
	
	<tr><td>NAME:</td><td><input type="text" size="25" name="nm" title="Enter your NAME here" value=""/></td></tr>	
	<tr><td>ID:</td><td><input type="text" size="25" name="id" title="Enter your College ID" value=""/></td></tr>
	<tr><td>EMAIL:</td><td><input type="email" size="25" name="email" title="Enter your Email Address" value=""/></td></tr>
	<tr><td>CONTACT:</td><td><input type="text" size="25" name="con" title="Enter your CONTACT number" value=""/></td></tr>				
	
	</table>
	<input id="sub" type="submit" size="5" name="button" value="SUBMIT"/>
	
	</form>

</body>
</html>