package Model;
import java.text.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.*;



public class DaoRecharge extends HttpServlet
{
    Connection currentCon = null;
   
	
	
   public  BeanRecharge create(BeanRecharge br,HttpServletRequest request, HttpServletResponse response) {
	   System.out.println("inside create");
	   PreparedStatement stmt=null,stmt3=null;
	   ResultSet rs=null,rs1=null,rs2=null;
	   Statement stmt2=null;
	   int a=0;
	   int accbal=0;
	   int amt=br.getAmount();
	   System.out.println(amt);
	   String accno=null;
	   String mid=null;
	   String mname=null;
      String sid=br.getStudentId();
      System.out.println(sid);
      HttpSession session = request.getSession(true);
      accno=sid+(String)session.getAttribute("currentSessionUserId");
      System.out.println("Here"+accno);
      mid=(String)session.getAttribute("currentSessionUserId");
      
      
      PreparedStatement ps=null;
      try
      {
    	  ConnectionManager cm=new ConnectionManager();
      currentCon=cm.getConnection();
      
      String sql1="select available_money from prayas.account where account_no='"+accno+"'";
      stmt=currentCon.prepareStatement(sql1);
      rs1=stmt.executeQuery();
      while ( rs1.next() ) {
      a=rs1.getInt(1);
      accbal=a+amt;
      }
      
      System.out.println(accno);
      br.setAccountNo(accno);
      String msql="select name from prayas.login where id='"+mid+"'";
      stmt3=currentCon.prepareStatement(msql);
      rs2=stmt3.executeQuery();
      
      while ( rs2.next() ) {
          mname=rs2.getString(1);
          }
     
      System.out.println(mname);
      br.setMessName(mname);
      
      String q1 ="update prayas.account set available_money='"+accbal+"' where account_no='"+accno+"'";
      String q2 ="insert into account_deposite values(?,?,?,?)";
      
      
      
      stmt2=currentCon.createStatement();
      int x=stmt2.executeUpdate(q1);
      
      ps=currentCon.prepareStatement(q2);
      ps.setString(1,accno);
      ps.setString(2, br.getDate());
      ps.setInt(3, amt);
      ps.setString(4,(String)session.getAttribute("currentSessionUserId"));

      boolean y=ps.execute(); 
      ps.close();
     
   if ((x==1)&&!y) 
   {
 	  
 	  br.setValid(true);
 	 br.setFamt(accbal);
      System.out.print("Recharge Successful");
 	  
   } 
	        
   //if user exists set the isValid variable to true
   else 
   {
   	  System.out.print("Unsucessful");
   	  
    
   br.setValid(false);
      
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
	            
	            if(ps != null)
	                ps.close();
	            
	            if(currentCon != null)
	                currentCon.close();
	        } catch (SQLException e) {}
	  
 }
   return br;
}
}

