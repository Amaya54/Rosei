package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;

public class getTransactionMoney {
	
	Connection currentCon = null;
	Connection currentCon1 = null;
	public double getbv(BeanMessTransaction bmt,String d,String mid) throws ServletException, java.io.IOException, ParseException
	{
	
	PreparedStatement ps=null,ps1=null;
	ResultSet rs=null,rs1=null;
	int val=0;
	double amt=0;
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    Date fdt=format.parse(d);
    DateFormat format0=new SimpleDateFormat("EEE"); 
    String day=format0.format(fdt);
	
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="b"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"v";
	System.out.println(t1);
	
	String sql1="select count(*) from prayas."+t1+" where date='"+d.substring(0,10)+"'";
	String sql2="select b"+mid.substring(3,4)+"v from prayas.mealprice where day='"+day.toLowerCase()+"'";
	System.out.println(sql2);
	ConnectionManager cm=new ConnectionManager();
	ConnectionManager cm1=new ConnectionManager();
	currentCon = cm.getConnection();
	currentCon1 = cm1.getConnection();
	
	try
	{  
	   ps = currentCon.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=rs.getInt(1);
		   bmt.setValid(true);
		  
	   }
	  
	  ps1 = currentCon1.prepareStatement(sql2);
	   rs1 = ps1.executeQuery();
	   
	  while(rs1.next())
	   {
		   System.out.println("rs1 "+rs1.getDouble(1));
		   amt=val*rs1.getDouble(1);
		   bmt.setValid(true);
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
	            
	            if(ps != null)
	                ps.close();
	            if(ps1 != null)
	                ps1.close();
	            
	            if(currentCon != null)
	                currentCon.close();
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        
	   	        } catch (SQLException e) {}

	}
	return amt;
}
	
	public double getbn(BeanMessTransaction bmt,String d,String mid) throws ServletException, java.io.IOException, ParseException
	{
	
	PreparedStatement ps=null,ps1=null;
	ResultSet rs=null,rs1=null;
	int val=0;
	double amt=0;
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    Date fdt=format.parse(d);
    DateFormat format0=new SimpleDateFormat("EEE"); 
    String day=format0.format(fdt);
	
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="b"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"n";
	System.out.println(t1);
	
	String sql1="select count(*) from prayas."+t1+" where date='"+d.substring(0,10)+"'";
	String sql2="select b"+mid.substring(3,4)+"n from prayas.mealprice where day='"+day.toLowerCase()+"'";
	System.out.println(sql2);

	ConnectionManager cm=new ConnectionManager();
	ConnectionManager cm1=new ConnectionManager();
	currentCon = cm.getConnection();
	currentCon1 = cm1.getConnection();
	
	try
	{  
	   ps = currentCon.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=rs.getInt(1);
		   bmt.setValid(true);
	   }
	  
	  ps1 = currentCon1.prepareStatement(sql2);
	   rs1 = ps1.executeQuery();
	   
	  while(rs1.next())
	   {
		   System.out.println("rs1 "+rs1.getDouble(1));
		   amt=val*rs1.getDouble(1);
		   bmt.setValid(true);
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
	            
	            if(ps != null)
	                ps.close();
	            if(ps1 != null)
	                ps1.close();
	            
	            if(currentCon != null)
	                currentCon.close();
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        
	   	        } catch (SQLException e) {}

	}
	return amt;
	}
	public double getlv(BeanMessTransaction bmt,String d,String mid) throws ServletException, java.io.IOException, ParseException
	{
	
	PreparedStatement ps=null,ps1=null;
	ResultSet rs=null,rs1=null;
	int val=0;
	double amt=0;
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    Date fdt=format.parse(d);
    DateFormat format0=new SimpleDateFormat("EEE"); 
    String day=format0.format(fdt);
	
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="l"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"v";
	System.out.println(t1);
	
	String sql1="select count(*) from prayas."+t1+" where date='"+d.substring(0,10)+"'";
	String sql2="select l"+mid.substring(3,4)+"v from prayas.mealprice where day='"+day.toLowerCase()+"'";
	System.out.println(sql2);

	ConnectionManager cm=new ConnectionManager();
	ConnectionManager cm1=new ConnectionManager();
	currentCon = cm.getConnection();
	currentCon1 = cm1.getConnection();
	
	try
	{  
	   ps = currentCon.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=rs.getInt(1);
		   bmt.setValid(true);
	   }
	  
	  ps1 = currentCon1.prepareStatement(sql2);
	   rs1 = ps1.executeQuery();
	   
	  while(rs1.next())
	   {
		   System.out.println("rs1 "+rs1.getDouble(1));
		   amt=val*rs1.getDouble(1);
		   bmt.setValid(true);
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
	            
	            if(ps != null)
	                ps.close();
	            if(ps1 != null)
	                ps1.close();
	            
	            if(currentCon != null)
	                currentCon.close();
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        
	   	        } catch (SQLException e) {}

	}
	return amt;
}

	public double getln(BeanMessTransaction bmt,String d,String mid) throws ServletException, java.io.IOException, ParseException
	{
	
	PreparedStatement ps=null,ps1=null;
	ResultSet rs=null,rs1=null;
	int val=0;
	double amt=0;
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    Date fdt=format.parse(d);
    DateFormat format0=new SimpleDateFormat("EEE"); 
    String day=format0.format(fdt);
	
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="l"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"n";
	System.out.println(t1);
	
	String sql1="select count(*) from prayas."+t1+" where date='"+d.substring(0,10)+"'";
	String sql2="select l"+mid.substring(3,4)+"n from prayas.mealprice where day='"+day.toLowerCase()+"'";
	System.out.println(sql2);

	ConnectionManager cm=new ConnectionManager();
	ConnectionManager cm1=new ConnectionManager();
	currentCon = cm.getConnection();
	currentCon1 = cm1.getConnection();
	
	try
	{  
	   ps = currentCon.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=rs.getInt(1);
		   bmt.setValid(true);
	   }
	  
	  ps1 = currentCon1.prepareStatement(sql2);
	   rs1 = ps1.executeQuery();
	   
	  while(rs1.next())
	   {
		   System.out.println("rs1 "+rs1.getDouble(1));
		   amt=val*rs1.getDouble(1);
		   bmt.setValid(true);
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
	            
	            if(ps != null)
	                ps.close();
	            if(ps1 != null)
	                ps1.close();
	            
	            if(currentCon != null)
	                currentCon.close();
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        
	   	        } catch (SQLException e) {}

	}
	return amt;
}

	public double getdv(BeanMessTransaction bmt,String d,String mid) throws ServletException, java.io.IOException, ParseException
	{
	
	PreparedStatement ps=null,ps1=null;
	ResultSet rs=null,rs1=null;
	int val=0;
	double amt=0;
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    Date fdt=format.parse(d);
    DateFormat format0=new SimpleDateFormat("EEE"); 
    String day=format0.format(fdt);
	
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="d"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"v";
	System.out.println(t1);
	
	String sql1="select count(*) from prayas."+t1+" where date='"+d.substring(0,10)+"'";
	String sql2="select d"+mid.substring(3,4)+"v from prayas.mealprice where day='"+day.toLowerCase()+"'";
	System.out.println(sql2);

	ConnectionManager cm=new ConnectionManager();
	ConnectionManager cm1=new ConnectionManager();
	currentCon = cm.getConnection();
	currentCon1 = cm1.getConnection();
	try
	{  
	   ps = currentCon.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=rs.getInt(1);
		   bmt.setValid(true);
	   }
	  
	  ps1 = currentCon1.prepareStatement(sql2);
	   rs1 = ps1.executeQuery();
	   
	  while(rs1.next())
	   {
		   System.out.println("rs1 "+rs1.getDouble(1));
		   amt=val*rs1.getDouble(1);
		   bmt.setValid(true);
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
	            
	            if(ps != null)
	                ps.close();
	            if(ps1 != null)
	                ps1.close();
	            
	            if(currentCon != null)
	                currentCon.close();
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        
	   	        } catch (SQLException e) {}

	}
	return amt;
}

	public double getdn(BeanMessTransaction bmt,String d,String mid) throws ServletException, java.io.IOException, ParseException
	{
	
	PreparedStatement ps=null,ps1=null;
	ResultSet rs=null,rs1=null;
	int val=0;
	double amt=0;
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    Date fdt=format.parse(d);
    DateFormat format0=new SimpleDateFormat("EEE"); 
    String day=format0.format(fdt);
	
	System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="d"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"n";
	System.out.println(t1);
	
	String sql1="select count(*) from prayas."+t1+" where date='"+d.substring(0,10)+"'";
	String sql2="select d"+mid.substring(3,4)+"n from prayas.mealprice where day='"+day.toLowerCase()+"'";
	System.out.println(sql2);

	ConnectionManager cm=new ConnectionManager();
	ConnectionManager cm1=new ConnectionManager();
	currentCon = cm.getConnection();
	currentCon1 = cm1.getConnection();
	try
	{  
	   ps = currentCon.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	  while(rs.next())
	   {
		   System.out.println("abc"+rs.getInt(1));
		   val=rs.getInt(1);
		 bmt.setValid(true);
	   }
	  
	  ps1 = currentCon1.prepareStatement(sql2);
	   rs1 = ps1.executeQuery();
	   
	  while(rs1.next())
	   {
		   System.out.println("rs1 "+rs1.getDouble(1));
		   amt=val*rs1.getDouble(1);
		   bmt.setValid(true);
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
	            
	            if(ps != null)
	                ps.close();
	            if(ps1 != null)
	                ps1.close();
	            
	            if(currentCon != null)
	                currentCon.close();
	            if(currentCon1 != null)
	                currentCon1.close();
	   	        
	   	        } catch (SQLException e) {}

	}
	return amt;
}


	public int getmoney(BeanMessTransaction bmt,String d,String mid) throws ServletException, java.io.IOException, ParseException
	{
		int m=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String t=d.substring(8,10)+"/"+d.substring(5,7)+"/"+d.substring(0,4);
		String sql1="select transaction_amount from prayas.account_deposite where transaction_date LIKE '"+t+"%' and messid='"+mid+"'";

		ConnectionManager cm=new ConnectionManager();
		
		currentCon = cm.getConnection();
		
		try
		{  
		   ps = currentCon.prepareStatement(sql1);
		   rs = ps.executeQuery();
		   
		  while(rs.next())
		   {			 
			   m=m+rs.getInt(1);
			 bmt.setValid(true);
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
		            
		            if(currentCon != null)
		                currentCon.close();
		            
		   	        } catch (SQLException e) {}

		}	
		
		return m;
	}
	

}


	