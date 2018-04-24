package Model;
import java.text.*;
import java.util.*;
import java.sql.*;



public class DaoGeneratePdf
{
	Connection currentCon = null;
   
    Connection currentCon1= null;
    Connection currentCon2= null;
    Connection currentCon3= null;
   public String gen=null;
  public  void getd(BeanGeneratePdf bg,String mid,Connection currentCon)
  {
	  
	   PreparedStatement stmt=null;
	   ResultSet rs=null;
	   
	   String sql="select * from prayas.createcoupon where messid='"+mid+"' order by from_date asc";
	  try
	  {
		  //ConnectionManager cm=new ConnectionManager();
	   //currentCon = cm.getConnection();
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
	            
	            
	        } catch (SQLException e) {}
	  
 }
   
}
   public double balance (String sid,String mid,Connection currentCon)
   {
	   //System.out.println("vicky inside balance");
	   PreparedStatement stmt=null;
	   ResultSet rs=null,rs1=null;
	   String accno=sid+mid;
	   double amt=0;
	   //amy String sql="select available_money from prayas.account where account_no='"+accno+"'";
	  String sql1="select from_date from prayas.createcoupon where messid='"+mid+"' order by from_date asc";
	  PreparedStatement ps1=null;
	  Connection con1=null,con2=null;
	  ConnectionManager cm2=new ConnectionManager();
	  ConnectionManager cm3=new ConnectionManager();
	  con1 = cm2.getConnection();
	  con2 = cm3.getConnection();
	   System.out.print("amy"+accno);
	   try
	   {
		 //amy  currentCon1 = ConnectionManager.getConnection();
		 //amy  stmt = currentCon1.prepareStatement(sql);
		 //amy  rs = stmt.executeQuery();
		//amy   while(rs.next())
		 //amy   amt=rs.getInt(1);
		   
			ps1 = con1.prepareStatement(sql1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    rs1 = ps1.executeQuery();
			rs1.last();
			
		String sql="select amount from prayas.bookingamount where student_id='"+sid+"' and messid='"+mid+"' and from_date='"+rs1.getString(1)+"'";
			
			stmt = con2.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				amt=amt+rs.getDouble(1);
			}
		   rs.close();
		   rs1.close();
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
		            
		            if(currentCon1 != null)
		                currentCon1.close();
		            if(ps1 != null)
		                ps1.close();
		            
		            if(con1 != null)
		                con1.close();
		            if(con2 != null)
		                con2.close();
		        } catch (SQLException e) {}
		  
	 }
	   System.out.println(amt);
	   return amt;
   }
   
   public String getStudentName(String sid)
   {
	   PreparedStatement stmt=null;
	   ResultSet rs=null;
	   String sql="select name,gender from prayas.consumer where id='"+sid+"'";
	   String sname=null;
		  try
		  {
			  ConnectionManager cm4=new ConnectionManager();
		   currentCon2 = cm4.getConnection();
		   stmt = currentCon2.prepareStatement(sql);
		   rs = stmt.executeQuery();
		   while(rs.next())
		   {
		   sname=rs.getString(1);
		   gen=rs.getString(2);
		   }
		   //System.out.print("student name"+sname);
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
		            
		            if(currentCon2 != null)
		                currentCon2.close();
		        } catch (SQLException e) {}
		  
	 }
	   //System.out.println(sname);
	   return sname;
  	  
		  
   }
   public String getgen()
   {
	   return gen;
   }
   public String getMessName(String mid)
   {
	   PreparedStatement stmt=null;
	   ResultSet rs=null;
	   String sql="select name from prayas.consumer where id='"+mid+"'";
	   String mname=null;
		  try
		  {
			  ConnectionManager cm=new ConnectionManager();
		   currentCon3 = cm.getConnection();
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
	//  System.out.println(mname);
	   return mname;
  	  
		  
   }
}
  


