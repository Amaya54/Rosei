package Model;
import java.text.*;
import java.util.*;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DaoUpdateMenu	
{
	Connection currentCon = null;
 
	
	
   public BeanUpdateMenu update(BeanUpdateMenu bean,HttpServletRequest request) {
	
      
	   
	   String id=request.getParameter("mid") ;
	      
	        
      String q1 ="update prayas."+id+"menu set "+bean.getCategory()+"veg='"+bean.getUpdateveg()+"' where day='"+bean.getDay()+"'";
      String q2 ="update prayas."+id+"menu set "+bean.getCategory()+"nv='"+bean.getUpdatenv()+"' where day='"+bean.getDay()+"'";
      
      System.out.println("HHH"+bean.getUpdateveg()+"\t\t"+bean.getUpdatenv()+bean.getCategory());
      
      
	    
   // "System.out.println" prints in the console; Normally used to trace the process
   
   try 
   {
	   ConnectionManager cm=new ConnectionManager();
	   currentCon = cm.getConnection();
	   Statement statement  = currentCon.createStatement();
	Statement statement1  = currentCon.createStatement();
	System.out.println("I am Here!!");
	   int x,y;
	    if(bean.getUpdateveg()!="" && bean.getUpdatenv()!="")
	    {
	    	System.out.println("asdf");
	   x=statement.executeUpdate(q1);
	   y=statement1.executeUpdate(q2);
	   if(x==1 && y==1){
	   bean.setValid(true);
	     } 
	   else
	   {
		   bean.setValid(false);
	   }
	    }
	    else if(bean.getUpdateveg()!="")
	    {
	    	System.out.println("df");
	 	   x=statement.executeUpdate(q1);
	 	   
	 	   if(x==1){
	 	   bean.setValid(true);
	 	     } 
	 	   else
	 	   {
	 		   System.out.println("gandimara");
	 		   bean.setValid(false);
	 	   }
	 	    }
	    else if(bean.getUpdatenv()!="")
	    {
	    	System.out.println("f");
	 	   y=statement1.executeUpdate(q2);
	 	   if(y==1){
	 	   bean.setValid(true);
	 	     } 
	 	   else
	 	   {
	 		   bean.setValid(false);
	 	   }
	 	    }
	    else
	    	bean.setValid(false);
   }
   catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally {
	        try {
	            
	            
	                currentCon.close();
	        } catch (SQLException e) {}
	  
 }
   return bean;
}
}
   
