package Model;
import java.text.*;
import java.util.*;
import java.sql.*;

import javax.servlet.http.*;



public class DaoviewBookingDetail extends HttpServlet
{
   Connection currentCon1 = null;
   
	
	
   public BeanviewBookingDetail create(BeanviewBookingDetail br,HttpServletRequest request, HttpServletResponse response) {
	   System.out.println("inside create");
	   PreparedStatement stmt=null,stmt1=null;

	   String t1=br.getTable1();
	   String t2=br.getTable2();
	   String sid=br.getStudentId();
      HttpSession session = request.getSession(true);
      ArrayList<String> date1=new ArrayList<String>();
      ArrayList<String> date2=new ArrayList<String>();
      
      try
      {
      ResultSet rs1,rs2;
      ConnectionManager cm=new ConnectionManager();
      currentCon1=cm.getConnection1();
      System.out.println(t1);
      String sql1="select Date from prayas."+t1+" where student_id='"+sid+"'";
      stmt=currentCon1.prepareStatement(sql1);
      rs1=stmt.executeQuery();
      while(rs1.next()){
  		date1.add(rs1.getString(1));
  		System.out.println("hello;"+rs1.getString(1));
  	 }
      br.setDate1(date1);
      
      String sql2="select Date from prayas."+t2+" where student_id='"+sid+"'";
      stmt1=currentCon1.prepareStatement(sql2);
      rs2=stmt1.executeQuery();
      while(rs2.next()){
    		date2.add(rs2.getString(1));
    		
    	 }
      
      br.setDate2(date2);
      br.setValid(true);
     System.out.println("after resultset");
   
   }
   catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally {
	        try {
	            
	           
	            
	            if(currentCon1 != null)
	                currentCon1.close();
	           
	        } catch (SQLException e) {}
	  
 }
   return br;
}
}

