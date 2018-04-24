package Model;
import java.text.*;
import java.util.*;
import java.sql.*;



public class DaoContractorBookingDetail
{
    Connection currentCon = null;
   
   
    Connection currentCon3= null;
  public void getd(BeanContractorBookingDetail bg,String mid)
  {
	  
	   PreparedStatement stmt=null;
	   ResultSet rs=null;
	   
	   String sql="select * from prayas.createcoupon where messid='"+mid+"' order by from_date asc";
	  try
	  {
		  ConnectionManager cm=new ConnectionManager();
	   currentCon = cm.getConnection();
	   stmt = currentCon.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   rs = stmt.executeQuery();
	   rs.last();
	   bg.setFdt(rs.getString(2));
	   bg.setFd(rs.getString(3));
	   bg.setTdt(rs.getString(4));
	   bg.setTd(rs.getString(5));   
	   }
	  
	  
   catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally {
	        try {
	            
	            if(stmt != null)
	                stmt.close();
	            
	            if(currentCon != null)
	                currentCon.close();
	        } catch (SQLException e) {}
	  
 }
   
}
  public String getMessName(String mid)
  {
	   PreparedStatement stmt=null;
	   ResultSet rs=null;
	   String sql="select name from prayas.consumer where id='"+mid+"'";
	   String mname=null;
		  try
		  {
			  ConnectionManager cm1=new ConnectionManager();
		   currentCon3 =cm1.getConnection();
		   stmt = currentCon3.prepareStatement(sql);
		   rs = stmt.executeQuery();
		   while(rs.next())
		   mname=rs.getString(1);
		   rs.close();
		  }
		  catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally {
		        try {
		            
		            if(stmt != null)
		                stmt.close();
		            
		            if(currentCon3 != null)
		                currentCon3.close();
		        } catch (SQLException e) {}
		  
	 }
	   System.out.println(mname);
	   return mname;
 	  
		  
  }

}
