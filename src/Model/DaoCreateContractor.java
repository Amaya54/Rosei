package Model;
import java.text.*;
import java.util.*;
import java.sql.*;

public class DaoCreateContractor 	
{
   Connection currentCon = null;
   
	
	
   public  BeanCreateUser create(BeanCreateUser bean) {
	
      
      String q1 ="insert into consumer values(?,?,?,?,?,?)";
      String q2 ="insert into login values(?,?,?,?,?)";
       
       
       
      PreparedStatement ps=null;
      PreparedStatement ps1=null;
      
     
      
       
   
   try 
   {
      //connect to DB
	   ConnectionManager cm=new ConnectionManager();
      currentCon = cm.getConnection();
      ps=currentCon.prepareStatement(q1);
      ps1=currentCon.prepareStatement(q2);
      
      
      ps.setString(1, bean.getUserid());
      
      ps.setString(2, null);
      
      ps.setString(3, bean.getName());
      
      ps.setString(4, bean.getAddress());
      
      ps.setString(5, bean.getGender());
      
      ps.setString(6, bean.getContact());
      
      
      ps1.setString(1, bean.getUserid());
      System.out.println(bean.getUserid());
      ps1.setString(2, bean.getName());
      
      ps1.setInt(3, bean.getSalt());
      
      ps1.setInt(4, bean.getHash());
      
      ps1.setString(5, bean.getClient());
      System.out.println(bean.getClient());
     
      
      boolean x=ps.execute(); 
      ps.close();
      boolean x1=ps1.execute();
     
            
   if (!x1 && !x ) 
   {
 	  
 	  bean.setValid(true);
 	  
      System.out.print("User Created");
 	  
   } 
	        
   //if user exists set the isValid variable to true
   else 
   {
   	  System.out.print("User Not Created");
   	  
    
   bean.setValid(false);
      
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
	            if(ps1 != null)
	                ps1.close();
	                       if(currentCon != null)
	                currentCon.close();
	        } catch (SQLException e) {}
	  
 }
   return bean;
}
}
   

