<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HOMEPAGE</title>
<style>
* {
  margin: 0;
  padding: 0;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  position:relative;
  top:4%;
  
}
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}
body
{
	background:rgb(133,113,88);
}

}
ul {
  list-style: none;
}
input {
  position: absolute;
  
  top: -9999px;
  left: -9999px;
}
label {
 display: block;
  float: left;
  height: 90%;
  width: 5%;
  margin-bottom: 10px;
  //overflow: hidden;
 
  background: #999;
  text-align: center;
  font: 14px/50px Helvetica, Verdana, sans-serif;  
 
  -webkit-transition: width 1s ease, background 0.5s ease;
     -moz-transition: width 1s ease, background 0.5s ease;
       -o-transition: width 1s ease, background 0.5s ease;
      -ms-transition: width 1s ease, background 0.5s ease;
          transition: width 1s ease, background 0.5s ease;
}
#rad2 + label {
  background: #888;
  -webkit-transition: width 1s ease, background 0.5s ease;
     -moz-transition: width 1s ease, background 0.5s ease;
       -o-transition: width 1s ease, background 0.5s ease;
      -ms-transition: width 1s ease, background 0.5s ease;
          transition: width 1s ease, background 0.5s ease;
		  height:90%;
		  
}
 
label:hover, #rad2 + label:hover {
  background: #232323;
  color: #fff;
  cursor: pointer;
}
.accslide {
  display: block;height: 50%;
  width: 0%;
  padding: 10px 0;
  float: left;
  overflow: hidden;
 
  color: #333;
  background: #fff;
  font: 12px/1.5 Helvetica, Verdana, sans-serif;
   
  -webkit-transition: all 1s ease;
     -moz-transition: all 1s ease;
       -o-transition: all 1s ease;
      -ms-transition: all 1s ease;
          transition: all 1s ease;
}
 
.accslide p, h2, img {
  width:420px;
  height:10%;
  padding-left: 10px;
 }
.accslide img {
  margin-top: 10px;
  
}
input[type="radio"]:checked ~ .accslide {
  width: 60%;
  height:90%;
  
}
#rad4 + label {
  background: #888;
  -webkit-transition: width 1s ease, background 0.5s ease;
     -moz-transition: width 1s ease, background 0.5s ease;
       -o-transition: width 1s ease, background 0.5s ease;
      -ms-transition: width 1s ease, background 0.5s ease;
          transition: width 1s ease, background 0.5s ease;
		  height:90%;
		  
}

#rad6 + label {
  background: #888;
  -webkit-transition: width 1s ease, background 0.5s ease;
     -moz-transition: width 1s ease, background 0.5s ease;
       -o-transition: width 1s ease, background 0.5s ease;
      -ms-transition: width 1s ease, background 0.5s ease;
          transition: width 1s ease, background 0.5s ease;
		  height:90%;
		  position:relative;
		  top:0%;
		  
}
label:hover, #rad4 + label:hover {
  background: #232323;
  color: #fff;
  cursor: pointer;}
label:hover, #rad6 + label:hover {
  background: #232323;
  color: #fff;
  cursor: pointer;}
#titlebar
{
	position:fixed;
	top:0%;
	height:7%;
	width:100%;
	background:black;
	color:yellow;
	font-size:1.5em;
}
#welcome
{
	position:absolute;
	right:1%;
	font-size:0.8em;
}
</style>
</head>
<body>
<form style="posit">
  <ul>
    <li>
      <input id="rad1" type="radio" name="rad">
      <label for="rad1"><b>
	  <p>I</p>
	  <p>S</p>
	  <p>S</p>
	  <p>U</p>
	  <p>E</p></b>
	  </label>
      <div class="accslide">
        <h2>COUPON ISSUE</h2>
        <p>Take Your Token For The Food For Life</p>
        <iframe src="Files/BodyIssue.html" style="position:relative;height:71%; width:100%;"></iframe>
      </div>
    </li>
    <li>
      <input id="rad2" type="radio" name="rad">
      <label for="rad2"><b>
	  <p>C</p>
	  <p>A</p>
	  <p>N</p>
	  <p>C</p>
	  <p>E</p>
	  <p>L</p></b>
	  </label>
      <div class="accslide">
        <h2>COUPON CANCEL</h2>
        <p>The Way To Your Freedom</p>
        <iframe src="" style="position:relative;height:71%; width:100%;"></iframe>
      </div>
    </li>
    <li>
      <input id="rad3" type="radio" name="rad">
      <label for="rad3"><b>
	  <p>M</p>
	  <p>Y</p>
	  <p></p>
	  <p>B</p>
	  <p>I</p>
	  <p>L</p>
	  <p>L</p>
	  </b>
	    </label>
      <div class="accslide">
        <h2>MY BILL</h2>
        <p>Preview Your Monthly Expenditure</p>
        <iframe src="Files/billing.html" style="position:relative;height:71%; width:100%;"></iframe>
      </div>
    </li>
    
<li>
      <input id="rad4" type="radio" name="rad">
      <label for="rad4">
	  <b><p>M</p>
	  <p>E</p>
	  <p>N</p>
	  <p>U</p></b>
	  </label>
      <div class="accslide">
        <h2>MY MENU</h2>
        <p>Take A Look At Our Specialities</p>
        <iframe src="Files/menu.html" style="position:relative;height:71%; width:100%;"></iframe>
      </div>
    </li>
    
<li>
      <input id="rad5" type="radio" name="rad">
      <label for="rad5"><b>
	  <p>A</p>
	  <p>C</p>
	  <p>C</p>
	  <p>O</p>
	  <p>U</p>
	  <p>N</p>
	  <p>T</p></b>
	  </label>
      <div class="accslide">
        <h2>MY ACCOUNT</h2>
        <p>Its You</p>
        <iframe src="Files/edit_acc.html" style="position:relative;height:71%; width:100%;"></iframe>
      </div>
    </li>
<li>
      <input id="rad6" type="radio" name="rad">
      <label for="rad6">
	  <b><p>N</p>
	  <p>O</p>
	  <p>T</p>
	  <p>I</p>
	  <p>C</p>
	  <p>E</p>
	  <p>S</p></b>
	  </label>
      <div class="accslide">
        <h2>MY NOTICES</h2>
        <p>View The New Trends</p>
        <iframe src="Files/notice.html" style="position:relative;height:71%; width:100%;"></iframe>
      </div>
    </li>
	<li>
      <input id="rad7" type="radio" name="rad">
      <label for="rad7">
	  <b><p>U</p>
	  <p>P</p>
	  <p>D</p>
	  <p>A</p>
	  <p>T</p>
	  <p>E</p>
	  <p>S</p></b>
	  </label>
      <div class="accslide">
        <h2>MENU UPDATES</h2>
        <p>Setting Foot For The Changing Trends</p>
        <iframe src="Files/messupdate.html" style="position:relative;height:71%; width:100%;"></iframe>
      </div>
    </li>
    </ul>  	 	
</form> 
<div id="titlebar">ROSEII
<p style="position:fixed; top:3%; font-size:0.8em color:white;">The Mess Management System Of IIIT Bhubaneswar</p>
<div id="welcome">
WELCOME USER
</div>
</div>
</body>
</html>