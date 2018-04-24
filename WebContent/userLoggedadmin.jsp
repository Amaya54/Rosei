
<html>
<head>
<title>Mess Contracter Homepage</title>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<script src="Files/test1.js">

</script>
<link rel="stylesheet" type="text/css" href="Files/test1.css"/>
<style>@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}</style>
</head>

<body>



		
<%@ page language="java" import="java.util.*,java.text.*,java.util.Date,java.sql.*, java.io.*" %>
<%

String x=((String)session.getAttribute("currentSessionUserId")).substring(0,1);

  if(session.getAttribute("currentSessionUserId")==null || !x.equals("r"))
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%> 
		<%
    Connection con = null;
		Model.ConnectionManager cm =new Model.ConnectionManager();
	con = cm.getConnection();

	
	String id=null;
	
    PreparedStatement ps=null;
    PreparedStatement ps1=null;
	String sql=null;
	String sql1=null;
	String mid=null;
	String acc=null;
	int total=0;
	sql="select * from prayas.account";
	int size=0;
	int amt=0;
    try{
    ps = con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    
	while(rs.next())
	{
		
		mid=rs.getString(1).substring(7,11);
		System.out.println(mid);
		String cid=(String)session.getAttribute("currentSessionUserId");
		System.out.println(cid);
		if(mid.equals(cid))
		{
			total=total+rs.getInt(2);
			System.out.println(total);
		}
		
		size++;
	}
	
      
     
       rs.close();
       
}  catch (SQLException sqle) {
    out.println(sqle.getMessage());
} catch (Exception e) {
    out.println(e.getMessage());
} finally {
    try {
        if ( con != null ) {
            con.close();
        }
    } catch (SQLException sqle) {
        out.println(sqle.getMessage());
    }
}

	
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
		<li id="l1" onclick="move(this)"><a href="createuser.jsp" target="frame1">Create User</a></li>
		<li id="l2" onclick="move(this)"><a href="delete.jsp" target="frame2">Change User Password</a></li>
		<li id="l3" onclick="move(this)"><a href="comingsoon.jsp" target="frame3">Modify roles</a></li>
		<li id="l4" onclick="move(this)"><a href="comingsoon.jsp" target="frame4">Extras</a></li>
		<li id="l5" onclick="move(this)"><a href="printcoupon.jsp" target="frame5">Print Coupon</a></li>
		</ul>
	</nav>
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
		
		
</div>




<div id="one"></div>








</body>
</html>