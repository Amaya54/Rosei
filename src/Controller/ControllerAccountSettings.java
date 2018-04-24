package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LoginPackage.UserBean;
import LoginPackage.UserDAO;
import LoginPackage.hashing;
import Model.*;


public class ControllerAccountSettings extends HttpServlet{
	
	Connection currentCon = null;
	Connection currentCon1 = null;
public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {


try
{	 
	
	HttpSession session = request.getSession(true);
	String uid=(String)session.getAttribute("currentSessionUserId") ;
	String opwd=request.getParameter("opw") ;
	String npwd=request.getParameter("npw") ;
	String nm=request.getParameter("nm") ;
	String add=request.getParameter("add") ;
	String gen=request.getParameter("gen") ;
	String con=request.getParameter("con") ;
	
	if (opwd!=null && npwd!=null)
	{
		int hashval,chash,salt;
	     UserBean user1 = new UserBean();
	     user1.setUserid(uid);
	     
	     UserDAO ud=new UserDAO();
		salt=ud.getSalt(user1);  
		chash=hashing.getHash(opwd,salt);
		hashval=ud.getHash(user1);
		System.out.println(chash+"\n");
		System.out.println(hashval+"\n");
	    /*if(chash==-18)
	    	response.sendRedirect("http://172.16.2.2:8081/rosei/fuckYou.jsp"); //error page*/
		int in;
		char st;
		for(int l=0;l<opwd.length()-1;l++)
		{
	    st= opwd.charAt(l);
	    in =(int)st;
	    if(in==39 || in==61)
	    {
	    	response.sendRedirect("http://172.16.2.2:8081/rosei/fuckYou.jsp"); //error page*/
		break;
	    }
		}
	    		
	   
	    if(hashval==chash)
	        {
	        	user1=ud.login(user1);
	        	hashval=hash.getHash(npwd,salt);
	            BeanUpdatePassword bean = new BeanUpdatePassword();
	            bean.setUserid(uid);         
	            bean.setSalt(salt);
	            bean.setHash(hashval);
	            DaoUpdatePassword dup=new DaoUpdatePassword();
	            bean =dup.create(bean);
	            if(bean.getValid())
	        
	          response.sendRedirect("http://172.16.2.2:8081/rosei/updatepasswordsuccessful.jsp"); //logged-in page      		
	          
	  	        
	     else 
	          response.sendRedirect("http://172.16.2.2:8081/rosei/updatepasswordunsuccessful.jsp"); //error page 

	
	        }
	    else 
	          response.sendRedirect("http://172.16.2.2:8081/rosei/updatepasswordunsuccessful.jsp"); //error page 
     
	    
	    


		}
	
	else 
	{
		
		String sql="update prayas.consumer set name='"+nm+"', address='"+add+"', gender='"+gen+"', contact_no='"+con+"' where id='"+uid+"'" ;
		String sql1="update prayas.login set name='"+nm+"' where id='"+uid+"'" ;
		ConnectionManager cm=new ConnectionManager();
		ConnectionManager cm1=new ConnectionManager();
		 currentCon = cm.getConnection();
		 currentCon1 = cm1.getConnection();
		   Statement statement  = currentCon.createStatement();
		   Statement statement1  = currentCon1.createStatement();
		   int x=statement.executeUpdate(sql);
		   int y=statement1.executeUpdate(sql1);
		   if(x==1 && y==1){
			   response.sendRedirect("http://172.16.2.2:8081/rosei/detailsupdated.jsp");
			     } 
			   else
			   {
				   response.sendRedirect("http://172.16.2.2:8081/rosei/detailsnotupdated.jsp");
			   }
	}
	
	
	
}


catch (Throwable theException) 	    
{
   System.out.println(theException); 
}


finally {
      
}
}
}
