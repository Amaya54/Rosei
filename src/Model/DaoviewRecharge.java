package Model;
import java.text.*;
import java.util.*;
import java.sql.*;

import javax.servlet.http.*;



public class DaoviewRecharge extends HttpServlet
{
   Connection currentCon = null;
   
	
	
   public  BeanviewRecharge create(BeanviewRecharge br,HttpServletRequest request, HttpServletResponse response) {
	   System.out.println("inside create");
	   PreparedStatement stmt=null;

	   String accountno=br.getAccountno();
	   
	   
      HttpSession session = request.getSession(true);
      ArrayList<String> adt=new ArrayList<String>();
      ArrayList<Integer> amt=new ArrayList<Integer>();
      
      try
      {
      ResultSet rs1;
      ConnectionManager cm=new ConnectionManager();
      currentCon=cm.getConnection();
      System.out.println(accountno);
      String sql1="select transaction_date,transaction_Amount from prayas.account_deposite where account_no='"+accountno+"'";
      stmt=currentCon.prepareStatement(sql1);
      rs1=stmt.executeQuery();
     
      
      while(rs1.next()){
    		adt.add(rs1.getString(1));
    		amt.add(rs1.getInt(2));
    		
    	 }
      br.setadt(adt);
      br.setamt(amt);
      br.setValid(true);
     System.out.println("after resultset");
   
   }
   catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally {
	        try {
	            
	           
	            
	            if(currentCon != null)
	                currentCon.close();
	           
	        } catch (SQLException e) {}
	  
 }
   return br;
}
}

