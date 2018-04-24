package Model;

import java.sql.*;

public class status {

	public String getstatus(String dt,char x,String sid,Connection currentCon)
	{
		String dat=dt.substring(0,10);
		String t1=x+"1"+dt.substring(5,7)+dt.substring(2,4)+"v";
		String t2=x+"1"+dt.substring(5,7)+dt.substring(2,4)+"n";
		String t3=x+"2"+dt.substring(5,7)+dt.substring(2,4)+"v";
		String t4=x+"2"+dt.substring(5,7)+dt.substring(2,4)+"n";
		String sql1="select booking_id from "+t1+" where student_id='"+sid+"' and date='"+dat+"'";
		String sql2="select booking_id from "+t2+" where student_id='"+sid+"' and date='"+dat+"'";
		String sql3="select booking_id from "+t3+" where student_id='"+sid+"' and date='"+dat+"'";
		String sql4="select booking_id from "+t4+" where student_id='"+sid+"' and date='"+dat+"'";
		try
		{
			PreparedStatement ps1,ps2,ps3,ps4;
			ResultSet rs1,rs2,rs3,rs4;

			
			
		      
		      ps1=currentCon.prepareStatement(sql1);
		      rs1=ps1.executeQuery();
		      while(rs1.next())
		    	  return "Roseighara-1(V)"; 
		      ps2=currentCon.prepareStatement(sql2);
		      rs2=ps2.executeQuery();
		      while(rs2.next())
		    	  return "Roseighara-1(N)";
		      ps3=currentCon.prepareStatement(sql3);
		      rs3=ps3.executeQuery();
		      while(rs3.next())
		    	  return "Roseighara-2(V)";
		      ps4=currentCon.prepareStatement(sql4);
		      rs4=ps4.executeQuery();
		      while(rs4.next())
		    	  return "Roseighara-2(N)";
		      
		}
		
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		return "Not Issued";
	}

}
