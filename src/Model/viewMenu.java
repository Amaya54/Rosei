package Model;

import java.sql.*;

public class viewMenu {
 
	public  String menu(String day,String type,String mid,Connection currentCon )
	{
		String meal=null;
		
		try
	      {
			PreparedStatement stmt=null;
	      
	      ResultSet rs1;
	  
	      
	      String sql="select "+type+"veg, "+type+"nv from prayas."+mid+"menu where day='"+day+"'";
	      stmt=currentCon.prepareStatement(sql);
	      rs1=stmt.executeQuery();
	      rs1.next();
	      if(rs1.getString(1)!=null && rs1.getString(2)!=null)
	      meal=rs1.getString(1)+"/"+rs1.getString(2);
	      else if(rs1.getString(1)!=null)
	    	  meal=rs1.getString(1);
	      else
	    	  meal=rs1.getString(2);
	      
	      rs1.close();
	      }
		
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally {
		        
		  
		   }	 
		return meal;
	}

}
