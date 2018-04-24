
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


public class ControllerUpdateMealPrice extends HttpServlet{


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
System.out.println("called");

try
{	 
	String day=request.getParameter("day") ;
	String category=request.getParameter("category") ;
	String updateveg=request.getParameter("updateveg") ;
	String updatenv=request.getParameter("updatenv") ;
	
	
     BeanUpdateMealPrice bean = new BeanUpdateMealPrice();
     bean.setDay(day);
     bean.setCategory(category);
     bean.setUpdateveg(updateveg);
     bean.setUpdatenv(updatenv);
          
    
     DaoUpdateMealPrice dump=new DaoUpdateMealPrice();
    	bean =dump.update(bean,request);
    	  if(bean.getValid())
    	  {
        
        response.sendRedirect("http://172.16.2.2:8081/rosei/updated.jsp"); //logged-in page      		
   }
	        
   else 
        response.sendRedirect("http://172.16.2.2:8081/rosei/notupdated.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
   System.out.println(theException); 
}
}
}
