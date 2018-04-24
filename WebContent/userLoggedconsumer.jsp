<%@ page import="java.util.*,javax.servlet.http.HttpSession,java.sql.*,Model.viewMenu" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Files/test1.css">
<script src="Files/test1.js" type="text/javascript"></script>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<script>var flag=0;
function up(){if(flag==0){var id1=document.getElementById('menu');id1.style.webkitAnimation="";id1.id="menu1";var id2=document.getElementById('menu-table');id2.style.webkitAnimation="";id2.id="menu-table1"; flag=1;}
else if(flag==1){var id1=document.getElementById('menu1');id1.id="menu";id1.style.webkitAnimation="footer-head1 0.8s ease-out";var id2=document.getElementById('menu-table1');id2.id="menu-table";id2.style.webkitAnimation="footer1 0.8s ease-out"; flag=0;}
}
</script>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}
</style>
</head>

<body  onclick="close2()">
<%

if(session.getAttribute("currentSessionUserId")==null)
{
	response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp");
	}
Model.viewMenu vm=new Model.viewMenu();
%>
<div id="wrappup">

<div id="frames">
		<div id="move">
			<iframe id="frame1" src="initial.html" class="frame"></iframe>
			<iframe id="frame2" class="frame"></iframe>
			<iframe id="frame3" class="frame"></iframe>
			<iframe id="frame4" class="frame"></iframe>
			<iframe id="frame5" class="frame"></iframe>
			<iframe id="frame6" class="frame"></iframe>
		</div>
		
	</div>
<div id="topbox">
	
	<nav id="header11">
		<ul>
			<!--<li>Welcome User</li>-->
			<li id="l1" onclick="move(this)"><a href="selectmess.jsp" target="frame1">Issue Coupon</a></li>
			<li id="l2" onclick="move(this)"><a href="studentrecharge.jsp" target="frame2">Recharges</a></li>
			<li id="l3" onclick="move(this)"><a href="studentbookingdetail.jsp" target="frame3">Booking History</a></li>
			<li id="l4" onclick="move(this)"><a href="comingsoon.jsp" target="frame4">Special Order</a></li>
			<li id="l5" onclick="move(this)"><a href="viewcoupon.jsp" target="frame5">View Coupon</a></li>
		</ul>
	</nav>
	
	<%@ page language="java" import="java.util.*,java.text.*,java.util.Date,java.sql.*, java.io.*" %>
<%
  Connection con = null;
	Model.ConnectionManager cm=new Model.ConnectionManager();
	con =cm.getConnection();
	%>
	
  
	
	<div style="position:absolute;top:17px;letter-spacing:2px;font-family:Open Sans Condensed;color:white;font-size:23px;cursor:pointer;left:40px;">
	<nav id="Username">
	<ul>
		<li><a href="#">Hi, <%=session.getAttribute("currentSessionUsername")%>!</a>
			<ul>
				<li><a href="accountSettings.jsp">Account Settings</a></li>
				<li><a href="#">Help</a></li>
				<li><a href="signout.jsp">Log-Out</a></li>
			</ul>
		</li>
	</ul>
</nav>

	</div>
		
		<!--<span id="header22">Our own Mess Management System</span>-->
</div>




<div id="one"></div>
<!--<div id="box">

</div>
-->

<!--<div id="dummy">

	<center>
		<p style="font-family: 'Nova Square', serif;" >IIIT Bhubaneswar Copyright 2013</p>
	</center>
	
	
</div>-->

	
	
	<!--<div style="position:fixed;height:100%;width:100%;"></div>-->
	<div style="position:absolute; top:400px; left:50px; background:black;">
		<div id="menu"  onmouseover="open1(this)"><p style="position:relative;top:-23px;left:-15px;z-index:8;">Menu</p><div id="arrow01" class="arrow"></div><div id="arrow02" class="arrow"></div></div>
		<div id="mess1" onmouseover="open2(this,40,78,0)"  onmouseou="check(this)"><p style="position:relative;top:-23px;left:-17px;z-index:8;">Mess1</p><div id="arrow1" class="arrow"></div></div>
		<div id="mess2" onmouseover="open2(this,40,78,0)"  onmouseou="check(this)"><p style="position:relative;top:-23px;left:-17px;z-index:8;">Mess2</p><div id="arrow2" class="arrow"></div></div>
		<div id="table1" class="table" onmouseover="javascript:openFlag=openFlag+1">
			<table onmouseou="close2()">
				<tr>
					<th>Day/Meal</th>
					<th>Breakfast</th>
					<th>Lunch</th>
					<th>Dinner</th>
				</tr>
				<tr>
					<th>Mon</th>
					<td><%out.println(vm.menu("mon","bf","m001",con));%></td>
					<td><%out.println(vm.menu("mon","lun","m001",con));%></td>
					<td><%out.println(vm.menu("mon","din","m001",con));%></td>
				</tr>				
				<tr>
					<th>Tue</th>
					<td><%out.println(vm.menu("tue","bf","m001",con));%></td>
					<td><%out.println(vm.menu("tue","lun","m001",con));%></td>
					<td><%out.println(vm.menu("tue","din","m001",con));%></td>
				</tr>
				<tr>
					<th>Wed</th>
					<td><%out.println(vm.menu("wed","bf","m001",con));%></td>
					<td><%out.println(vm.menu("wed","lun","m001",con));%></td>
					<td><%out.println(vm.menu("wed","din","m001",con));%></td>
				</tr>
				<tr>
					<th>Thu</th>
					<td><%out.println(vm.menu("thu","bf","m001",con));%></td>
					<td><%out.println(vm.menu("thu","lun","m001",con));%></td>
					<td><%out.println(vm.menu("thu","din","m001",con));%></td>
				</tr>
				<tr>
					<th>Fri</th>
					<td><%out.println(vm.menu("fri","bf","m001",con));%></td>
					<td><%out.println(vm.menu("fri","lun","m001",con));%></td>
					<td><%out.println(vm.menu("fri","din","m001",con));%></td>
				</tr>
				<tr>
					<th>Sat</th>
					<td><%out.println(vm.menu("sat","bf","m001",con));%></td>
					<td><%out.println(vm.menu("sat","lun","m001",con));%></td>
					<td><%out.println(vm.menu("sat","din","m001",con));%></td>
				</tr>
				<tr>
					<th>Sun</th>
					<td><%out.println(vm.menu("sun","bf","m001",con));%></td>
					<td><%out.println(vm.menu("sun","lun","m001",con));%></td>
					<td><%out.println(vm.menu("sun","din","m001",con));%></td>
				</tr>
			</table>
		</div>
		<div id="table2" class="table">
			<table>
				<tr>
					<th>Day/Meal</th>
					<th>Breakfast</th>
					<th>Lunch</th>
					<th>Dinner</th>
				</tr>
				<tr>
					<th>Mon</th>
					<td><%out.println(vm.menu("mon","bf","m002",con));%></td>
					<td><%out.println(vm.menu("mon","lun","m002",con));%></td>
					<td><%out.println(vm.menu("mon","din","m002",con));%></td>
				</tr>				
				<tr>
					<th>Tue</th>
					<td><%out.println(vm.menu("tue","bf","m002",con));%></td>
					<td><%out.println(vm.menu("tue","lun","m002",con));%></td>
					<td><%out.println(vm.menu("tue","din","m002",con));%></td>
				</tr>
				<tr>
					<th>Wed</th>
					<td><%out.println(vm.menu("wed","bf","m002",con));%></td>
					<td><%out.println(vm.menu("wed","lun","m002",con));%></td>
					<td><%out.println(vm.menu("wed","din","m002",con));%></td>
				</tr>
				<tr>
					<th>Thu</th>
					<td><%out.println(vm.menu("thu","bf","m002",con));%></td>
					<td><%out.println(vm.menu("thu","lun","m002",con));%></td>
					<td><%out.println(vm.menu("thu","din","m002",con));%></td>
				</tr>
				<tr>
					<th>Fri</th>
					<td><%out.println(vm.menu("fri","bf","m002",con));%></td>
					<td><%out.println(vm.menu("fri","lun","m002",con));%></td>
					<td><%out.println(vm.menu("fri","din","m002",con));%></td>
				</tr>
				<tr>
					<th>Sat</th>
					<td><%out.println(vm.menu("sat","bf","m002",con));%></td>
					<td><%out.println(vm.menu("sat","lun","m002",con));%></td>
					<td><%out.println(vm.menu("sat","din","m002",con));%></td>
				</tr>
				<tr>
					<th>Sun</th>
					<td><%out.println(vm.menu("sun","bf","m002",con));%></td>
					<td><%out.println(vm.menu("sun","lun","m002",con));%></td>
					<td><%out.println(vm.menu("sun","din","m002",con));%></td>
				</tr>
					
			</table>
		</div>
	</div>
<%

String id=null;
id=(String)session.getAttribute("currentSessionUserId");
String mess[]=new String[9];
String messname[]=new String[9];
double messamt[]=new double[9];
PreparedStatement ps=null,stmt=null;
PreparedStatement ps1=null;
String sql=null;
String sql1=null;
String acc=null;
int amt=0;
int size=0;
sql="select id,name from prayas.login where clientid='contractor'";


try{
ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
while(rs.next())
{
	mess[size]=id+rs.getString(1);
	messname[size]=rs.getString(2);
	System.out.println(mess[size]);
	size++;
}
ResultSet rs1=null,rs2=null;
	
		for(int i=0;i<size;i++)
		{
		//amy sql1="select available_money from prayas.account where account_no='"+mess[i]+"'";
		
		//amy ps1 = con.prepareStatement(sql1);
		//amy rs1= ps1.executeQuery();
		//amy rs1.next();
		//amy messamt[i]=rs1.getInt(1);
		
		sql1="select from_date from prayas.createcoupon where messid='"+mess[i].substring(7,11)+"' order by from_date asc";
		ps1 = con.prepareStatement(sql1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    rs1 = ps1.executeQuery();
		rs1.last();
		
		sql="select amount from prayas.bookingamount where student_id='"+id+"' and messid='"+mess[i].substring(7,11)+"' and from_date='"+rs1.getString(1)+"'";
		
		stmt = con.prepareStatement(sql);
		rs2 = stmt.executeQuery();
		while(rs2.next())
		{
			messamt[i]=messamt[i]+rs2.getDouble(1);
		}
	
		}
		session.setAttribute("amtm001", messamt[0]);
		session.setAttribute("amtm002", messamt[1]);


 rs.close();
 rs1.close();
 rs2.close();
}  catch (SQLException sqle) {
out.println(sqle.getMessage());
} catch (Exception e) {
out.println(e.getMessage());
} 
finally {
  try {
      if ( con != null ) {
          con.close();
      }
      
  } catch (SQLException sqle) {
      out.println(sqle.getMessage());
  }
}

	
%>	

	
	

	


<div id="cash" style="position:fixed;right:120px;font-size:120%;padding:2px;height:300px;box-shadow:-10px 2px 4px black;border:1px solid black;">
<img src="Files/cart.png" id="card" style="position:fixed;top:110px;right:190px;"/>
<p style="position:relative;top:30px;"><%out.println(messname[0]); %><br>Due Amount<br>
&#x20B9;<%out.println(messamt[0]); %></p>
<hr style="position:relative;top:30px;width:110px;">
<p style="position:relative;top:30px;"><%out.println(messname[1]); %><br>Due Amount<br>
&#x20B9;<%out.println(messamt[1]); %></p>
<hr style="position:relative;top:30px;width:110px;">
<p style="position:relative;top:30px;">Total &#x20B9;<%out.println(messamt[1]+messamt[0]); %></p>
</div>


</body>
</html>