<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
form {text-align:center; width:20%; padding:10px; position:absolute; top:15%; left:40%; font-size:1.5em;}
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}
</style>
</head>
<body style="color:white;font-size:20px;font-face:bold;" style="position:absolute;left:200px;top:160px;">
<%

String x=((String)session.getAttribute("currentSessionUserId")).substring(0,1);

  if(session.getAttribute("currentSessionUserId")==null || !x.equals("m"))
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%> 

<form action="Servlet/ControllerGeneratePdf" method="POST" enctype="application/x-www-form-urlencoded">


<pre>Course :</pre>
<select name="course">
<option value="b">B.Tech</option>
<option value="a">M.Tech</option>
</select>


<pre>Year :</pre>
<select name="batch">
<option value="09">2009</option>
<option value="10">2010</option>
<option value="11">2011</option>
<option value="12">2012</option>
<option value="13">2013</option>
<option value="14">2014</option>
<option value="15">2015</option>
<option value="16">2016</option>
<option value="17">2017</option>
<option value="18">2018</option>
<option value="19">2019</option>
<option value="20">2020</option>
<option value="21">2021</option>
<option value="22">2022</option>
<option value="23">2023</option>
<option value="24">2024</option>
<option value="25">2025</option>
<option value="26">2026</option>
<option value="27">2027</option>
<option value="28">2028</option>
<option value="29">2029</option>
<option value="30">2030</option>
<option value="31">2031</option>
<option value="32">2032</option>
<option value="33">2033</option>
<option value="34">2034</option>
<option value="35">2035</option>
<option value="36">2036</option>
<option value="37">2037</option>
<option value="38">2038</option>
<option value="39">2039</option>
<option value="40">2040</option>
<option value="41">2041</option>

</select>


<pre>Branch :</pre>
<select name="branch">

<option value="1">CSE</option>
<option value="4">IT</option>
<option value="3">EEE</option>
<option value="2">ETC</option>
</select>
<br />
<br />
<input type="submit" value="submit" />

</form>

</body>
</html>