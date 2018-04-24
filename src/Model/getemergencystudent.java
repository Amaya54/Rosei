package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getemergencystudent {

	 public int i=0;
	 Connection currentCon = null;
	public ArrayList<String> getStId (String p,String mid)
	{
		 ArrayList<String> stid=new ArrayList<String>();
		 String sql="select id from booking where  messid='"+mid+"' and bookingid like '%"+p+"%' and bookingid not like '%"+p+"00%' group by id";
		 PreparedStatement stmt=null;
		   ResultSet rs=null;
		 
		try{
			ConnectionManager cm=new ConnectionManager();
			currentCon = cm.getConnection();
			   stmt = currentCon.prepareStatement(sql);
			   rs = stmt.executeQuery();
	     
	  while(rs.next())
	  {
		  
		  stid.add(rs.getString(1));
		  i++;
	  }
	  
	     
	     
	  rs.close();
	 
	    
		}
		
		catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		finally
		{
			 try {
		            
		            if(stmt != null)
		                stmt.close();
		            
		            if(currentCon != null)
		                currentCon.close();
		        } catch (SQLException e) {}
		}
		
		return stid;
		
	}
	public int getLen()
	{
		return i;
	}
	
	
}
