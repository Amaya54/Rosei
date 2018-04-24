package Model;
import java.text.*;
import java.util.*;
import java.sql.*;

public class DaoCreateUser 	
{
	Connection currentCon = null;
   
	
	
   public BeanCreateUser create(BeanCreateUser bean) {
	
      String[] ar=new String[9];
      int len=0;
      String q1 ="insert into consumer values(?,?,?,?,?,?)";
      String q2 ="insert into login values(?,?,?,?,?)";
      String q3 ="insert into account values(?,?)";
       String q4="select id from login where clientid='contractor'";
       PreparedStatement ps0=null;
       try{
    	   ConnectionManager cm=new ConnectionManager();
       	currentCon = cm.getConnection();
       	
       	
       ps0 = currentCon.prepareStatement(q4);
       ResultSet rs = ps0.executeQuery();
       
       while(rs.next())
       {
    	   ar[len]=bean.getUserid()+rs.getString(1);
    	  len++;   	  
    	 
       }
       rs = ps0.executeQuery();
       
        rs.close(); 
       	 
   }  
       catch(SQLException se){
 	      //Handle errors for JDBC
 	      se.printStackTrace();
 	   }catch(Exception e){
 	      //Handle errors for Class.forName
 	      e.printStackTrace();
 	   }
       
      PreparedStatement ps=null;
      PreparedStatement ps1=null;
      PreparedStatement ps2=null;
     
      
       
   
   try 
   {
      //connect to DB 
	   ConnectionManager cm1=new ConnectionManager();
      currentCon = cm1.getConnection();
      ps=currentCon.prepareStatement(q1);
      ps1=currentCon.prepareStatement(q2);
      ps2=currentCon.prepareStatement(q3);
      
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
      boolean x2=true;
      for(int j=0;j<len;j++)
      {
    	  ps2.setString(1,ar[j]);
          ps2.setDouble(2,0.0);
          x2=ps2.execute();
          x2=x2&x2;
      }
            
   if (!x1 && !x && !x2) 
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
	        	if(ps0 != null)
 	                ps0.close();
	            if(ps != null)
	                ps.close();
	            if(ps1 != null)
	                ps1.close();
	            if(ps2 != null)
	                ps2.close();
	            if(currentCon != null)
	                currentCon.close();
	        } catch (SQLException e) {}
	  
 }
   return bean;
}
}
   

