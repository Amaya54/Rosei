
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


public class ControllerCreateCoupon extends HttpServlet{


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
System.out.println("called");

try
{	 
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   
    String t1=dateFormat.format(date);
    System.out.println(t1);
      
   String from_date=request.getParameter("fd") ;
	String to_date=request.getParameter("td") ;
	System.out.println(from_date);

	
	
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    Date fdt=format.parse(from_date);
    DateFormat format0=new SimpleDateFormat("EEE"); 
    String fday=format0.format(fdt);
    System.out.println("madarchod"+fday);
    

    SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
    Date tdt=format1.parse(to_date);
    DateFormat format2=new SimpleDateFormat("EEE"); 
    String tday=format2.format(tdt);
    System.out.println("madarchod"+tday);
    
	
	
	BeanCreateCoupon coupon=new BeanCreateCoupon();   
	coupon.setDate(t1);
	coupon.setFdate(from_date);
    coupon.setTdate(to_date);
    coupon.setFday(fday);
    coupon.setTday(tday);
    DaoCreateCoupon dcc=new DaoCreateCoupon();
    	coupon =dcc.create(coupon, request,response);
    	  if(coupon.getValid())
    	  {
        
        response.sendRedirect("http://172.16.2.2:8081/rosei/couponcreated.jsp"); //logged-in page      		
   }
	        
   else 
        response.sendRedirect("http://172.16.2.2:8081/rosei/invalidcoupon.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
   System.out.println(theException); 
}
}
}
