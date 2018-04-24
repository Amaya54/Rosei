
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.*;

/**
 * Servlet implementation class LoginServlet
 */


public class ControllerCreateUser extends HttpServlet{


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
System.out.println("called");

try
{	 
	String uid=request.getParameter("id") ;
	String pwd=request.getParameter("pw") ;
	String nm=request.getParameter("nm") ;
	String add=request.getParameter("add") ;
	String gen=request.getParameter("gen") ;
	String con=request.getParameter("con") ;
	String cid=request.getParameter("cid") ;
	
	int hashval,chash,salt;
	salt=hash.getSalt();
	hashval=hash.getHash(pwd,salt);
     BeanCreateUser bean = new BeanCreateUser();
     bean.setUserid(uid);
     bean.setName(nm);
     bean.setAddress(add);
     bean.setGender(gen);
     bean.setContact(con);
     bean.setClient(cid);
     bean.setSalt(salt);
     bean.setHash(hashval);
     
     DaoCreateUser dcu=new DaoCreateUser();
     DaoCreateContractor dcc =new DaoCreateContractor();
     DaoCreateAdmin dca=new DaoCreateAdmin();
    if(cid.equals("consumer"))
    	bean =dcu.create(bean);
    else if(cid.equals("contractor"))
    	bean=dcc.create(bean);
    else
    	bean=dca.create(bean);
    
    
    	  if(bean.getValid())
    	  {
        
        response.sendRedirect("http://172.16.2.2:8081/rosei/usercreated.jsp"); //logged-in page      		
   }
	        
   else 
        response.sendRedirect("http://172.16.2.2:8081/rosei/invalidUser.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
   System.out.println(theException); 
}
}
}
