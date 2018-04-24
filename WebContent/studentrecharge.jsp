<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}
.mess{box-shadow:3px 3px 4px blac; z-index:1; position:absolute; cursor:pointer; top:95px; font-size:200%; padding:35px; height:180px; width:225px; text-align:center; border-radiu:184px; background:rgba(3,107,129,0.8);}
#p1{position:relative; top:40px; color:white;}
#p2{position:relative; top:40px; color:white;}
.mess:hover{box-shadow:inset 0px 0px 50px black; border:1px solid rgba(3,107,129,1);}
#mess1{left:8px;}
#mess2{left:303px;}
#wrapper{min-height:420px; height:64%; min-width:600px; width:44%; background:grey;}
//#submit{position:absolute;  cursor:pointer; border:1px solid black; border-radius:5px; box-shadow:1px 1px 2px black; top:370px; left:280px; padding:4px; font-size:115%; heigh:30px; widt:70px; background:rgba(2,96,119,0.5);}
//#submit:hover{box-shadow:inset 1px 1px 2px black;}
h1{position:absolute;left:170px;top:0px; color:white; }


</style>
<script>
function change(id1){
	//id1.style.background="rgba(3,107,129,0.4)";
	var str=id1.id;
	//if(str=='mess1') var y='mess2';
	//else var y='mess1';
	//document.getElementById(y).style.background="rgba(3,107,129,0.8)";
	var x=str.charAt(4);
	document.getElementById('o'+x).selected=true;//alert(x);
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
	
	<h1 style="z-index:2;">Please Select Mess</h1>
<div id="mess1" class="mess" onclick="change(this)"><p id="p1">Roseighara 1</p></div>
<div id="mess2" class="mess" onclick="change(this)"><p id="p2">Roseighara 2</p></div>
	
	
	
<form id="myForm" style="visibility:hidden;" action="Servlet/ControllerviewRecharge" method="POST" enctype="application/x-www-form-urlencoded">
	
	
	Select Mess<select name="mess">
	<option id="o1" value="m001">Mess1</option>	
	<option id="o2" value="m002">Mess2</option>
	</select>
		
	<input type="submit" size="5" name="button" value="GET"/> 
	
	</form>
</body>
</html>