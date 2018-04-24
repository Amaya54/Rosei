<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}body{font-family:'Nova Square';color:white;}</style>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>
<body><br><br><br>
<center><h1>PLEASE SELECT A MESS</h1>
<br>
<br>
<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}

session.setAttribute("issuecheck",0);
%>
<%
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date date = new Date();
String dt=dateFormat.format(date);
SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
Date fdt=format.parse(dt);
DateFormat format0=new SimpleDateFormat("EEE"); 
String fday=format0.format(fdt);
System.out.println("day "+fday);

if(fday.equals("Fri") || fday.equals("Sat") ||fday.equals("Sun"))
{
	response.sendRedirect("http://172.16.2.2:8081/rosei/timeout.jsp"); //error page*/
}
		%> 
  <form action="issuecoupon.jsp" method="get">
  <!-- <form action="timeout.jsp" method="get">-->
<select name="mess">





<%@ page language="java" import="java.util.*,java.text.*,java.util.Date,java.sql.*, java.io.*" %>
<%
    Connection con = null;
Model.ConnectionManager cm=new Model.ConnectionManager();

con = cm.getConnection();

	
	
	
    Statement stmt=null;
	String sql;
	try
	{
    sql="select id,name from prayas.login where clientid='contractor'";
    stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
       

    while ( rs.next() ) {
       out.println("<option value="+rs.getString(1)+">"+rs.getString(2)+"</option>");
       
   	
   	session.setAttribute("messid",rs.getString(1));
   	session.setAttribute("messname",rs.getString(2));
    }
    rs.close();
} catch (IOException ioe) {
    out.println(ioe.getMessage());
} catch (SQLException sqle) {
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
 </select>   
<input type="submit" value="Submit"/>

</form>
<!--Opened only for You....Make your booking soon..-->
</center>
</body>
</html>