
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


public class ControllerviewBookingDetail extends HttpServlet{


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
System.out.println("viewbooking called");

HttpSession ssn=request.getSession();
String a=(String)ssn.getAttribute("currentSessionUserId");
System.out.println(a);
try
{	 
	String t1=request.getParameter("mess");
	String t2=request.getParameter("month");
	String t3=request.getParameter("year");
	String t4=request.getParameter("radio");
	String tn1,tn2;
	tn1=t4+t1+t2+t3+"V";
	tn2=t4+t1+t2+t3+"N";
	System.out.println(tn1+" "+tn2);
	
	BeanviewBookingDetail viewbooking = new BeanviewBookingDetail();
	viewbooking.setTable1(tn1);
	viewbooking.setTable2(tn2);
	viewbooking.setStudentId(a);
	DaoviewBookingDetail dvbd=new DaoviewBookingDetail();
	viewbooking=dvbd.create(viewbooking,request,response);
	
	HttpSession session = request.getSession(true);
	session.setAttribute("date1",viewbooking.getDate1());
	session.setAttribute("date2",viewbooking.getDate2());
	if(viewbooking.getValid())
	{
		response.sendRedirect("http://172.16.2.2:8081/rosei/BookingDetailSuccessful.jsp"); //logged-in page      		
	}
  
   else 
    response.sendRedirect("http://172.16.2.2:8081/rosei/BookingDetailUnsuccessful.jsp"); //error page 
     } 


catch (Throwable theException) 	    
{
System.out.println(theException); 
}
}
}

