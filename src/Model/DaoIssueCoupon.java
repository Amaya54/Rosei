package Model;
import java.text.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.*;



public class DaoIssueCoupon extends HttpServlet
{
   
   
	
   static int c=0;
   public  boolean issue(HttpServletRequest request, HttpServletResponse response,
		   String t,String bid,String sid,String dt,Connection currentCon ) {
	  
      boolean x=true;
      System.out.println(t+'\t'+bid+'\t'+sid+'\t'+dt);
      String q1 ="insert into prayas."+t+" values(?,?,?)";
     
      BeanIssueCoupon issue = new BeanIssueCoupon();
      
      c++;
      
      PreparedStatement ps=null;
	    
   // "System.out.println" prints in the console; Normally used to trace the process
   
   try 
   {
      //connect to DB
	  
      ps=currentCon.prepareStatement(q1);
      
      
      ps.setString(1,bid);
      
      ps.setString(2,sid);
      
      ps.setString(3,dt);
      x=ps.execute();
      System.out.println("In Dao in try");
      ps.close();
     
   if (!x) 
   {
	   
 	  return !x;
 	  
 	  
   } 
   else 
   {
	   response.sendRedirect("http://172.16.2.2:8081/rosei/notissued.jsp");
   	  
     
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
   return x;
}
   public  double getprice(String day,String pc,Connection currentCon)
   {
	double d=0;
	PreparedStatement stmt=null;
	String sql;
	
	
	sql="select "+pc+" from prayas.mealprice where day='"+day+"'";
    System.out.println("IN TRY "+day+pc);
    try{
    	
    stmt = currentCon.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
    System.out.println("In getprice"+pc+day);
	while(rs.next())
			{
	d=rs.getDouble(1);
	System.out.println(d);
			}
	
	rs.close();
}  catch (SQLException sqle) {
    System.out.println(sqle.getMessage());
} catch (Exception e) {
    System.out.println(e.getMessage());
} 
return d;
   }
   
   
   }
   

