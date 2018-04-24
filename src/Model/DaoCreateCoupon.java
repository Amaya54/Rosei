package Model;
import java.text.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.*;



public class DaoCreateCoupon extends HttpServlet
{
   Connection currentCon = null;
   
	
	
   public  BeanCreateCoupon create(BeanCreateCoupon coupon,HttpServletRequest request, HttpServletResponse response) {
	
      
      
      String q1 ="insert into createcoupon values(?,?,?,?,?,?)";
      
      PreparedStatement ps=null;
	    
   // "System.out.println" prints in the console; Normally used to trace the process
   
   try 
   {
      //connect to DB
	   ConnectionManager cm=new ConnectionManager();
      currentCon = cm.getConnection();
      ps=currentCon.prepareStatement(q1);
      System.out.println("From Date"+coupon.getFdate());
      System.out.println("From Day"+coupon.getFday());
      System.out.println("To Date"+coupon.getTdate());
      System.out.println("To Day"+coupon.getTday());
      
      ps.setString(1, coupon.getDate());
      
      ps.setString(2, coupon.getFdate());
      
      ps.setString(3, coupon.getFday());
      
      ps.setString(4, coupon.getTdate());
      
      ps.setString(5, coupon.getTday());
      HttpSession session = request.getSession(true);
      String id=(String)session.getAttribute("currentSessionUserId");
      ps.setString(6,id );
      System.out.println("hii u r here" +id);
      boolean x=ps.execute(); 
      ps.close();
     
   if (!x) 
   {
 	  
 	  coupon.setValid(true);
 	  
      System.out.print("Coupons Created");
 	  
   } 
	        
   //if user exists set the isValid variable to true
   else 
   {
   	  System.out.print("User Not Created");
   	  
    
   coupon.setValid(false);
      
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
	            
	            if(currentCon != null)
	                currentCon.close();
	        } catch (SQLException e) {}
	  
 }
   return coupon;
}
}
   

