
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


public class ControllerRecharge extends HttpServlet{



public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
System.out.println("recharge called");

try
{	 
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   
    String t1=dateFormat.format(date);
    System.out.println(t1);
	String t2=request.getParameter("stdid");
	String a=request.getParameter("amt");
	int amount=Integer.parseInt(a);
	
	BeanRecharge recharge=new BeanRecharge();
	recharge.setStudentId(t2);
	recharge.setAmount(amount);
	recharge.setDate(t1);
	DaoRecharge dr=new DaoRecharge();
	recharge=dr.create(recharge, request,response);
	
	
	
    	  if(recharge.getValid())
    	  {
        //Model.sendmail.sendrecharge(recharge);
    		  Model.generatereceipt gr=new generatereceipt();
    		  gr.rechargereceipt(recharge, request, response);
        
    		  
   }
	        
   else 
        response.sendRedirect("http://172.16.2.2:8081/rosei/rechargeunsuccessful.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
   System.out.println(theException); 
}
}


}

