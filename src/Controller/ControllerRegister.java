package Controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ControllerRegister extends HttpServlet {
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException {
	try{
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String dt=dateFormat.format(date);

	Connection con = null;
	Model.ConnectionManager cm=new Model.ConnectionManager();
	con = cm.getConnection();
	String sql="insert into recruit values (?,?,?,?,?)";
	PreparedStatement ps=null;
	

	ps=con.prepareStatement(sql);
	ps.setString(1, request.getParameter("nm"));
	ps.setString(2, request.getParameter("id"));
	ps.setString(3, request.getParameter("email"));
	ps.setString(4, request.getParameter("con"));
	ps.setString(5, dt);

	boolean x=true;
	x=ps.execute();
	if(!x)
	response.sendRedirect("http://172.16.2.2:8081/rosei/registered.jsp");
	else
	response.sendRedirect("http://172.16.2.2:8081/rosei/unregistered.jsp");
	
	}
	catch (Throwable theException) 	    
	{
	   System.out.println(theException); 
	}


	finally {
	      
	}
	}

}
