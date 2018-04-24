package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LoginPackage.UserBean;
import LoginPackage.UserDAO;
import LoginPackage.hashing;
import Model.BeanUpdatePassword;
import Model.ConnectionManager;
import Model.DaoUpdatePassword;
import Model.hash;

public class ControllerDeleteUser extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {


try
{	 
	Connection currentCon = null;
	
	String uid=request.getParameter("id") ;
	
	String npwd=request.getParameter("pw") ;
	int hashval,salt;
	salt=hash.getSalt(); 
    hashval= hash.getHash(npwd, salt);
    ConnectionManager cm=new ConnectionManager();
   	String sql="UPDATE prayas.login set salt='"+salt+"',hashvalue='"+hashval+"' where id='"+uid+"'";   
  
	currentCon=cm.getConnection();
	Statement statement  = currentCon.createStatement();
	   int x=statement.executeUpdate(sql);
   	
   	if(x==1)
	        
	          response.sendRedirect("http://172.16.2.2:8081/rosei/userpasswordbyadmin.jsp"); //logged-in page      		
	          
	  	        
	     else 
	          response.sendRedirect("http://172.16.2.2:8081/rosei/updatepasswordunsuccessful.jsp"); //error page 

	
	    
	    
	    


}		
catch (Throwable theException) 	    
{
   System.out.println(theException); 
}


finally {
      
}


}	
}
