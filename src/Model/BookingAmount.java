package Model;
import java.text.*;
import java.util.*;
import java.sql.*;

import javax.servlet.http.*;

public class BookingAmount {
	 Connection currentCon=null;
	public void book(HttpServletResponse response,String fd,double totalprice,String sid,String mid)
	{
		String sql="insert into prayas.bookingamount values (?,?,?,?)";
		boolean x;
	      PreparedStatement ps=null;
		    
	   // "System.out.println" prints in the console; Normally used to trace the process
	   
	   try 
	   {
	      //connect to DB 
		   ConnectionManager cm=new ConnectionManager();
	      currentCon = cm.getConnection();
	      ps=currentCon.prepareStatement(sql);
	      
	      
	      ps.setString(1,fd);
	      
	      ps.setString(2,sid);
	      
	      ps.setDouble(3,totalprice);
	      
	      ps.setString(4,mid);
	      x=ps.execute();
	      
	      ps.close();
	     
	   if (!x) 
	   {		  
		   response.sendRedirect("http://172.16.2.2:8081/rosei/processingissuecoupon.jsp"); 		   
		   
		   }
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
		            
		            
		        } catch (SQLException e) {}
		  
	 }
	   
	   }
		
	}


