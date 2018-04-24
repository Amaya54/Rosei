package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getCount {
	
	Connection currentCon1 = null;
	
	public String getbv(String d,String mid)
	{
	
	PreparedStatement ps=null;
	ResultSet rs=null;
	String val=null;
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="b"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"v";
	System.out.println(t1);
	
	String sql1="select count(*) from (select unique student_id,date from prayas."+t1+" where date='"+d.substring(0,10)+"')";
	ConnectionManager cm=new ConnectionManager();
	currentCon1 = cm.getConnection1();
	
	
	try
	{  
	   ps = currentCon1.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=""+rs.getInt(1);
	   }
	   
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
	            
	            if(ps != null)
	                ps.close();
	            
	            
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        } catch (SQLException e) {}

	}
	return val;
}

	public String getbn(String d,String mid)
	{
	
	PreparedStatement ps=null;
	ResultSet rs=null;
	String val=null;
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="b"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"n";
	System.out.println(t1);
	
	String sql1="select count(*) from (select unique student_id,date from prayas."+t1+" where date='"+d.substring(0,10)+"')";
	
	ConnectionManager cm=new ConnectionManager();
	currentCon1 = cm.getConnection1();
	
	
	try
	{  
	   ps = currentCon1.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=""+rs.getInt(1);
	   }
	   
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
	            
	            if(ps != null)
	                ps.close();
	            
	            
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        } catch (SQLException e) {}

	}
	return val;
}
	
	public String getlv(String d,String mid)
	{
	
	PreparedStatement ps=null;
	ResultSet rs=null;
	String val=null;
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="l"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"v";
	System.out.println(t1);
	
	String sql1="select count(*) from (select unique student_id,date from prayas."+t1+" where date='"+d.substring(0,10)+"')";
	ConnectionManager cm=new ConnectionManager();
	currentCon1 = cm.getConnection1();
	
	
	try
	{  
	   ps = currentCon1.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=""+rs.getInt(1);
	   }
	   
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
	            
	            if(ps != null)
	                ps.close();
	            
	            
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        } catch (SQLException e) {}

	}
	return val;
}
	
	public String getln(String d,String mid)
	{
	
	PreparedStatement ps=null;
	ResultSet rs=null;
	String val=null;
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="l"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"n";
	System.out.println(t1);
	
	String sql1="select count(*) from (select unique student_id,date from prayas."+t1+" where date='"+d.substring(0,10)+"')";
	ConnectionManager cm=new ConnectionManager();
	currentCon1 = cm.getConnection1();
	
	
	try
	{  
	   ps = currentCon1.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=""+rs.getInt(1);
	   }
	   
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
	            
	            if(ps != null)
	                ps.close();
	            
	            
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        } catch (SQLException e) {}

	}
	return val;
}
	public String getdv(String d,String mid)
	{
	
	PreparedStatement ps=null;
	ResultSet rs=null;
	String val=null;
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="d"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"v";
	System.out.println(t1);
	
	String sql1="select count(*) from (select unique student_id,date from prayas."+t1+" where date='"+d.substring(0,10)+"')";
	ConnectionManager cm=new ConnectionManager();
	currentCon1 = cm.getConnection1();
	
	
	try
	{  
	   ps = currentCon1.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=""+rs.getInt(1);
	   }
	   
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
	            
	            if(ps != null)
	                ps.close();
	            
	            
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        } catch (SQLException e) {}

	}
	return val;
}
	public String getdn(String d,String mid)
	{
	
	PreparedStatement ps=null;
	ResultSet rs=null;
	String val=null;
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="d"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"n";
	System.out.println(t1);
	
	String sql1="select count(*) from (select unique student_id,date from prayas."+t1+" where date='"+d.substring(0,10)+"')";
	ConnectionManager cm=new ConnectionManager();
	currentCon1 = cm.getConnection1();
	
	
	try
	{  
	   ps = currentCon1.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=""+rs.getInt(1);
	   }
	   
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
	            
	            if(ps != null)
	                ps.close();
	            
	            
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        } catch (SQLException e) {}

	}
	return val;
}
}
