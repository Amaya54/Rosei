package Model;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;

public class getStudentArray {
	 public int i=0;
	 Connection currentCon = null;
	public ArrayList<String> getStId (String p,String mid)
	{
		 ArrayList<String> stid=new ArrayList<String>();
		 String sql="select id from booking where bookingid like'"+p+"%' and messid='"+mid+"' group by id";
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

