package LoginPackage;
import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDAO 	
{
   Connection currentCon = null;
    ResultSet rs = null;  
	
	
	
   public UserBean login(UserBean bean) {
	
      //preparing some objects for connection 
      Statement stmt = null;    
	
      String username = bean.getUserid();    
      
      
      String searchQuery =
            "select * from prayas.login where id='"
                     + username
                     
                     + "'";
                     
	    
   // "System.out.println" prints in the console; Normally used to trace the process
   System.out.println("Your user name is " + username);          
  
   System.out.println("Query: "+searchQuery);
	    
   try 
   {
      //connect to DB
	   ConnectionManager  cm=new ConnectionManager();
      currentCon = cm.getConnection();
      stmt=currentCon.createStatement();
      rs = stmt.executeQuery(searchQuery);	        
      boolean more = rs.next();
	       
      // if user does not exist set the isValid variable to false
      if (!more) 
      {
         System.out.println("Sorry, you are not a registered user! Please sign up first");
        
      } 
	        
      //if user exists set the isValid variable to true
      else if (more) 
      {
         String name = rs.getString("NAME");
        
	     String id=rs.getString("ID");	
	     String usid=rs.getString("CLIENTID");	
         System.out.println("Welcome " + name);
         bean.setName(name);
        
         bean.setusId(usid);
         
        
      }
   } 

   catch (Exception ex) 
   {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
   } 
	    
   //some exception handling
   finally 
   {
      if (rs == null)	{
         try {
            rs.close();
         } catch (Exception e) {}
           
         }
	
      if (stmt != null) {
         try {
            stmt.close();
         } catch (Exception e) {}
            stmt = null;
         }
	
      if (currentCon != null) {
         try {
            currentCon.close();
         } catch (Exception e) {
         }

         currentCon = null;
      }
   }

return bean;
	
   }
   public int getSalt(UserBean bean)
   {
	   int salt=0;
	   Statement stmt = null; 
	   String userid = bean.getUserid(); 
	   String searchQuery =
	            "select salt from prayas.login where id ='"
	                     + userid
	                     + "'";
	                     
	   try 
	   {
	      //connect to DB 
		   ConnectionManager  cm=new ConnectionManager();
		      currentCon = cm.getConnection();
	      stmt=currentCon.createStatement();
	      rs = stmt.executeQuery(searchQuery);	        
	      boolean more = rs.next();
		       
	      // if user does not exist set the isValid variable to false
	      if (!more) 
	      {
	         System.out.println("Sorry, you are not a registered user! Please sign up first");
	         
	      } 
		        
	      //if user exists set the isValid variable to true
	      else if (more) 
	      {
	        salt=rs.getInt("SALT");
	      }
	   } 

	   catch (Exception ex) 
	   {
	      System.out.println("Log In failed: An Exception has occurred! " + ex);
	   } 
		    
	   //some exception handling
	   finally 
	   {
	      if (rs == null)	{
	         try {
	            rs.close();
	         } catch (Exception e) {}
	           
	         }
		
	      if (stmt != null) {
	         try {
	            stmt.close();
	         } catch (Exception e) {}
	            stmt = null;
	         }
		
	      if (currentCon != null) {
	         try {
	            currentCon.close();
	         } catch (Exception e) {
	         }

	         currentCon = null;
	      }
	   }


	   
	  return salt; 
   }
   public int getHash(UserBean bean)
   {
	   int hval=0;
	   Statement stmt = null; 
	   String userid = bean.getUserid(); 
	   String searchQuery =
	            "select HASHVALUE from prayas.login where id='"
	                     + userid
	                     + "'";
	                     
	   try 
	   {
	      //connect to DB 
		   ConnectionManager  cm=new ConnectionManager();
		      currentCon = cm.getConnection();
	      stmt=currentCon.createStatement();
	      rs = stmt.executeQuery(searchQuery);	        
	      boolean more = rs.next();
		       
	      // if user does not exist set the isValid variable to false
	      if (!more) 
	      {
	         System.out.println("Sorry, you are not a registered user! Please sign up first");
	         
	      } 
		        
	      //if user exists set the isValid variable to true
	      else if (more) 
	      {
	        hval=rs.getInt("HASHVALUE");
	      }
	   } 

	   catch (Exception ex) 
	   {
	      System.out.println("Log In failed: An Exception has occurred! " + ex);
	   } 
		    
	   //some exception handling
	   finally 
	   {
	      if (rs == null)	{
	         try {
	            rs.close();
	         } catch (Exception e) {}
	           
	         }
		
	      if (stmt != null) {
	         try {
	            stmt.close();
	         } catch (Exception e) {}
	            stmt = null;
	         }
		
	      if (currentCon != null) {
	         try {
	            currentCon.close();
	         } catch (Exception e) {
	         }

	         currentCon = null;
	      }
	   }


	   
	  return hval; 
   }
}
