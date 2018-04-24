<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square'; color:white; backgroun:rgba(4,158,196,1); font-size:80%;}
input{font-family:'Nova Square'; color:white;}
p{font-size:180%;}
#sub{border:none;background:rgba(3,107,129,1);color:white;border-radius:3px;padding:5px;cursor:pointer;font-size:130%;position:absolute;left:250px;top:385px;}
table{position:absolute;left:70px;top:60px;}
table tr th{height:30px;}
table tr td{background:rgba(3,107,129,1);border-radius:5px;padding:2px;curso:pointer;font-size:110%;height:20px;}
table tr th{background:rgba(3,107,129,1);border-radius:5px;padding:2px;cursor:default;font-size:110%;}
//table div{background:rgba(3,107,129,1);border-radius:5px;padding:8px;cursor:pointer;font-size:110%;}
//table div:hover{background:white;border-radius:5px;padding:2px;cursor:pointer;font-siz:110%;}
table input{border:none;box-shadow:1px 1px 2px black,-1px -1px 2px black;background:rgba(3,107,129,1);color:white;border-radius:5px;padding:5px;cursor:text;font-size:110%;width:270px;}
table select{borde:none;background:rgba(3,107,129,1);curso:pointer;font-family:'Nova Square';border-radius:5px;border:2px solid rgba(0,0,0,0.6);color:white;padding:8px;cursor:text;font-size:100%;width:280px;}

</style>
<script>

<%

String x=((String)session.getAttribute("currentSessionUserId")).substring(0,1);

  if(session.getAttribute("currentSessionUserId")==null || !x.equals("r"))
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%> 
	

function chk(){
	var id1=document.getElementById('id');
	if(id1.value.indexOf(' ')!=-1)
	{
		document.getElementById('p').innerHTML="*Space(s) in userId field";
		check();
		return false;
	}
	else
	{
		id1.value=id1.value.toLowerCase();
		check();
		return true;
	}

 }
 
 
 
function check(){
	var id1=document.getElementById('np');
	var id2=document.getElementById('rnp');
	var id3=document.getElementById('id');
	var id4=document.getElementById('name');
	var id5=document.getElementById('addr');
	var id6=document.getElementById('contact');
	var id7=document.getElementById('id');
	
	if(id3.value=='')
		document.getElementById('p').innerHTML="*id field is blank";
	else if(id1.value=='')
		document.getElementById('p').innerHTML="*password field is blank";
	else if(id1.value!=id2.value)
		document.getElementById('p').innerHTML="*password doesn't match";
	else if(id4.value=='')
		document.getElementById('p').innerHTML="*name field is blank";
	else if(id5.value=='')
		document.getElementById('p').innerHTML="*address field is blank";
	else if(id6.value=='')
		document.getElementById('p').innerHTML="*contact field is blank";
	else if(id7.value.indexOf(' ')!=-1)
		document.getElementById('p').innerHTML="*Space(s) in userId field";
	else
	{
		id7.value=id7.value.toLowerCase();
		document.getElementById('myForm').submit();//alert(id7.value);
	}
}

</script>
</head>
	<body>
	
	<% if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%>	
 
	
	
		<p style="position:absolute;left:240px;top:-10px;">NEW USER</p><hr style="width:125px;position:absolute;left:240px;top:40px;"/>
		<form id="myForm" action="Servlet/ControllerCreateUser" method="POST" enctype="application/x-www-form-urlencoded" onSubmit="return chk()">
		
			<table>
				<tr><th>USER ID:</td><td><input id="id" type="text" name="id"  title="Enter User ID"/></th></tr>
				<!--<tr><th>Old Password:</td><td><div><input id="op" type="password" size="25" name="opw" title="Enter your OLD Password here" /></div></th></tr>	-->
				<tr><th>NEW PASSWORD:</td><td><input name="pw" id="np" type="password" size="25" title="Enter NEW Password" /></th></tr>	
				<tr><th>CONFIRM PASSWORD:</td><td><input id="rnp" type="password" size="25" title="Type NEW Password again" /></th></tr>	
					<tr><th>NAME</th><td><input id="name" type="text" size="25" name="nm" title="Enter your NAME" /></td></tr>	<br/>
				<tr><th>ADDRESS</th><td><input id="addr" type="text" size="25" name="add" title="Enter your ADDRESS" /></td></tr>	<br/>
				<tr><th>GENDER</th><td><select name="gen" style="cursor:pointer;">	
				<option value="Male">MALE</option>
				<option value="Female">FEMALE</option></td></tr>	<br/>
				<tr><th>CONTACT</th><td><input id="contact" type="text" size="25" name="con" title="Enter your CONTACT number" /></td></tr>	<br/>	
				<tr><th> CLIENT ID: </th><td>
				<select name="cid" style="cursor:pointer;">	
				<option value="consumer">Consumer</option>
				<option value="secretary">Mess Secretary</option>
				<option value="contractor">Contractor</option>
				<option value="admin">Administrator</option>
				
				</select></td></tr>		
			</table>
			<input id="sub" type="button" size="5" name="button" value="Submit" onclick="check();"/> 
			<div id="p" style="position:absolute;top:390px;color:red;left:330px;font-size:110%;"></div>
		</form>
	</body>
	</html>
