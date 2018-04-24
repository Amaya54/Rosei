
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.*;

import java.util.*;
import java.text.*;
/**
 * Servlet implementation class LoginServlet
 */


public class ControllerviewRecharge extends HttpServlet{


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
System.out.println("viewrecharge called");

HttpSession ssn=request.getSession();
String b=(String)ssn.getAttribute("currentSessionUserId");
System.out.println(b);
try
{	 
	String t2=request.getParameter("mess");
	
	String t1=b+t2;
	System.out.println(t1);
	BeanviewRecharge viewrecharge = new BeanviewRecharge();
	viewrecharge.setAccountno(t1);
	DaoviewRecharge dvr=new DaoviewRecharge();
	viewrecharge=dvr.create(viewrecharge,request,response);
	if(viewrecharge.getValid())
	{
		response.sendRedirect("http://172.16.2.2:8081/rosei/viewrechargesuccessful.jsp"); //logged-in page      		
	}
  
   else 
    response.sendRedirect("http://172.16.2.2:8081/rosei/viewrechargeunsuccessful.jsp"); //error page 
     } 


catch (Throwable theException) 	    
{
System.out.println(theException); 
}
}
}

