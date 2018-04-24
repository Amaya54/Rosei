<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mess Contracter Booking Derails</title>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}body{font-family:'Nova Square';color:white;}

#Coupon{position:absolute; font-size:23px; colo:rgb(183,132,13); box-shadow:0px 3px 10px rgb(0,50,0); top:20px; left:0px; min-height:400px; min-width:600px; height:65%; width:55%; borde:1px solid black;z-index:3;}
#Coupon tr td{borde:1px solid black; height:100px; left:35px;}
#Coupon tr th{border:1px solid black; height:80px; left:35px; background:rgba(65,170,7,0.5);}
#Coupon tr td div{position:relative; left:20px; float:left; height:50px; font-size:42px; width:100px; box-shadow:0px 0px 10px black; text-align:center; padding:32px; background:rgba(65,170,7,0.5); border:1px solid black; z-index:10;}

</style>
<title>Insert title here</title>
</head>
<body>
<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%> 
<%@ page language="java" import="java.util.*,java.text.*,java.util.Date,java.sql.*, java.io.*" %>
<%
    Connection con = null;
Statement stmt1 = null;
Statement stmt2 = null;
Statement stmt3 = null;
Statement stmt4 = null;
Statement stmt5 = null;
Statement stmt6 = null;

String dt=request.getParameter("dt");

	try
   {
		Model.ConnectionManager cm=new Model.ConnectionManager();
       con=cm.getConnection();
  
        String sql1=null;
		 String sql2=null;
		  String sql3=null;
		   String sql4=null;
		    String sql5=null;
			 String sql6=null;
			 String yr=dt.substring(2,4);
			 String mon=dt.substring(5,7);
			 String i=((String)session.getAttribute("currentSessionUserId")).substring(3,4);
			 String v=i+mon+yr;
       sql1="select count(*) from prayas.B"+v+"V where date='"+dt+"'";
	   sql2="select count(*) from prayas.B"+v+"N where date='"+dt+"'";
	   sql3="select count(*) from prayas.L"+v+"V where date='"+dt+"'";
	   sql4="select count(*) from prayas.L"+v+"N where date='"+dt+"'";
	   sql5="select count(*) from prayas.D"+v+"V where date='"+dt+"'";
	   sql6="select count(*) from prayas.D"+v+"N where date='"+dt+"'";
	   
        //ps.setString(1,t3);
        stmt1 = con.createStatement();
		stmt2 = con.createStatement();
		stmt3 = con.createStatement();
		stmt4 = con.createStatement();
		stmt5 = con.createStatement();
		stmt6 = con.createStatement();
		
        ResultSet rs1 = stmt1.executeQuery(sql1);
		ResultSet rs2= stmt2.executeQuery(sql2);
		ResultSet rs3= stmt3.executeQuery(sql3);
		ResultSet rs4= stmt4.executeQuery(sql4);
		ResultSet rs5= stmt5.executeQuery(sql5);
		ResultSet rs6= stmt6.executeQuery(sql6);
		
		int bv=0;
		int bn=0;
		int lv=0;
		int ln=0;
		int dv=0;
		int dn=0;
		
       
	   while(rs1.next())
	   {
	   bv=rs1.getInt(1);
	   }
	    while(rs2.next())
	   {
	   bn=rs2.getInt(1);
	   }
	    while(rs3.next())
	   {
	   lv=rs3.getInt(1);
	   }
	    while(rs4.next())
	   {
	   ln=rs4.getInt(1);
	   }
	    while(rs5.next())
	   {
	   dv=rs5.getInt(1);
	   }
	    while(rs6.next())
	   {
	   dn=rs6.getInt(1);
	   }
         
        
        rs1.close();
		rs2.close();
		rs3.close();
		rs4.close();
		rs5.close();
		rs6.close();

%>
<table id="Coupon" ><!--table contains our selection for meal-->
		<tr><!--first row-->
			<th width="100px">Type</th>
			<th width="150px">Breakfast</th>
			<th width="150px">Lunch</th>
			<th width="150px">Dinner</th>
		</tr>
		<tr><!--second row-->
			<th>Veg</th><!--Naming od ids is <mess1 or mess2><breakfast or lunch or dinner><date column sl no>-->
			<td>
				<div id="mess1b1"><%out.println(bv);%></div>
			</td>
			<td align="center">
				<div id="mess1l1"><%out.println(lv);%></div>
			</td>
			<td align="center">
				<div id="mess1d1"><%out.println(dv);%></div>
			</td>
		</tr>
		<tr><!--third row-->	
			<th>Non-Veg</th>
			<td>
				<div id="mess1b2"><%out.println(bn);%></div>
			</td>
			<td align="center">
				<div id="mess1l2"><%out.println(ln);%></div>
			</td>
			<td align="center">
				<div id="mess1d2"><%out.println(dn);%></div>
			</td>
		</tr>
	</table>
<%
}
	
	catch (IOException ioe) {
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
</body>
</html>