<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<style>
@font-face
{
font-family: Nova Square;
src: url('Files/NovaSquare.ttf');
}

@font-face
{
font-family: Open Sans Condensed;
src: url('Files/OpenSans-CondLight.ttf');
}

#header11{

font-family: 'Nova Square', serif;

position:relative;left:0px;top:-35px;
color:white;font-size:3.1em;
font-weight: 400;
text-shadow: 0 1px 2px rgba(0,0,0,0.3);
}
#header22{

font-family: 'Open Sans Condensed', sans-serif;

position:absolute;left:125px;top:70px;text-shadow:0px 0px 3px black;
color:white;font-weight:300;font-size:1.4em;
}

@-webkit-keyframes animate-cloud{from{background-position:1000px 100%;} to{background-position:0 100%;}}
@-moz-keyframes animate-cloud{from{background-position:1000px 100%;} to{background-position:0 100%;}}@-ms-keyframes animate-cloud{from{background-position:1000px 100%;} to{background-position:0 100%;}}
@-o-keyframes animate-cloud{from{background-position:1000px 100%;} to{background-position:0 100%;}}
.animate-cloud-key from{background-position:1000px 100%;}
.animate-cloud-key to{background-position:0 100%;}

@-webkit-keyframes botanm{
	from{top:150px;}
	to{top:200px;}
}
@-moz-keyframes botanm{
	from{top:150px;}
	to{top:200px;}
}

body{background-color:#049ec4;}

#topbox{
position:absolute;top:-10px;left:30%;
width:500px;height:110px;z-index:20;
background-color:#191919;
background-image:-webkit-linear-gradient(top, #282828, #191919);
border-radius:20px;box-shadow:0px 0px 2px black;border:solid 1px black;
}

#one{
	background:url('Files/jpeg.jpg');
	width:100%;height:485px;position:absolute;top:150px;left:0px;
	-webkit-animation: animate-cloud 30s linear infinite;
	-moz-animation: animate-cloud 30s linear infinite;
}

#subline{
	position:relative;top:-15px;left:600px;
}
#bot{position:relative;top:150px;left:350px;width:250px;height:250px;
	-webkit-animation: botanm 2s linear infinite alternate;
	-moz-animation: botanm 2s linear infinite alternate;
}

#dummy{
background-image:url('Files/bg.jpg');
position:absolute; bottom:0px;left:0px;width:100%;height:40px;
}

#box{position:absolute;top:450px;left:400px;box-shadow:0px 0px 1px black;
width:550px;height:150px;background-color:white;border:solid 1px black;z-index:20;
}

.form-5 {
    width: 300px;
    border-radius: 5px;
    box-shadow: 0 0 5px rgba(0,0,0,0.1), 0 3px 2px rgba(0,0,0,0.1);
}
.form-5 p {
    width: 70%;
    float: left;
    border-radius: 5px 0 0 5px;
    border: 1px solid #fff;
    border-right: none;
}
 
.form-5 input[type=text],
.form-5 input[type=password] {
    width: 100%;
    height: 50px;
    padding: 0 10px;
    border: none; 								/* Remove the default border */
    background: white; 
    background: rgba(255,255,255,0.2);
    box-shadow: inset 0 0 10px rgba(255,255,255,0.5);
    font-family: 'Montserrat', sans-serif;
    text-indent: 10px;
    color: black;								/* Inner Color */
    text-shadow: 0 1px 2px rgba(0,0,0,0.3);
    font-size: 20px;       
}
 
.form-5 input[type=text] {
    border-bottom: 1px solid #fff; 
    border-bottom: 1px solid rgba(255,255,255,0.7);
    border-radius: 5px 0 0 0;
}
 
.form-5 input[type=password] {
    border-top: 1px solid #CCC; 
    border-top: 1px solid rgba(0,0,0,0.1);
    border-radius: 0 0 0 5px;
}
.form-5 input[type=text]:hover,
.form-5 input[type=password]:hover,
.form-5 input[type=text]:focus,
.form-5 input[type=password]:focus {
    background: #f7def7; /* Fallback */
    background: rgba(255,255,255,0.4);
    outline: none;
}
 
.form-5 input::-webkit-input-placeholder {
    color: #fff;
    text-shadow: 0 -1px 1px rgba(0,0,0,0.4);
    font-family: 'Handlee', cursive;
}
 
.form-5 input:-moz-placeholder {
    color: #fff;
    text-shadow: 0 -1px 1px rgba(0,0,0,0.4);
    font-family: 'Handlee', cursive;
}
 
.form-5 input:-ms-input-placeholder {
    color: #fff;
    text-shadow: 0 -1px 1px rgba(0,0,0,0.4);
    font-family: 'Handlee', cursive;
}

/* BUTTON */

.form-5 button {
    /* Size and position */
    width: 30%;
    height: 103px;
    float: right;
    position: relative;top:-119px;
    overflow: hidden;
 
    /* Styles */
    background-image: url('noise.png');
	background:-webkit-radial-gradient(center, ellipse cover, #ee4c8d 0%,#b53467 100%);
	background:-moz-radial-gradient(center, ellipse cover, #ee4c8d 0%,#b53467 100%);
    border-radius: 0 10px 10px 0;
    box-shadow:
        inset 0 0 4px rgba(255, 255, 255, 0.7), 
        inset 0 0 0 1px rgba(0, 0, 0, 0.2);
    border: none;
    border-left: 1px solid silver;
    cursor: pointer;  
    line-height: 102px; /* Same as height */
}

@-webkit-keyframes all{
	from{left:-15px;}
	to{left:0px;}
}
@-webkit-keyframes alll{
	from{opacity:1;}
	to{opacity:0;}
}
@-moz-keyframes all{
	from{left:-15px;}
	to{left:0px;}
}
@-moz-keyframes alll{
	from{opacity:1;}
	to{opacity:0;}
}

.form-5 button img {
	position:relative;top:30px;left:0px;
	width:50px;height:50px;
    opacity: 0;
    
}
 
.form-5 button span {
    display: block;
	position:relative; top:-50px;
    color: #8d1645;
    font-family: 'Montserrat', Arial, sans-serif; 
    font-size: 20px;
    text-shadow: 0 1px 0 rgba(255,255,255,0.4);
    transform: rotate(-90deg);
    transition: all 0.2s linear;
}

.form-5 button:focus {
    outline: none;
}
 
.form-5 button:hover span,
.form-5 button:focus span {
	left:0px;
    -webkit-animation: alll 0.2s ease-out;
	-webkit-animation-fill-mode: forwards;
    -moz-animation: alll 0.2s ease-out;
	-moz-animation-fill-mode: forwards;
}
 
.form-5 button:hover img,
.form-5 button:focus img {
    opacity: 0.5;
    left: 0;
    -webkit-animation: all 0.2s ease-out;
    -moz-animation: all 0.2s ease-out;
}
 
/* Click on button */
 
.form-5 button:active span,
.form-5 button:active img {
    transition: none; 
}
 
.form-5 button:active span {
    opacity: 0;
}
 
.form-5 button:active img {
    opacity: 0.5;
    left: 0px;
    
} 


</style>
<script>
function chk(){
	var id1=document.getElementsByClassName('login').item(0);//alert(id1.value);
	id1.value=id1.value.toLowerCase();//alert(id1.value);	
 }
</script>
</head>
<body>
<%@ page language="java" import="java.util.*,java.text.*,java.util.Date,java.sql.*, java.io.*" %>
<%
if(session.getAttribute("currentSessionUserId")!=null)
{
	
	String x=((String)session.getAttribute("currentSessionUserId")).substring(0,1);
	System.out.println(x);
	if(x.equals("m"))
	
	response.sendRedirect("http://172.16.2.2:8081/rosei/userLoggedcontractor.jsp");
	else if(x.equals("b"))
		
		response.sendRedirect("http://172.16.2.2:8081/rosei/userLoggedconsumer.jsp");
	else if(x.equals("a"))
		
		response.sendRedirect("http://172.16.2.2:8081/rosei/userLoggedconsumer.jsp");
	else if(x.equals("s"))
		
		response.sendRedirect("http://172.16.2.2:8081/rosei/userLoggedsecretary.jsp");
	else if(x.equals("r"))
		response.sendRedirect("http://172.16.2.2:8081/rosei/userLoggedadmin.jsp");
	else
	session.invalidate(); 
}
	
%>
<div id="topbox">
	<center>
		<p id="header11">ROSEI</p>
		<span id="header22"></span>
	</center>
</div>

<div id="one">

	<div id="formBox" style="width:400px;height:200px;position:relative;top:50px;left:500px;">

	<form id="login" class="form-5 clearfix" name="login" action="Servlet/LoginServlet" method="POST" enctype="application/x-www-form-urlencoded" onSubmit="chk()"> 
	 <!--  <form id="login" class="form-5 clearfix" action="timeout.jsp">-->
	<p>
				<input type="text" id="login" class="login" name="un" placeholder="UserID" />
				<input type="password" name="pw" id="password" placeholder="Password" /> 				
			</p>
				<button type="submit" name="submit" onsubmit="chk()">
					<img id="" src="Files/arow.png"/>
					<span>Sign in</span>
				</button>  
			   
		</form>
	</div>
	
	<!-- <span id="subline"><a href="##" style="font-family: 'Snowburst One', cursive;text-decoration:none;color:black;"></a> | <a href="#" style="font-family: 'Snowburst One', cursive;color:black;text-decoration:none;"></a></span>-->

</div>

<!--<div id="box">

</div>
-->

<div id="dummy">

	<center>
		<p style="font-family: 'Nova Square', serif;" >&#169 International Institute of Information Technology, Bhubaneswar</p>
	</center>
	
</div>
<!-- <marquee style="position:fixed;bottom:15%;right:25%;font-family:'Nova Square'">Contact for Help : +91-9439333314(Prayas) +91-8763490581(Amaya)</marquee>-->

<marquee style="position:fixed;bottom:10%;right:20%;font-family:'Nova Square'"><center>Contact for Help : +91-9439333314(Prayas) +91-8763490581(Amaya)</center><br><br>News : Roseighara-1/Roseighara-2 menus are updated</marquee>
<marquee scrollamount="3" scrolldelay="0" style="position:fixed;top:30%;right:20%;font-family:'Nova Square'" direction="down"><center>Book Your Coupon<br>on or before<br>THURSDAY 11:55 pm</marquee>
<div><a href="Ansh/AmulCool.html" target="_new tab" style="position:fixed;color:white;padding:20px;border-radius:5px;background:rgba(41,41,41,1);top:10px;right:10px;font-size:30px;">Play AmulCool!!!</a>
<div><a href="register.jsp" target="_new tab" style="position:fixed;color:white;padding:20px;border-radius:5px;background:rgba(41,41,41,1);top:10px;font-size:20px;"><center>Register for<br>IIIT SOFTWARE GROUP!!!</center></a>
</div>
</body>
</html>