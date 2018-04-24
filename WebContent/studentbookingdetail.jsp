<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking History</title>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}

#booking {position:absolute;top:30%;left:35%;}
table tr td{padding:15px;}
//table{position:absolute;  overflow:hidden; box-shado:0px 3px 10px rgb(0,50,0); top:0px; left:0px; min-height:410px; min-width:600px; height:85%; width:55%; borde:1px solid black;z-index:3;}
//table tr td{position:relative; borde:1px solid black; heigh:55px; width:25%;}
//table tr th{borde:1px solid black; heigh:30px; background:rgba(2,96,119,0.8);}
//table tr td div{position:relative; cursor:pointer; lef:0px; float:left; height:38px; width:130px; padding:7px; background:rgba(2,96,119,0.5); borde:1px solid black; z-index:10;}
//table tr td div p{position:relative; cursor:pointer; top:-10px;}

</style>
</head>
<body>
<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/invalidLogin.jsp"); //error page
		}%> 
		<br><br><br>
		<center>
<form id="Booking" action="Servlet/ControllerviewBookingDetail" method="POST" enctype="application/x-www-form-urlencoded">
<center style="font-size:30px;">Booking history is available only from JUNE due to database maintenance</center>
<table>
<tr>

<td>SELECT MESS:</td><td><select name="mess">
	<option value="1">ROSEIGHARA-1</option>	
	<option value="2">ROSEIGHARA-2</option>
	</select></td></tr><tr>
<td>MONTH:</td>
<td><select name="month">
	
	<option value="01" id="">JANUARY</option>
	<option value="02" id="">FEBRUARY</option>
	<option value="03" id="">MARCH</option>
	<option value="04" id="">APRIL</option>
	<option value="05" id="">MAY</option>
	<option value="06" id="">JUNE</option>
	<option value="07" id="">JULY</option>
	<option value="08" id="">AUGUST</option>
	<option value="09" id="">SEPTEMBER</option>
	<option value="10" id="">OCTOBER</option>
	<option value="11" id="">NOVEMBER</option>
	<option value="12" id="">DECEMBER</option>
</select></td></tr><tr>
<td>YEAR:</td>
<td><select name="year">
	<option value="13" id="">2013</option>
	<option value="14" id="">2014</option>
	<option value="15" id="">2015</option>
	<option value="16" id="">2016</option>
	<option value="17" id="">2017</option>
	<option value="18" id="">2018</option>
	<option value="19" id="">2019</option>
	<option value="20" id="">2020</option>
	<option value="21" id="">2021</option>
	<option value="22" id="">2022</option>
	<option value="23" id="">2023</option>
	<option value="24" id="">2024</option>
	</select>
</td></tr>
<tr>
<td align="center">B<input type="radio" value="B" name="radio" /></td>
<td align="center">L<input type="radio" value="L" name="radio" /></td>
<td align="center">D<input type="radio" value="D" name="radio" /></td>	
</tr>
<td></td>
	<td align="center">
	<input type="submit" value="submit"/>
	</td>
</tr>
</table>
</form>
</center>

</body>
</html>