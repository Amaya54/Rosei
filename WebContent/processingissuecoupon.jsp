<%@page import="Model.sendmail"%>
<%@page import="Model.ConnectionManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}

tr{background-color:lightgreen; text-align:center;}
td{background-color:#cff;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page language="java" import="java.util.*,java.text.*,java.util.Date,java.sql.*, java.io.*" %>
<%
    Connection con = null;
Statement stmt = null;
Statement stmt1 = null;
String messid=(String)session.getAttribute("messid");
String bid=(String)session.getAttribute("bid");
String stdid=(String)session.getAttribute("currentSessionUserId");
String acc=stdid+messid;
System.out.println("Account number"+acc);
double bprice=(Double) session.getAttribute("bprice");
double lprice=(Double) session.getAttribute("lprice");
double dprice=(Double) session.getAttribute("dprice");
System.out.println("BPRICE:"+bprice);
double totalprice=bprice+lprice+dprice;

	//UPDATE ACCOUNTS
	
	 try
			    {
		 Model.ConnectionManager cm=new Model.ConnectionManager();
		 con=cm.getConnection();
			 String sql,sql1;
			 sql="update prayas.account set available_money=(select available_money from account where account_no='"+acc+"')-"+totalprice+" where account_no='"+acc+"'";
			 
		     PreparedStatement ps = con.prepareStatement(sql);
			     
			   boolean x=false;
			  
			  x=ps.execute();
			   
			   ps.close();
			   
			   
			  } 
			    
			    catch(SQLException se){
			 	      //Handle errors for JDBC
			 	      se.printStackTrace();
			 	   }catch(Exception e){
			 	      //Handle errors for Class.forName
			 	      e.printStackTrace();
			 	   }
	 PreparedStatement ps=null;
	 boolean x=true;
	try{
		String sql2="insert into prayas.booking values(?,?,?,?,?,?)";
		
		ps=con.prepareStatement(sql2);
		ps.setString(1,bid);
		ps.setString(2,stdid);
		ps.setString(3,acc);
		ps.setDouble(4,totalprice);
		ps.setInt(5,0);
		ps.setString(6,messid);
		
		
		x=ps.execute();
	}

catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally {
	        try {
	            
	            if(ps != null)
	                ps.close();
	            
	            if(con != null)
	                con.close();
	        } catch (SQLException e) {}
	        if(!x)
	        	//sendmail.sendissue(bid,stdid,messid,bprice,lprice,dprice,totalprice);
				   response.sendRedirect("http://172.16.2.2:8081/rosei/confirmedbooking.jsp");
	  
	   }
	

%>
<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/invalidLogin.jsp"); //error page
		}%> 
</body>
</html>