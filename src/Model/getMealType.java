package Model;
import java.sql.*;
public class getMealType {
	//Connection currentCon = null;
	//Connection currentCon1 = null;
	
	public String getb(String d,String sid,String mid,Connection currentCon)
	{
	
	PreparedStatement ps=null,ps1=null;
	ResultSet rs=null,rs1=null;
	String val=null;
	//System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="b"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"v";
	String t2="b"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"n";
	//System.out.println(t1+" "+t2);
	String sql1="select booking_id from prayas."+t1+" where student_id='"+sid+"' and date='"+d.substring(0,10)+"'";
	String sql2="select booking_id from prayas."+t2+" where student_id='"+sid+"' and date='"+d.substring(0,10)+"'";
	//ConnectionManager cm=new ConnectionManager();
	//currentCon = cm.getConnection();
	//ConnectionManager cm1=new ConnectionManager();
	//currentCon1 = cm1.getConnection();
	
	try
	{  
	   ps = currentCon.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	   ps1 = currentCon.prepareStatement(sql2);
	   rs1= ps1.executeQuery();
	   
	   if(rs.next()==true)
	   {
		   //System.out.println(rs.getString(1));
		   val="VEG";
	   }
	   else if(rs1.next()==true)
	   {
		   //System.out.println(rs1.getString(1));
		   val="NVEG";
	   }
	   else
		   val="****";
	   
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
	            
	   
	           } catch (SQLException e) {}

	}
	return val;
}
	

	public String getl(String d,String sid,String mid,Connection currentCon)
	{
	
	PreparedStatement ps=null,ps1=null;
	ResultSet rs=null,rs1=null;
	String val=null;
	//System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="l"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"v";
	String t2="l"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"n";
	//System.out.println(t1+" "+t2);
	String sql1="select booking_id from prayas."+t1+" where student_id='"+sid+"' and date='"+d.substring(0,10)+"'";
	String sql2="select booking_id from prayas."+t2+" where student_id='"+sid+"' and date='"+d.substring(0,10)+"'";
	//ConnectionManager cm=new ConnectionManager();
	//currentCon = cm.getConnection();
	//ConnectionManager cm1=new ConnectionManager();
	// currentCon = cm.getConnection();
	
	try
	{  
	   ps = currentCon.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	   ps1 = currentCon.prepareStatement(sql2);
	   rs1= ps1.executeQuery();
	   
	   if(rs.next()==true)
	   {
		//   System.out.println(rs.getString(1));
		   val="VEG";
	   }
	   else if(rs1.next()==true)
	   {
		  // System.out.println(rs1.getString(1));
		   val="NVEG";
	   }
	   else
		   val="****";
	   
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
	            
	            
	        } catch (SQLException e) {}

	}
	return val;
}
	

	public String getd(String d,String sid,String mid,Connection currentCon)
	{
	
	PreparedStatement ps=null,ps1=null;
	ResultSet rs=null,rs1=null;
	String val=null;
	//System.out.println("hii"+d.substring(0,10)+" "+mid);
	String t1="d"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"v";
	String t2="d"+mid.substring(3,4)+d.substring(5,7)+d.substring(2,4)+"n";
	//System.out.println(t1+" "+t2);
	String sql1="select booking_id from prayas."+t1+" where student_id='"+sid+"' and date='"+d.substring(0,10)+"'";
	String sql2="select booking_id from prayas."+t2+" where student_id='"+sid+"' and date='"+d.substring(0,10)+"'";
	// ConnectionManager cm=new ConnectionManager();
	// currentCon = cm.getConnection();
	// ConnectionManager cm1=new ConnectionManager();
	// currentCon = cm.getConnection();
	
	try
	{  
	   ps = currentCon.prepareStatement(sql1);
	   rs = ps.executeQuery();
	   
	   ps1 = currentCon.prepareStatement(sql2);
	   rs1= ps1.executeQuery();
	   
	   if(rs.next()==true)
	   {
	//	   System.out.println(rs.getString(1));
		   val="VEG";
	   }
	   else if(rs1.next()==true)
	   {
		//   System.out.println(rs1.getString(1));
		   val="NVEG";
	   }
	   else
		   val="****";
	   
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
	            
	            } catch (SQLException e) {}

	}
	return val;
}
}
