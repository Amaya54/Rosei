import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public void delete(HttpServletRequest request, HttpServletResponse response,
		   String t,String bid,String sid) {
	  
      boolean x=true;
      
      String q1 ="delete from prayas."+t+" where student_id='"+sid+"' and booking_id='"+bid+"'";               
     PreparedStatement ps=null;
	    
   // "System.out.println" prints in the console; Normally used to trace the process
   
   try 
   {
      //connect to DB 
	   
      ps=currentCon.prepareStatement(q1);
      x=ps.execute();
      System.out.println("In Dao in try");
      ps.close();
        
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